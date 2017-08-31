package amazingme;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.amazingme.activities.MainActivity;

import java.util.HashMap;

import amazingme.model.EnumeratedActivity;
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

    public void goTo(EnumeratedActivity enumeratedActivity, Bundle b) {
        if(!this.activityMap.containsKey(enumeratedActivity)) {
            this.addActivity(enumeratedActivity, enumeratedActivity.getAppCompatActivity());
        }
        Intent switchActivity = new Intent(AmazingMeApplicationContext.getAmazingMeAndroidContext(), this.activityMap.get(enumeratedActivity));
        switchActivity.putExtras(b);
        startActivity(switchActivity);
    }

    public void goTo(EnumeratedActivity enumeratedActivity) {
        if(!this.activityMap.containsKey(enumeratedActivity)) {
            this.addActivity(enumeratedActivity, enumeratedActivity.getAppCompatActivity());
        }
        Intent switchActivity = new Intent(AmazingMeApplicationContext.getAmazingMeAndroidContext(), this.activityMap.get(enumeratedActivity));
        startActivity(switchActivity);
    }

    public void goTo(Class<? extends AmazingMeAppCompatActivity> activity) {
        Intent switchIntent = new Intent(AmazingMeApplicationContext.getAmazingMeAndroidContext(), activity);
        startActivity(switchIntent);
    }

    public void addActivity(EnumeratedActivity enumeratedActivity, Class<? extends AmazingMeAppCompatActivity> appCompatActivity) {
        if(enumeratedActivity != null && appCompatActivity != null && !this.activityMap.containsKey(enumeratedActivity)) {
            this.activityMap.put(enumeratedActivity, appCompatActivity);
        }
    }

}
