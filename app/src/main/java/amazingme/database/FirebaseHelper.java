package amazingme.database;

import android.content.Intent;
import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

import amazingme.app.SessionManager;
import amazingme.app.UserContext;
import amazingme.controller.LoginHandlingActivity;
import amazingme.controller.RegistrationHandlingActivity;
import amazingme.model.User;

public class FirebaseHelper implements IDatabase, SessionManager {

    private static FirebaseHelper instance;

    public static FirebaseHelper getInstance() {
        if (instance == null) {
            instance = new FirebaseHelper();
        }
        return instance;
    }

    @Override
    public void set(UserContext input) {
        HashMap<String, UserContext> map = new HashMap<>();
        map.put(this.getFirebaseUser().getUid(), input);
        this.databaseReference().setValue(map);
        //for database stuff... almost getting there
    }

    @Override
    public void update() {
        //for database stuff... almost getting there
    }

    @Override
    public void push() {
        //for database stuff... almost getting there
    }

    @Override
    public DataSnapshot get() {
        return null;
    }

    @Override
    public DataSnapshot getUserContext() {
        return null;
    }

    @Override
    public void login(final String email, final String password, final LoginHandlingActivity handler) {
        final FirebaseAuth mAuth = getFirebaseAuthInstance();

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        handler.handle(task);
                    }
                });
    }

    @Override
    public void logout() {
        getFirebaseAuthInstance().signOut();
    }

    @Override
    public void createUser(final String email, final String password, final RegistrationHandlingActivity handler) {
        final FirebaseAuth mAuth = getFirebaseAuthInstance();
        // TODO: store names. also need to create another activity to store more parents and child info.
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        handler.handle(task);
                    }
                });
    }

    @Override
    public boolean isActive() {
        return this.getFirebaseUser() != null;
    }


    private FirebaseAuth getFirebaseAuthInstance() {
        return FirebaseAuth.getInstance();
    }

    private FirebaseUser getFirebaseUser() {
        return getFirebaseAuthInstance().getCurrentUser();
    }

    private DatabaseReference databaseReference() {
        return FirebaseDatabase.getInstance().getReference();
    }
}
