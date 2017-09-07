package amazingme.activities.app;

import android.content.Intent;
import android.os.Bundle;

import com.amazingme.activities.R;

import amazingme.app.AmazingMeApplicationContext;
import amazingme.model.AmazingMeAppCompatActivity;
import amazingme.app.EnumeratedActivity;

public class LandingPage extends AmazingMeAppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);
        AmazingMeApplicationContext.loadContext(12345); // TODO -> implement this... get the information from the login activity
        //load the main menu after everything is loaded
        Intent newIntent = new Intent(this, MainMenu.class);
        startActivity(newIntent);
    }

    @Override
    public EnumeratedActivity activityName() {
        return EnumeratedActivity.MAIN_MENU;
    }
}
