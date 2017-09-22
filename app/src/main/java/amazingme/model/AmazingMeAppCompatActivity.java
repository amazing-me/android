package amazingme.model;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import amazingme.app.AmazingMeApplicationContext;
import amazingme.app.EnumeratedActivity;
import amazingme.controller.ActivityManager;

public abstract class AmazingMeAppCompatActivity extends AppCompatActivity {

    private int layout;

    public AmazingMeAppCompatActivity(int layout) { this.layout = layout; }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout);
        bindToUserInterface();
    }

    public final void goTo(EnumeratedActivity activity) {
        ActivityManager.getInstance().goTo(AmazingMeAppCompatActivity.this, activity);
    }

    public final void goToIfSignedIn(EnumeratedActivity activity) {
        if(getContext().getSessionManager().hasSession()) {
            goTo(activity);
        }
    }

    public final void goToIfNotSignedIn(EnumeratedActivity activity) {
        if(!getContext().getSessionManager().hasSession()) {
            goTo(activity);
        }
    }

    public final AmazingMeApplicationContext getContext() {
        return (AmazingMeApplicationContext) getApplicationContext();
    }

    public abstract EnumeratedActivity activityName();

    public abstract void bindToUserInterface();

}
