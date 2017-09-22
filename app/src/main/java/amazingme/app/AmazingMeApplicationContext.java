package amazingme.app;

import android.app.Application;

import amazingme.database.Session;
import amazingme.database.SessionManager;
import amazingme.database.firebase.FirebaseSessionManager;

public class AmazingMeApplicationContext extends Application {

    private SessionManager<? extends Session> sessionManager;

    @Override
    public void onCreate() {
        super.onCreate();

        sessionManager = new FirebaseSessionManager();
    }

    public SessionManager<? extends Session> getSessionManager() {
        return sessionManager;
    }

    public Session getSession() {
        return getSessionManager().getSession();
    }

    public UserContext getUserContext() {
        return getSessionManager().getSession().getContext();
    }

}
