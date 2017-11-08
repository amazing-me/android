package amazingme.activities.app;

import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.amazingme.activities.R;
import com.google.firebase.auth.FirebaseAuthEmailException;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;

import amazingme.app.EnumeratedActivity;
import amazingme.controller.ISessionLoginHandler;
import amazingme.database.Session;

import amazingme.app.AmazingMeAppCompatActivity;

public class LoginActivity extends AmazingMeAppCompatActivity implements ISessionLoginHandler {

    private EditText emailEditText, passwordEditText;
    private Button loginBtn, registerBtn;
    private TextView forgotPasswordTextBtn;
    private String email, password;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getAppContext().sessionInitialize(this);
    }

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
                email = emailEditText.getText().toString();
                password = passwordEditText.getText().toString();
                if (fieldsAreValidated()) {
                    getAppContext().sessionLogin(email, password, LoginActivity.this);
                } else {
                    onSessionLoginFailure(new InvalidFieldsException());
                }
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
    public void onSessionLoginSuccess(Session session) {
        goTo(EnumeratedActivity.MAIN_MENU);
    }

    @Override
    public void onSessionLoginFailure(Exception e) {
        final String loginFailed = LoginActivity.this.getResources().getString(R.string.dialog_login_failed);
        final String exceptionMessage = getLoginExceptionMessage(e);

        this.showAlertDialogBox(loginFailed, exceptionMessage, null);
    }

    private String getLoginExceptionMessage(final Exception exception) {
        final String loginTag = this.getResources().getString(R.string.tag_login);
        String exceptionMessage;

        try {
            throw exception;
        } catch (FirebaseAuthInvalidCredentialsException
                | FirebaseAuthEmailException
                | FirebaseAuthInvalidUserException
                | InvalidFieldsException e) {
            exceptionMessage = this.getResources().getString(R.string.error_invalid_credentials);
        } catch (Exception e) {
            Log.e(loginTag, e.getMessage());
            exceptionMessage = this.getResources().getString(R.string.error_unknown);
        }

        return exceptionMessage;
    }

    private boolean fieldsAreValidated() {
        return !email.isEmpty() && !password.isEmpty();
    }

    private class InvalidFieldsException extends Exception {

    }

}