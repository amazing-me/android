package amazingme.activities.app;

import android.os.Bundle;

import com.amazingme.activities.R;

import amazingme.controller.ISessionLogoutHandler;
import amazingme.model.AmazingMeAppCompatActivity;
import amazingme.app.EnumeratedActivity;

public class MainMenu extends NavigationBarActivity {

    public MainMenu() { super(R.layout.activity_main_menu); }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public EnumeratedActivity activityName() {
        return EnumeratedActivity.MAIN_MENU;
    }

    @Override
    public void bindToUserInterface() {

    }
}
