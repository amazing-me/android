package amazingme.controller;

import android.app.Activity;
import android.content.Intent;

import amazingme.app.EnumeratedActivity;

public class ActivityManager {

    private static ActivityManager instance;

    public static ActivityManager getInstance() {
        if(instance == null) {
            instance = new ActivityManager();
        }
        return instance;
    }

    public void goTo(final Activity context, final EnumeratedActivity endingActivity) {
        context.startActivity(new Intent(context, endingActivity.getAppCompatActivity()));
    }
}
