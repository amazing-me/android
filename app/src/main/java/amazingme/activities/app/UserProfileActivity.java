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
    private String firstNameString, lastNameString;

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
        firstNameString = firstName.getText().toString();
        lastNameString = lastName.getText().toString();

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goTo(EnumeratedActivity.REGISTRATION);
            }
        });

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fieldsAreValidated()) {
                    Parent parent = getUserContext().getParent();
                    parent.setFirstName(firstNameString);
                    parent.setLastName(lastNameString);

                    getAppContext().saveUserContext();
                    goTo(EnumeratedActivity.PCP_INFORMATION);
                }
            }
        });
    }

    private boolean fieldsAreValidated() {
        return ((!firstNameString.isEmpty()) && (!lastNameString.isEmpty()));
    }

}
