package amazingme.app;

import android.app.Application;

import java.util.List;

import amazingme.database.AmazingMeFirebase;
import amazingme.database.FirebaseHelper;
import amazingme.database.IDatabase;

import amazingme.model.AmazingMeGame;


public class AmazingMeApplicationContext extends Application {

    private static UserContext userContext;
    private final SessionManager session;
    private final IDatabase database; //for us, session and database are the same object (the firebase helper) but i want the option to possible let them be different.
    private static int currentChildUser;
    private static List<AmazingMeGame> availableGames;

    AmazingMeApplicationContext() {
        //session = AmazingMeFirebase.getInstance();
        //database = AmazingMeFirebase.getInstance(); // once again, redundant now but could be very useful.
    }

}
