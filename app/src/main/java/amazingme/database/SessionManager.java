package amazingme.database;

import android.support.annotation.NonNull;

import com.google.android.gms.tasks.Task;

public abstract class SessionManager<T extends ISession> {

    protected T currentSession;

    public abstract void onCreate();

    public abstract Task<ISession> startSession(@NonNull String email, @NonNull String pass);

    public abstract Task<ISession> registerSession(@NonNull String email, @NonNull String pass, @NonNull String displayName);

    public abstract Task<Boolean> endSession();

    public T getCurrentSession() {
        return currentSession;
    }

    public boolean hasCurrentSession() {
        return currentSession != null;
    }

}
