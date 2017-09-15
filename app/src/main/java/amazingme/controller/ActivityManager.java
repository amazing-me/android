package amazingme.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

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

    public void goTo(final Activity context, final EnumeratedActivity endingActivity, final Bundle bundle) {
        final Intent switchIntent = new Intent(context, endingActivity.getAppCompatActivity());
        final Bundle extras = switchIntent.getExtras();
        extras.putAll(bundle);
        context.startActivity(switchIntent);
    }
}
