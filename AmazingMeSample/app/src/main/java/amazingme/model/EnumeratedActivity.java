package amazingme.model;

import android.support.v7.app.AppCompatActivity;

import com.amazingme.activities.MainActivity;
import com.amazingme.activities.MainMenu;

import java.util.ArrayList;
import java.util.List;

import amazingme.games.ThreeTouchGame;

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
