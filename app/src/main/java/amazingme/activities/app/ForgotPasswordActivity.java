package amazingme.activities.app;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.amazingme.activities.R;

import amazingme.app.EnumeratedActivity;
import amazingme.controller.ISessionForgotPasswordHandler;
import amazingme.model.AmazingMeAppCompatActivity;

public class ForgotPasswordActivity extends AmazingMeAppCompatActivity implements ISessionForgotPasswordHandler {

    private Button backBtn, sendBtn;
    private EditText emailText;
    private String email;

    public ForgotPasswordActivity() {
        super(R.layout.activity_forgot_password);
    }

    @Override
    public EnumeratedActivity activityName() {
        return EnumeratedActivity.FORGOT_PASSWORD;
    }

    @Override
    public void bindToUserInterface() {
        backBtn = (Button) findViewById(R.id.forgot_password_back_button);
        sendBtn = (Button) findViewById(R.id.forgot_password_send_button);
        emailText = (EditText) findViewById(R.id.forgot_password_email_text);
        email = emailText.getText().toString();

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goTo(EnumeratedActivity.LOGIN);
            }
        });

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fieldsAreValidated()) {
                    getAppContext().sessionForgotPassword(ForgotPasswordActivity.this, email);
                } else {
                    showForgotPasswordFailedAlertDialog();
                }
            }
        });

    }

    private void showForgotPasswordFailedAlertDialog() {
        final String forgotPasswordFailed = ForgotPasswordActivity.this.getResources().getString(R.string.dialog_forgot_password_failed);
        final String errorMessage = ForgotPasswordActivity.this.getResources().getString(R.string.generic_empty_field_error_message);

        this.showAlertDialogBox(forgotPasswordFailed, errorMessage, null);
    }

    private boolean fieldsAreValidated() {
        return (!email.isEmpty());
    }

    @Override
    public void onSessionForgotPasswordSuccess() {
        final String forgotPassSuccess = getResources().getString(R.string.dialog_forgot_password_success);
        final String forgotPassMessage = getResources().getString(R.string.success_forgot_password);

        this.showInfoDialogBox(forgotPassSuccess, forgotPassMessage, new Runnable() {
            @Override
            public void run() {
                goTo(EnumeratedActivity.LOGIN);
            }
        });
    }

    @Override
    public void onSessionForgotPasswordFailure(Exception e) {
        final String loginFailed = getResources().getString(R.string.dialog_forgot_password_failed);
        final String exceptionMessage = getResources().getString(R.string.error_unknown);

        this.showAlertDialogBox(loginFailed, exceptionMessage, null);

    }

}
