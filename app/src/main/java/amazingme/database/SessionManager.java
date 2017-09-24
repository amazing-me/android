package amazingme.database;

import android.support.annotation.NonNull;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import amazingme.controller.ISessionRegisterHandler;
import amazingme.controller.ISessionLogoutHandler;
import amazingme.controller.ISessionLoginHandler;

public abstract class SessionManager<T extends Session> {

    private T session;

    public Task<T> initialize(final ISessionLoginHandler handler) {
        return loadContext(doInitialize()).addOnSuccessListener(new OnSuccessListener<T>() {
            @Override
            public void onSuccess(T session) {
                SessionManager.this.session = session;
                if(handler != null) {
                    handler.onSessionLoginSuccess(session);
                }
            }
        });
    }

    public Task<T> login(@NonNull final String email, @NonNull String pass, final ISessionLoginHandler handler) {
        return loadContext(doLogin(email, pass)).addOnSuccessListener(new OnSuccessListener<T>() {
            @Override
            public void onSuccess(T session) {
                SessionManager.this.session = session;
                if(handler != null) {
                    handler.onSessionLoginSuccess(session);
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                if(handler != null) {
                    handler.onSessionLoginFailure(e);
                }
            }
        });
    }

    public Task<T> register(@NonNull final String email, @NonNull String pass, final ISessionRegisterHandler handler) {
        return loadContext(doRegister(email, pass)).addOnSuccessListener(new OnSuccessListener<T>() {
            @Override
            public void onSuccess(T session) {
                session.getUserContext().getParent().setEmail(email);

                SessionManager.this.session = session;
                if(handler != null) {
                    handler.onSessionRegisterSuccess(session);
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                if(handler != null) {
                    handler.onSessionRegisterFailure(e);
                }
            }
        });
    }

    public Task<Void> logout(final ISessionLogoutHandler handler) {
        return doLogout().addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void arg) {
                SessionManager.this.session = null;
                if(handler != null) {
                    handler.onSessionLogoutSuccess();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                if(handler != null) {
                    handler.onSessionLogoutFailure(e);
                }
            }
        });
    }

    protected abstract Task<T> doInitialize();

    protected abstract Task<T> doLogin(@NonNull String email, @NonNull String pass);

    protected abstract Task<T> doRegister(@NonNull String email, @NonNull String pass);

    protected abstract Task<Void> doLogout();

    public T getSession() {
        return session;
    }

    public boolean hasSession() {
        return session != null;
    }

    private Task<T> loadContext(final Task<T> sessionTask) {
        return sessionTask.continueWithTask(new Continuation<T, Task<Void>>() {
            @Override
            public Task<Void> then(@NonNull Task<T> task) throws Exception {
                return task.getResult().loadContext();
            }
        }).continueWith(new Continuation<Void, T>() {
            @Override
            public T then(@NonNull Task<Void> task) throws Exception {
                task.getResult(); // If an error occurred, propagate it
                return sessionTask.getResult();
            }
        });
    }

}
