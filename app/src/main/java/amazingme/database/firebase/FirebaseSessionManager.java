package amazingme.database.firebase;

import android.support.annotation.NonNull;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

import amazingme.database.ISession;
import amazingme.database.SessionManager;

public class FirebaseSessionManager extends SessionManager<FirebaseSession> {

    private FirebaseAuth auth;

    @Override
    public void onCreate() {
        auth = FirebaseAuth.getInstance();
        currentSession = new FirebaseSession(auth.getCurrentUser());
    }

    @Override
    public Task<ISession> startSession(@NonNull String email, @NonNull String pass) {
        return auth.signInWithEmailAndPassword(email, pass).continueWith(new Continuation<AuthResult, ISession>() {
            @Override
            public ISession then(@NonNull Task<AuthResult> task) throws Exception {
                currentSession = new FirebaseSession(task.getResult().getUser());
                return currentSession;
            }
        });
    }

    @Override
    public Task<ISession> registerSession(@NonNull String email, @NonNull String pass, @NonNull final String displayName) {
        return auth.createUserWithEmailAndPassword(email, pass).continueWithTask(new Continuation<AuthResult, Task<Void>>() {
            @Override
            public Task<Void> then(@NonNull Task<AuthResult> task) throws Exception {
                currentSession = new FirebaseSession(task.getResult().getUser());

                UserProfileChangeRequest request = new UserProfileChangeRequest.Builder()
                    .setDisplayName(displayName)
                    .build();

                return currentSession.getFirebaseUser().updateProfile(request);
            }
        }).continueWith(new Continuation<Void, ISession>() {
            @Override
            public ISession then(@NonNull Task<Void> task) throws Exception {
                task.getResult(); // Propagate the error if one occurred
                return currentSession;
            }
        });
    }

    @Override
    public Task<Boolean> endSession() {
        auth.signOut();
        return Tasks.forResult(true);
    }

}
