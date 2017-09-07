package amazingme.model;

import android.support.v7.app.AppCompatActivity;

import amazingme.app.EnumeratedActivity;
import amazingme.controller.ActivityManager;

public abstract class AmazingMeAppCompatActivity extends AppCompatActivity {

    public abstract EnumeratedActivity activityName();

    public AmazingMeAppCompatActivity() {
        System.out.println("creating: " + this.getClass().getName());
    }

    public final void goTo(EnumeratedActivity activity) {
        ActivityManager.getInstance().goTo(AmazingMeAppCompatActivity.this, activity);
    }

}
