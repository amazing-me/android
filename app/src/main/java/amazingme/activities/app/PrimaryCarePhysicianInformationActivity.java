package amazingme.activities.app;

import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ToggleButton;

import com.amazingme.activities.R;

import amazingme.app.AmazingMeApplicationContext;
import amazingme.app.EnumeratedActivity;
import amazingme.model.AmazingMeAppCompatActivity;

public class PrimaryCarePhysicianInformationActivity extends AmazingMeAppCompatActivity {

    private Button nextBtn, backBtn;
    private ToggleButton toggleBtn;
    private EditText pcpEmail, pcpPhoneNumber;
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
            public void onClick(View v) {goTo(EnumeratedActivity.USER_PROFILE); }
        });
        this.setNextFunctionality();
    }

    private void setNextFunctionality() {
        nextBtn = (Button) findViewById(R.id.pcp_information_next_button);
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hasPCPInformation) {
                    String email = ((EditText)findViewById(R.id.pcp_information_email_edit_text)).getText().toString();
                    String phoneNumber = ((EditText)findViewById(R.id.pcp_information_phone_number_edit_text)).getText().toString();
                    AmazingMeApplicationContext.setPrimaryCareEmailAndPhoneNumber(email, phoneNumber);
                }
                goTo(EnumeratedActivity.CHILD_REGISTRATION);
            }
        });
    }

    private void setToggleFunctionality() {
        toggleBtn = (ToggleButton) findViewById(R.id.pcp_information_toggle_button);
        pcpEmail = (EditText) findViewById(R.id.pcp_information_email_edit_text);
        pcpPhoneNumber = (EditText) findViewById(R.id.pcp_information_phone_number_edit_text);

        toggleBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    pcpEmail.setVisibility(View.VISIBLE);
                    pcpPhoneNumber.setVisibility(View.VISIBLE);
                    hasPCPInformation = true;
                } else {
                    pcpEmail.setVisibility(View.GONE);
                    pcpPhoneNumber.setVisibility(View.GONE);
                    hasPCPInformation = false;
                }
            }
        });
    }
}
