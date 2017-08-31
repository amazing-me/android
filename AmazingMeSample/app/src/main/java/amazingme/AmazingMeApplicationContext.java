package amazingme;

import android.app.Application;
import android.content.Context;

import com.amazingme.activities.MainActivity;

import java.util.List;

import amazingme.model.Child;
import amazingme.model.AmazingMeGame;
import amazingme.model.EnumeratedActivity;
import amazingme.model.Parent;
import amazingme.model.User;


public class AmazingMeApplicationContext extends Application {

    public static ActivityManager activityManager;

    private static Context amazingMeAndroidContext;

    public static Context getAmazingMeAndroidContext() {
        return amazingMeAndroidContext;
    }

    @Override
    public void onCreate() {
        System.out.println("Initializing Application Context");
        activityManager = ActivityManager.getInstance();
        amazingMeAndroidContext = getApplicationContext();
        super.onCreate();
        //activityManager.goTo(MainActivity.class);
        System.out.println("\n\nFINISHED CONTEXT\n\n");
    }

//    private User parentUser;
//    private List<? extends User> children;
//
//    private User currentChildPlayer;
//    private List<AmazingMeGame> availableGames; // shouldn't change unless the app is downloaded... fine to keep as array
    /*public void loadInformation() {
        if(informationNotLoaded()) {
            this.learn();
        }
        else {
            //do some stuff.
        }
    }*/

//    public void setCurrentChildPlayers(int index) {
//        currentChildPlayer = children.get(index);
//    }
//
//    public ActivityManager getActivityManager() {return activityManager;}
//
//    public void setParentUser(Parent parent) {
//        parentUser = parent;
//    }
//
//    public void setChildren(List<Child> childList) {
//        children = childList;
//    }
//
//    public void setAvailableGames(List<AmazingMeGame> games) {
//        availableGames = games;
//    }

    /*public void learn() {
        Loader.load(this);
    }*/

//    private boolean informationNotLoaded() {
//        boolean notLoaded = false;
//        return notLoaded;
//    }

}
