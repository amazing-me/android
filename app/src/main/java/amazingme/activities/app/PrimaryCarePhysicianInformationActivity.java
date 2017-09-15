package amazingme.activities.app;

import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ToggleButton;

import com.amazingme.activities.R;

import amazingme.app.EnumeratedActivity;
import amazingme.model.AmazingMeAppCompatActivity;

public class PrimaryCarePhysicianInformationActivity extends AmazingMeAppCompatActivity {

    private Button nextBtn, backBtn;
    private ToggleButton toggleBtn;
    private EditText pcp_email, pcp_phoneNumber;
    private boolean hasPCPInformation = false;

    public PrimaryCarePhysicianInformationActivity() { super(R.layout.activity_pcp_information_page); }

    @Override
    public EnumeratedActivity activityName() {
        return EnumeratedActivity.PCP_INFORMATION;
    }

    @Override
    public void bindToUserInterface() {
        this.setToggleFunctionality();
        backBtn = (Button) findViewById(R.id.pcp_information_back_button);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {goTo(EnumeratedActivity.USERPROFILE); }
        });
        this.setNextFunctionality();
    }

    private void setNextFunctionality() {
        nextBtn = (Button) findViewById(R.id.pcp_information_next_button);
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(hasPCPInformation) {
                    String email = ((EditText)findViewById(R.id.pcp_information_email_edit_text)).getText().toString();
                    String phoneNumber = ((EditText)findViewById(R.id.pcp_information_phone_number_edit_text)).getText().toString();
                    //TODO -> put the user information in the user context
                }
                // TODO -> why isn't this made??
                // goTo(EnumeratedActivity.CHILD_PROFILE_PAGE);
            }
        });
    }

    private void setToggleFunctionality() {
        toggleBtn = (ToggleButton) findViewById(R.id.pcp_information_toggle_button);
        pcp_email = (EditText) findViewById(R.id.pcp_information_email_edit_text);
        pcp_phoneNumber = (EditText) findViewById(R.id.pcp_information_phone_number_edit_text);

        toggleBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    pcp_email.setVisibility(View.VISIBLE);
                    pcp_phoneNumber.setVisibility(View.VISIBLE);
                    hasPCPInformation = true;
                } else {
                    pcp_email.setVisibility(View.GONE);
                    pcp_phoneNumber.setVisibility(View.GONE);
                    hasPCPInformation = false;
                }
            }
        });
    }
}
