package amazingme.controller;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.HashMap;

import amazingme.app.EnumeratedActivity;
import amazingme.model.AmazingMeAppCompatActivity;

public class ActivityManager extends AppCompatActivity {

    private static ActivityManager instance;
    private HashMap<EnumeratedActivity, Class<? extends AmazingMeAppCompatActivity>> activityMap;

    private ActivityManager(){
        this.activityMap = new HashMap<>();
    }

    public static ActivityManager getInstance() {
        if(instance == null) {
            instance = new ActivityManager();
        }
        return instance;
    }

    public void goTo(Context context, EnumeratedActivity enumeratedActivity, Bundle b) {
        if(!this.activityMap.containsKey(enumeratedActivity)) {
            this.addActivity(enumeratedActivity, enumeratedActivity.getAppCompatActivity());
        }
        Intent switchActivity = new Intent(context, this.activityMap.get(enumeratedActivity));
        switchActivity.putExtras(b);
        startActivity(switchActivity);
    }

    public void goTo(Context context, EnumeratedActivity enumeratedActivity) {
        if(!this.activityMap.containsKey(enumeratedActivity)) {
            this.addActivity(enumeratedActivity, enumeratedActivity.getAppCompatActivity());
        }
        Intent switchActivity = new Intent(context, this.activityMap.get(enumeratedActivity));
        startActivity(switchActivity);
    }

    public void goTo(Context context, Class<? extends AmazingMeAppCompatActivity> activity) {
        Intent switchIntent = new Intent(context, activity);
        startActivity(switchIntent);
    }

    public void addActivity(EnumeratedActivity enumeratedActivity, Class<? extends AmazingMeAppCompatActivity> appCompatActivity) {
        if(enumeratedActivity != null && appCompatActivity != null && !this.activityMap.containsKey(enumeratedActivity)) {
            this.activityMap.put(enumeratedActivity, appCompatActivity);
        }
    }

}
