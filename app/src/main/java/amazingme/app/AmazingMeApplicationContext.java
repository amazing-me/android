package amazingme.app;

import android.app.Application;

import amazingme.database.ISession;
import amazingme.database.SessionManager;
import amazingme.database.firebase.FirebaseSessionManager;

public class AmazingMeApplicationContext extends Application {

    private final SessionManager<? extends ISession> sessionManager;

//    private static UserContext userContext;
//    private static final SessionManager session;
//    private static final IDatabase database; //for us, session and database are the same object (the firebase helper) but i want the option to possible let them be different.
//    private static Set<AmazingMeGame> availableGames;

    public AmazingMeApplicationContext() {
        sessionManager = new FirebaseSessionManager();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        sessionManager.onCreate();
    }

    public SessionManager<? extends ISession> getSessionManager() {
        return sessionManager;
    }
//
//    static {
//        session = FirebaseHelper.getInstance();
//        database = FirebaseHelper.getInstance(); // once again, redundant now but could be very useful.
//    }
//
//
//
//    public static void loadContext() { // I don't like that an activity will be calling this, but perhaps it's necessary?
//        loadUserContext();
//        loadAvailableGames();
//    }
//
//    public static void restoreSession(final String email, final String password, final LoginHandlingActivity handler) {
//        session().load(email, password, handler);
//    }
//
//    public static void createNewSession(final String email, final String password, final RegistrationHandlingActivity handler) {
//        session().create(email, password, handler);
//    }
//
//    public static void endSession() {
//        session.end();
//    }
//
//    public static boolean hasActiveSession() {
//        return session.isActive();
//    }
//
//    private static void loadUserContext() {
//        userContext = Loader.loadUserContextUsingDatabaseSnapshot(database.getUserContext());
//    }
//
//    private static void loadAvailableGames() {
//        availableGames = Loader.loadAvailableGamesUsingUserContext(userContext);
//    }
//
//    public static void saveContext() {
//        database().set(userContext);
//    }
//
//    public static void setUserContext(UserContext newUserContext) {
//        userContext = newUserContext;
//    }
//
//    private static SessionManager session() {
//        return session;
//    }
//
//    private static UserContext getUserContext() {
//        return userContext;
//    }
//
//    private static IDatabase database() {
//        return database;
//    }


}
