package amazingme.database;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import amazingme.app.SessionManager;
import amazingme.app.UserContext;
import amazingme.controller.LoginHandlingActivity;
import amazingme.controller.RegistrationHandlingActivity;

public class FirebaseHelper implements IDatabase, SessionManager {

    private static FirebaseHelper instance;

    public static FirebaseHelper getInstance() {
        if (instance == null) {
            instance = new FirebaseHelper();
        }
        return instance;
    }

    @Override
    public void set(final UserContext userContext) {
        final String uid = getFirebaseUser().getUid();

        getUserDatabaseReference(uid).setValue(userContext);
    }

    @Override
    public void update() {
        // TODO: Implement
    }

    @Override
    public void push() {
        // TODO: Implement
    }

    @Override
    public DataSnapshot get() {
        // TODO: Implement
        return null;
    }

    @Override
    public DataSnapshot getUserContext() {
        // TODO: Implement
        return null;
    }

    @Override
    public void login(final String email, final String password, final LoginHandlingActivity handler) {
        final FirebaseAuth mAuth = getFirebaseAuthInstance();

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        handler.handleLoginSuccess();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        handler.handleLoginFailure(e);
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
        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                @Override
                public void onSuccess(AuthResult authResult) {
                    Log.e("REGISTRATION", "SUCCESSFUL");
                    handler.handleRegistrationSuccess();
                }
            })
            .addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Log.e("REGISTRATION", "FAILED");
                    handler.handleRegistrationFailure(e);
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

    /**
     * Here's our Firebase Rule
     *
     * {
     *   "rules": {
     *     "users": {
     *       "$user_id": {
     *         ".write": "$user_id === auth.uid",
     *         ".read": "$user_id === auth.uid"
     *       }
     *     }
     *   }
     * }
     *
     * @param userId the user id
     * @return the database reference for the user context
     */
    private DatabaseReference getUserDatabaseReference(final String userId) {
        return databaseReference().child("users").child(userId);
    }
}
