package amazingme.activities.app;

import com.amazingme.activities.R;

import amazingme.app.AmazingMeAppCompatActivity;
import amazingme.app.EnumeratedActivity;

public class LandingPage extends AmazingMeAppCompatActivity {

    public LandingPage() { super(R.layout.activity_landing_page); }

    @Override
    public EnumeratedActivity activityName() {
        return EnumeratedActivity.LANDING_PAGE;
    }

    @Override
    public void bindToUserInterface() {

    }
}
