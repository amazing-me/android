package amazingme.model;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import amazingme.app.AmazingMeApplicationContext;
import amazingme.app.EnumeratedActivity;
import amazingme.controller.ActivityManager;

public abstract class AmazingMeAppCompatActivity extends AppCompatActivity {

    private int layout;

    public AmazingMeAppCompatActivity(int layout) { this.layout = layout; }

    public abstract EnumeratedActivity activityName();

    public abstract void bindToUserInterface();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout);
        bindToUserInterface();
    }

    public AmazingMeAppCompatActivity() {
        System.out.println("creating: " + this.getClass().getName());
    }

    public final void goTo(EnumeratedActivity activity) {
        ActivityManager.getInstance().goTo(AmazingMeAppCompatActivity.this, activity);
    }
}
