package amazingme.model;

import android.support.v7.app.AppCompatActivity;

import amazingme.ActivityManager;

public abstract class AmazingMeAppCompatActivity extends AppCompatActivity {

    public abstract EnumeratedActivity activityName();

    public AmazingMeAppCompatActivity() {
        this.registerWithActivityManager();
        System.out.println("creating: " + this.getClass().getName());
    }

    public final void registerWithActivityManager() {
        ActivityManager.getInstance().addActivity(activityName(), this.getClass());
    }

}
