package amazingme.database;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import amazingme.activities.app.MainMenu;
import amazingme.activities.app.RegisterActivity;

public class FirebaseHelper {

    //gonna keep this so we can more easily communicate with the firebase

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference reference = database.getReference("message");

    public FirebaseHelper(){
        System.out.println("HERE WE GO");
        reference.setValue("Hello, world");
    }

    public static FirebaseAuth getFirebaseAuthInstance() {
        return FirebaseAuth.getInstance();
    }

    public static FirebaseUser getFirebaseUser() {
        return getFirebaseAuthInstance().getCurrentUser();
    }

    public static void createNewUser(final String firstName,
                                     final String lastName,
                                     final String email,
                                     final String password,
                                     final Context context) {
        final FirebaseAuth mAuth = getFirebaseAuthInstance();
        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Log.d("SUCCESS", "User Created");
                                    final Intent loginIntent = new Intent(context, MainMenu.class);
                                    loginIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                    context.startActivity(loginIntent);
                                } else {
                                    Log.e("Error", "User creation failed");
                                    Log.e("Error Cause", task.getException().getMessage());;
                                }
                            }
                        });
    }

    public static void loginUser(final String email, final String password, final Context context) {
        final FirebaseAuth mAuth = getFirebaseAuthInstance();
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Log.d("Success", "User is signed in successfully");
                            final Intent loginIntent = new Intent(context, MainMenu.class);
                            loginIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            context.startActivity(loginIntent);
                        } else {
                            Log.e("Error", "Failed to sign in user");
                            Log.e("Error", task.getException().getMessage());
                        }
                    }
                });
    }

    public static void signOut() {
        getFirebaseAuthInstance().signOut();
    }

}
