package amazingme.app;

import android.app.Application;

import java.util.Set;

import amazingme.database.FirebaseHelper;
import amazingme.database.IDatabase;

import amazingme.model.AmazingMeGame;
import amazingme.util.Loader;


public class AmazingMeApplicationContext extends Application {

    private static UserContext userContext;
    private static final SessionManager session;
    private static final IDatabase database; //for us, session and database are the same object (the firebase helper) but i want the option to possible let them be different.
    private static Set<AmazingMeGame> availableGames;

    static {
        session = FirebaseHelper.getInstance();
        database = FirebaseHelper.getInstance(); // once again, redundant now but could be very useful.
    }

    public static void loadContext() { // I don't like that an activity will be calling this, but perhaps it's necessary?
        loadUserContext();
        loadAvailableGames();
    }

    private static void loadUserContext() {
        userContext = Loader.loadUserContextUsingDatabaseSnapshot(database.getUserContext());
    }

    private static void loadAvailableGames() {
        availableGames = Loader.loadAvailableGamesUsingUserContext(userContext);
    }

    public static SessionManager session() {
        return session;
    }

    public static UserContext getUserContext() {
        return userContext;
    }

    public static IDatabase database() {
        return database;
    }


}
