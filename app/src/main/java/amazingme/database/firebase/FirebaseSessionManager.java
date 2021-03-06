package amazingme.database.firebase;

import android.support.annotation.NonNull;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import amazingme.database.SessionManager;

public class FirebaseSessionManager extends SessionManager<FirebaseSession> {

    private final FirebaseAuth auth;

    public FirebaseSessionManager() {
        auth = FirebaseAuth.getInstance();
    }

    @Override
    protected Task<FirebaseSession> doInitialize() {
        FirebaseUser user = auth.getCurrentUser();
        return Tasks.forResult(user != null ? new FirebaseSession(user) : null);
    }

    @Override
    protected Task<FirebaseSession> doLogin(@NonNull String email, @NonNull String pass) {
        return auth.signInWithEmailAndPassword(email, pass).continueWith(new Continuation<AuthResult, FirebaseSession>() {
            @Override
            public FirebaseSession then(@NonNull Task<AuthResult> task) throws Exception {
                return new FirebaseSession(task.getResult().getUser());
            }
        });
    }

    @Override
    protected Task<FirebaseSession> doRegister(@NonNull String email, @NonNull String pass) {
        return auth.createUserWithEmailAndPassword(email, pass).continueWith(new Continuation<AuthResult, FirebaseSession>() {
            @Override
            public FirebaseSession then(@NonNull Task<AuthResult> task) throws Exception {
                return new FirebaseSession(task.getResult().getUser());
            }
        });
    }

    @Override
    protected Task<Void> doLogout() {
        auth.signOut();
        return Tasks.forResult(null);
    }

    @Override
    protected Task<Void> doForgotPassword(@NonNull String email) {
        return auth.sendPasswordResetEmail(email);
    }

}
