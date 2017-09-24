package amazingme.activities.app;

import android.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.amazingme.activities.R;

import org.w3c.dom.Text;

import amazingme.activities.util.DialogHelper;
import amazingme.app.EnumeratedActivity;
import amazingme.controller.ISessionForgotPasswordHandler;
import amazingme.model.AmazingMeAppCompatActivity;

public class ForgotPasswordActivity extends AmazingMeAppCompatActivity implements ISessionForgotPasswordHandler {

    private Button backBtn, sendBtn;
    private TextView emailText;

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
        emailText = (TextView) findViewById(R.id.forgot_password_email_text);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goTo(EnumeratedActivity.LOGIN);
            }
        });

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getAppContext().sessionForgotPassword(ForgotPasswordActivity.this, emailText.getText().toString());
            }
        });

    }

    @Override
    public void onSessionForgotPasswordSuccess() {
        final String forgotPassSuccess = getResources().getString(R.string.dialog_forgot_password_success);
        final String forgotPassMessage = getResources().getString(R.string.success_forgot_password);

        final AlertDialog.Builder alertDialog = DialogHelper.getInfoDialog(this, forgotPassSuccess, new Runnable() {
            @Override
            public void run() {
                goTo(EnumeratedActivity.LOGIN);
            }
        });

        alertDialog.setMessage(forgotPassMessage);
        alertDialog.show();
    }

    @Override
    public void onSessionForgotPasswordFailure(Exception e) {
        final String loginFailed = getResources().getString(R.string.dialog_forgot_password_failed);
        final String exceptionMessage = getResources().getString(R.string.error_unknown);

        final AlertDialog.Builder alertDialog = DialogHelper.getAlertDialog(this, loginFailed);
        alertDialog.setMessage(exceptionMessage);
        alertDialog.show();
    }

}
