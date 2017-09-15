package amazingme.activities.app;

import amazingme.model.AmazingMeAppCompatActivity;
import amazingme.app.EnumeratedActivity;

public class LandingPage extends AmazingMeAppCompatActivity {

    @Override
    public EnumeratedActivity activityName() {
        return EnumeratedActivity.MAIN_MENU;
    }

    @Override
    public void bindToUserInterface() {}
}
