package amazingme.app;

import amazingme.activities.app.MainMenu;

import java.util.ArrayList;
import java.util.List;

import amazingme.activities.games.ThreeTouchGame;
import amazingme.model.AmazingMeAppCompatActivity;

//TODO -> clean this up... surely there is a way to format it better
public enum EnumeratedActivity {
    //LOGIN,
    MAIN_MENU(MainMenu.class),
    //GAME_SELECTION,
    THREE_TOUCH_GAME("ThreeTouchGame", true, true, ThreeTouchGame.class);

    private String className;
    private boolean isGame;
    private boolean isActiveGame;
    private final String PACKAGE_NAME = "amazingme.model.";
    private final List<EnumeratedActivity> allGames = new ArrayList<>();
    private final List<EnumeratedActivity> activeGames = new ArrayList<>();
    private final Class<? extends AmazingMeAppCompatActivity> appCompatActivity;

    EnumeratedActivity(){
        this("", false, false, null);
    }

    EnumeratedActivity(Class<? extends AmazingMeAppCompatActivity> appCompatActivity) {
        this.appCompatActivity = appCompatActivity;
    }

    EnumeratedActivity(String className, boolean isGame, boolean isActive, Class<? extends AmazingMeAppCompatActivity> appCompatActivity){
        this.className = className;
        this.isGame = isGame;
        this.isActiveGame = isGame && isActive;
        if(isGame) { allGames.add(this); }
        if(isActive) { activeGames.add(this);}
        this.appCompatActivity = appCompatActivity;
}


    public List<String> activeGamesAsStringList() {
        return new ArrayList<>();
    }

    public Class<? extends AmazingMeAppCompatActivity> getAppCompatActivity() {
        return this.appCompatActivity;
    }

}
