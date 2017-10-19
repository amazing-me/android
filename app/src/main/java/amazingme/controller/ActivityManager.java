package amazingme.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

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

    public void goTo(final Activity context, final Class<? extends AppCompatActivity> endingActivity) {
        context.startActivity(new Intent(context, endingActivity));
    }

    public void goTo(final Activity context, final EnumeratedActivity endingActivity, final Bundle bundle) {
        final Intent switchIntent = new Intent(context, endingActivity.getAppCompatActivity());
        switchIntent.putExtras(bundle);
        context.startActivity(switchIntent);
    }
}
