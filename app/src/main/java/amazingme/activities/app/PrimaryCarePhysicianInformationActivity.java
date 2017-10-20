package amazingme.activities.app;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ToggleButton;

import com.amazingme.activities.R;

import amazingme.app.EnumeratedActivity;
import amazingme.model.AmazingMeAppCompatActivity;
import amazingme.model.Parent;

public class PrimaryCarePhysicianInformationActivity extends AmazingMeAppCompatActivity {

    private Button nextBtn, backBtn;
    private ToggleButton toggleBtn;
    private EditText pcpEmail, pcpPhoneNumber;
    private String email, phoneNumber;
    private boolean hasPCPInformation = true;

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
                email = ((EditText)findViewById(R.id.pcp_information_email_edit_text)).getText().toString();
                phoneNumber = ((EditText)findViewById(R.id.pcp_information_phone_number_edit_text)).getText().toString();
                if (fieldsAreValidated()) {
                    // TODO -> also move this kind of setup stuff to user context... just pass the information along
                    Parent parent = getUserContext().getParent();
                    parent.setPrimaryCarePhysicianEmail(email);
                    parent.setPrimaryCarePhysicianPhoneNumber(phoneNumber);

                    getAppContext().saveUserContext();
                    goTo(EnumeratedActivity.CHILD_REGISTRATION);
                } else {
                    showPCPFailedAlertDialog();
                }
            }
        });
    }

    private boolean fieldsAreValidated() {
        if (hasPCPInformation) {
            return !email.isEmpty() && !phoneNumber.isEmpty();
        }
        return true;
    }

    private void showPCPFailedAlertDialog() {
        final String pcpFailed = PrimaryCarePhysicianInformationActivity.this.getResources().getString(R.string.pcp_failed);
        final String exceptionMessage = PrimaryCarePhysicianInformationActivity.this.getResources().getString(R.string.generic_empty_field_error_message);

        this.showAlertDialogBox(pcpFailed, exceptionMessage, null);
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
