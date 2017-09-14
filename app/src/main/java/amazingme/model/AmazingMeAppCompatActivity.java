package amazingme.model;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

import amazingme.app.AmazingMeApplicationContext;
import amazingme.app.EnumeratedActivity;
import amazingme.controller.ActivityManager;
import amazingme.database.ISession;

public abstract class AmazingMeAppCompatActivity extends AppCompatActivity {

    public abstract EnumeratedActivity activityName();

    public final void goTo(EnumeratedActivity activity) {
        ActivityManager.getInstance().goTo(AmazingMeAppCompatActivity.this, activity);
    }

    public AmazingMeApplicationContext getContext() {
        return (AmazingMeApplicationContext) getApplicationContext();
    }

    public void checkSignedIn(EnumeratedActivity activity) {
        if(!getContext().getSessionManager().hasCurrentSession()) {
            goTo(activity);
        }
    }

}
