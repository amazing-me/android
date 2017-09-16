package amazingme.database;

import android.support.annotation.NonNull;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

import amazingme.app.UserContext;

public abstract class Session {

    private UserContext context;

    public Session() {
        context = new UserContext();
    }

    public UserContext getContext() {
        return context;
    }

    public abstract String getDisplayName();

    public abstract String getEmail();

    public Task<Void> loadContext() {
        return doLoadContext().continueWith(new Continuation<UserContext, Void>() {
            @Override
            public Void then(@NonNull Task<UserContext> task) throws Exception {
                UserContext loadedContext = task.getResult();
                if(loadedContext != null) {
                    context = loadedContext;
                }

                return null;
            }
        });
    }

    public Task<Void> saveContext() {
        return doSaveContext(context);
    }

    protected abstract Task<UserContext> doLoadContext();

    protected abstract Task<Void> doSaveContext(UserContext context);

}
