package amazingme.app;

import java.util.LinkedList;
import java.util.List;

import amazingme.activities.app.ChildRegistrationActivity;
import amazingme.activities.app.EndGameActivity;
import amazingme.activities.app.ForgotPasswordActivity;
import amazingme.activities.app.GameMenuActivity;
import amazingme.activities.app.LandingPage;
import amazingme.activities.app.LoginActivity;
import amazingme.activities.app.MainMenu;
import amazingme.activities.app.PrimaryCarePhysicianInformationActivity;
import amazingme.activities.app.RegisterActivity;
import amazingme.activities.app.UserProfileActivity;
import amazingme.activities.games.ThreeTouchGame;
import amazingme.model.AmazingMeAppCompatActivity;
import amazingme.model.AmazingMeGame;
import amazingme.model.Milestone;

//TODO -> clean this up... surely there is a way to format it better
public enum EnumeratedActivity {
    LOGIN(LoginActivity.class),
    MAIN_MENU(MainMenu.class),
    LANDING_PAGE(LandingPage.class),
    REGISTRATION(RegisterActivity.class),
    USER_PROFILE(UserProfileActivity.class),
    FORGOT_PASSWORD(ForgotPasswordActivity.class),
    PCP_INFORMATION(PrimaryCarePhysicianInformationActivity.class),
    CHILD_REGISTRATION(ChildRegistrationActivity.class),
    GAME_MENU(GameMenuActivity.class),
    END_GAME(EndGameActivity.class),
    THREE_TOUCH_GAME(ThreeTouchGame.class, true, true);


    private String className;
    private boolean isGame;
    private boolean isActiveGame;
    private final String PACKAGE_NAME = "amazingme.model.";
    private final Class<? extends AmazingMeAppCompatActivity> appCompatActivity;
    private final Class<? extends AmazingMeGame> appCompatGame;

    EnumeratedActivity(Class<? extends AmazingMeAppCompatActivity> appCompatActivity) {
        this(appCompatActivity, false, false);
    }

    EnumeratedActivity(Class<? extends AmazingMeAppCompatActivity> appCompatActivity, boolean isGame, boolean isActive){
        this.className = appCompatActivity.getName();
        this.isGame = isGame;
        this.isActiveGame = isGame && isActive;
        //TODO -> I don't love this, but it'll work for now. 
        // so basically all games have an additional appCompatGame variable that holds the actual class
        if(isGame) {
            this.appCompatGame = (Class<? extends AmazingMeGame>) appCompatActivity;
        } else {
            this.appCompatGame = null;
        }
        this.appCompatActivity = appCompatActivity;
    }

    public static List<EnumeratedActivity> getRegisteredGames() {
        List<EnumeratedActivity> activeGames = new LinkedList<>();
        for (EnumeratedActivity activity : values()) {
            if (activity.isActiveGame) {
                activeGames.add(activity);
            }
        }
        return activeGames;
    }


    public Class<? extends AmazingMeAppCompatActivity> getAppCompatActivity() {
        return this.appCompatActivity;
    }

    public Class<? extends AmazingMeGame> getAppCompatGame() {
        return this.appCompatGame;
    }

    public boolean isActiveGame() {
        return this.isActiveGame;
    }

}
