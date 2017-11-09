package amazingme.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.HashMap;
import java.util.Map;

import amazingme.activities.util.DialogBoxShower;
import amazingme.controller.ActivityManager;

public abstract class AmazingMeAppCompatActivity extends AppCompatActivity {

    private int layout;

    public AmazingMeAppCompatActivity(int layout) {
        this.layout = layout;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout);
        bindToUserInterface();
    }

    public final void goTo(EnumeratedActivity activity) {
        ActivityManager.getInstance().goTo(AmazingMeAppCompatActivity.this, activity);
    }

    public final void goTo(final EnumeratedActivity activity, final Bundle bundle) {
        ActivityManager.getInstance().goTo(AmazingMeAppCompatActivity.this, activity, bundle);
    }

    public final void goToIfSignedIn(EnumeratedActivity activity) {
        if(getAppContext().hasSession()) {
            goTo(activity);
        }
    }

    public final void goToIfNotSignedIn(EnumeratedActivity activity) {
        if(!getAppContext().hasSession()) {
            goTo(activity);
        }
    }

    public final void showInfoDialogBox(final String title, final String message, final Runnable fn) {
        DialogBoxShower.show(DialogBoxShower.DialogType.INFO_DIALOG, AmazingMeAppCompatActivity.this,
                title, message, fn);
    }

    public final void showAlertDialogBox(final String title, final String message, final Runnable fn) {
        DialogBoxShower.show(DialogBoxShower.DialogType.ALERT_DIALOG, AmazingMeAppCompatActivity.this,
                title, message, fn);
    }

    public final AmazingMeApplicationContext getAppContext() {
        return (AmazingMeApplicationContext) getApplicationContext();
    }

    public final UserContext getUserContext() {
        return getAppContext().getUserContext();
    }

    public abstract EnumeratedActivity activityName();

    public abstract void bindToUserInterface();

}