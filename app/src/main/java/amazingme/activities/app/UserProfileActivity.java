package amazingme.activities.app;

import android.view.View;
import android.widget.Button;

import com.amazingme.activities.R;

import amazingme.app.AmazingMeApplicationContext;
import amazingme.app.EnumeratedActivity;
import amazingme.model.AmazingMeAppCompatActivity;

public class UserProfileActivity extends AmazingMeAppCompatActivity {

    private Button backBtn, submitBtn;

    public UserProfileActivity() { super(R.layout.activity_user_profile); }

    @Override
    public EnumeratedActivity activityName() {
        return EnumeratedActivity.USERPROFILE;
    }

    @Override
    public void bindToUserInterface() {
        submitBtn = (Button)  findViewById(R.id.user_profile_register_button);

        backBtn = (Button) findViewById(R.id.user_profile_back_button);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goTo(EnumeratedActivity.REGISTRATION);
            }
        });

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        // TODO: This is how you save to database
        // AmazingMeApplicationContext.setUserContext(userContext);
        // AmazingMeApplicationContext.saveContext();
    }

}
