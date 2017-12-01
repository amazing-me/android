package amazingme.database;

import android.support.annotation.NonNull;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

import amazingme.app.UserContext;

public abstract class Session {

    private UserContext userContext;

    public Session() {
        userContext = new UserContext();
    }

    public UserContext getUserContext() {
        return userContext;
    }

    public abstract String getEmail();

    public abstract String getUid();

    public Task<Void> loadContext() {
        return doLoadContext().continueWith(new Continuation<UserContext, Void>() {
            @Override
            public Void then(@NonNull Task<UserContext> task) throws Exception {
                UserContext loadedContext = task.getResult();
                if(loadedContext != null) {
                    userContext = loadedContext;
                }

                return null;
            }
        });
    }

    public Task<Void> saveContext() {
        return doSaveContext(userContext);
    }

    protected abstract Task<UserContext> doLoadContext();

    protected abstract Task<Void> doSaveContext(UserContext context);

}
