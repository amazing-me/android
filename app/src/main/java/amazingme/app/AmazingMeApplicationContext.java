package amazingme.app;

import android.app.Application;

import java.util.Set;

import amazingme.controller.LoginHandlingActivity;
import amazingme.controller.RegistrationHandlingActivity;
import amazingme.database.FirebaseHelper;
import amazingme.database.IDatabase;

import amazingme.model.AmazingMeGame;
import amazingme.util.Loader;


public class AmazingMeApplicationContext extends Application {

    private static UserContext userContext;
    private static final SessionManager session;
    private static final IDatabase database; //for us, session and database are the same object (the firebase helper) but i want the option to possible let them be different.
    private static Set<AmazingMeGame> availableGames;

    private static AmazingMeApplicationContext instance;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    static {
        session = FirebaseHelper.getInstance();
        database = FirebaseHelper.getInstance(); // once again, redundant now but could be very useful.
    }

    public static void loadContext() { // I don't like that an activity will be calling this, but perhaps it's necessary?
        loadUserContext();
        loadAvailableGames();
    }

    public static void restoreSession(final String email, final String password, final LoginHandlingActivity handler) {
        session().login(email, password, handler);
    }

    public static void createNewUser(final String email, final String password, final RegistrationHandlingActivity handler) {
        database().createUser(email, password, handler);
    }

    public static void endSession() {
        session.logout();
    }

    public static boolean hasActiveSession() {
        return session.isActive();
    }

    private static void loadUserContext() {
        userContext = Loader.loadUserContextUsingDatabaseSnapshot(database.getUserContext());
    }

    private static void loadAvailableGames() {
        availableGames = Loader.loadAvailableGamesUsingUserContext(userContext);
    }

    public static void saveContext() {
        database().set(userContext);
    }

    public static void setUserContext(UserContext newUserContext) {
        userContext = newUserContext;
    }

    private static SessionManager session() {
        return session;
    }

    private static UserContext getUserContext() {
        return userContext;
    }

    private static IDatabase database() {
        return database;
    }


}
