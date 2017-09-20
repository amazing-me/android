package amazingme.app;

import java.util.ArrayList;
import java.util.List;

import amazingme.activities.app.ChildRegistrationActivity;
import amazingme.activities.app.ForgotPasswordActivity;
import amazingme.activities.app.GameSelectionPage;
import amazingme.activities.app.LandingPage;
import amazingme.activities.app.LoginActivity;
import amazingme.activities.app.MainMenu;
import amazingme.activities.app.PrimaryCarePhysicianInformationActivity;
import amazingme.activities.app.RegisterActivity;
import amazingme.activities.app.UserProfileActivity;
import amazingme.activities.games.ThreeTouchGame;
import amazingme.model.AmazingMeAppCompatActivity;

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
    //GAME_SELECTION,
    GAME_SELECTION_PAGE(GameSelectionPage.class),
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
