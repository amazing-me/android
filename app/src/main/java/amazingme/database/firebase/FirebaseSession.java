package amazingme.database.firebase;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import amazingme.app.UserContext;
import amazingme.database.Session;

public class FirebaseSession extends Session {

    private final FirebaseUser user;
    private final DatabaseReference ref;

    public FirebaseSession(FirebaseUser user) {
        this.user = user;
        this.ref = FirebaseDatabase.getInstance().getReference("users").child(user.getUid());
    }

    @Override
    public Task<UserContext> doLoadContext() {
        final TaskCompletionSource<UserContext> source = new TaskCompletionSource<>();
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                source.setResult(dataSnapshot.getValue(UserContext.class));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                source.setException(databaseError.toException());
            }
        });

        return source.getTask();
    }

    @Override
    public Task<Void> doSaveContext(UserContext context) {
        return ref.setValue(context);
    }

    @Override
    public String getEmail() {
        return user.getEmail();
    }

    @Override
    public String getUid() {
        return user.getUid();
    }

}
