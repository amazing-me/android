package amazingme.activities.app;

import android.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.amazingme.activities.R;
import com.google.firebase.auth.FirebaseAuthEmailException;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;

import amazingme.activities.util.DialogHelper;
import amazingme.app.EnumeratedActivity;
import amazingme.controller.LoginHandlingActivity;
import amazingme.model.AmazingMeAppCompatActivity;

public class LoginActivity extends AmazingMeAppCompatActivity implements LoginHandlingActivity {
    private EditText emailEditText, passwordEditText;
    private Button loginBtn, registerBtn;
    private TextView forgotPasswordTextBtn;


    public LoginActivity() { super(R.layout.activity_login); }

    @Override
    public EnumeratedActivity activityName() {
        return EnumeratedActivity.LOGIN;
    }

    @Override
    public void bindToUserInterface() {
        emailEditText = (EditText) findViewById(R.id.login_activity_email_edit_text);
        passwordEditText = (EditText) findViewById(R.id.login_activity_password_edit_text);
        loginBtn = (Button) findViewById(R.id.login_activity_login_button);
        registerBtn = (Button) findViewById(R.id.login_activity_register_button);
        forgotPasswordTextBtn = (TextView) findViewById(R.id.login_activity_forgot_password_button);

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goTo(EnumeratedActivity.REGISTRATION);
            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String email = emailEditText.getText().toString();
                final String password = passwordEditText.getText().toString();
                goTo(EnumeratedActivity.CHILD_REGISTRATION);
            }
        });

        forgotPasswordTextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goTo(EnumeratedActivity.FORGOT_PASSWORD);
            }
        });
    }

    @Override
    public void handleLoginSuccess() {
        goTo(EnumeratedActivity.MAIN_MENU);
    }

    @Override
    public void handleLoginFailure(Exception e) {
        final String loginFailed = this.getResources().getString(R.string.dialog_login_failed);
        final AlertDialog.Builder alertDialog = DialogHelper.getAlertDialog(this, loginFailed);

        final String exceptionMessage = getLoginExceptionMessage(e);

        alertDialog.setMessage(exceptionMessage);
        alertDialog.show();
    }

    private String getLoginExceptionMessage(final Exception exception) {
        final String loginTag = this.getResources().getString(R.string.tag_login);
        String exceptionMessage;

        try {
            throw exception;
        } catch (FirebaseAuthInvalidCredentialsException
                | FirebaseAuthEmailException
                | FirebaseAuthInvalidUserException e) {
            exceptionMessage = this.getResources().getString(R.string.error_invalid_credentials);
        } catch (Exception e) {
            Log.e(loginTag, e.getMessage());
            exceptionMessage = this.getResources().getString(R.string.error_unknown);
        }

        return exceptionMessage;
    }

}
