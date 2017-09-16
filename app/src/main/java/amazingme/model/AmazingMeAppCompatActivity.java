package amazingme.model;

import android.support.v7.app.AppCompatActivity;

import amazingme.app.AmazingMeApplicationContext;
import amazingme.app.EnumeratedActivity;
import amazingme.controller.ActivityManager;

public abstract class AmazingMeAppCompatActivity extends AppCompatActivity {

    public abstract EnumeratedActivity activityName();

    public final void goTo(EnumeratedActivity activity) {
        ActivityManager.getInstance().goTo(AmazingMeAppCompatActivity.this, activity);
    }

    public void goToIfSignedIn(EnumeratedActivity activity) {
        if(getContext().getSessionManager().hasSession()) {
            goTo(activity);
        }
    }

    public void goToIfNotSignedIn(EnumeratedActivity activity) {
        if(!getContext().getSessionManager().hasSession()) {
            goTo(activity);
        }
    }

    public AmazingMeApplicationContext getContext() {
        return (AmazingMeApplicationContext) getApplicationContext();
    }

}
