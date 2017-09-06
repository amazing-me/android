package amazingme.database;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import amazingme.activities.app.MainMenu;

public class FirebaseHelper {

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
        // TODO: store names. also need to create another activity to store more parents and child info.
        // TODO: UI Feedback (dialog box?) for success/failure. Also would this function ever get called outside of RegisterActivity?
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
                                    // TODO: Retry for transient failures
                                    Log.e("Error", "User creation failed");
                                    Log.e("Error Cause", task.getException().getMessage());;
                                }
                            }
                        });
    }

    public static void loginUser(final String email, final String password, final Context context) {
        final FirebaseAuth mAuth = getFirebaseAuthInstance();
        // TODO: UI Feedback (dialog box?) for success/failure. Also would this function ever get called outside of LoginActivity?
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
                            // TODO: Retry for transient failures
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
