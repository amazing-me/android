package amazingme.app;

import android.app.Application;

import java.util.List;

import amazingme.database.Session;
import amazingme.database.SessionManager;
import amazingme.database.firebase.FirebaseSessionManager;
import amazingme.model.AmazingMeGame;

public class AmazingMeApplicationContext extends Application {

    private SessionManager<? extends Session> sessionManager;
    private List<Class<? extends AmazingMeGame>> games;

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

    public List<Class<? extends AmazingMeGame>> getGames() {
        return games;
    }

    public void setGames(List<Class<? extends AmazingMeGame>> games) {
        this.games = games;
    }

}
