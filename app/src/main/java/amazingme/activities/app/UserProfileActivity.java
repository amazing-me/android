package amazingme.activities.app;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.amazingme.activities.R;

import amazingme.app.EnumeratedActivity;
import amazingme.model.AmazingMeAppCompatActivity;
import amazingme.model.Parent;

public class UserProfileActivity extends AmazingMeAppCompatActivity {

    private Button backBtn, nextBtn;
    private EditText firstName, lastName;

    public UserProfileActivity() { super(R.layout.activity_user_profile); }

    @Override
    public EnumeratedActivity activityName() {
        return EnumeratedActivity.USER_PROFILE;
    }

    @Override
    public void bindToUserInterface() {
        backBtn = (Button) findViewById(R.id.user_profile_back_button);
        nextBtn = (Button) findViewById(R.id.user_profile_next_button);
        firstName = (EditText) findViewById(R.id.user_profile_first_name_edit_text);
        lastName = (EditText) findViewById(R.id.user_profile_last_name_edit_text);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goTo(EnumeratedActivity.REGISTRATION);
            }
        });

        nextBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Parent parent = getAppContext().getUserContext().getParent();
                parent.setFirstName(firstName.getText().toString());
                parent.setLastName(lastName.getText().toString());

                getAppContext().saveUserContext();
                goTo(EnumeratedActivity.PCP_INFORMATION);
            }
        });
    }

}
