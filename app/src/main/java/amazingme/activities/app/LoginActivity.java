package amazingme.activities.app;

import android.app.AlertDialog;
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

import amazingme.activities.util.DialogHelper;
import amazingme.app.EnumeratedActivity;
import amazingme.controller.ISessionInitHandler;
import amazingme.controller.ISessionLoginHandler;
import amazingme.database.Session;
import amazingme.model.AmazingMeAppCompatActivity;

public class LoginActivity extends AmazingMeAppCompatActivity implements ISessionLoginHandler, ISessionInitHandler {

    private EditText emailEditText, passwordEditText;
    private Button loginBtn, registerBtn;
    private TextView forgotPasswordTextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getContext().getSessionManager().initialize(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailEditText = (EditText) findViewById(R.id.emailEditText);
        passwordEditText = (EditText) findViewById(R.id.passwordEditText);
        loginBtn = (Button) findViewById(R.id.loginBtn);
        registerBtn = (Button) findViewById(R.id.registerBtn);
        forgotPasswordTextBtn = (TextView) findViewById(R.id.forgotpasswordBtn);

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

                getContext().getSessionManager().login(email, password, LoginActivity.this);
            }
        });

        forgotPasswordTextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goTo(EnumeratedActivity.FORGOTPASSWORD);
            }
        });
    }

    @Override
    public EnumeratedActivity activityName() {
        return EnumeratedActivity.LOGIN;
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

    @Override
    public void onSessionLoginSuccess(Session session) {
        goTo(EnumeratedActivity.MAIN_MENU);
    }

    @Override
    public void onSessionLoginFailure(Exception e) {
        final String loginFailed = LoginActivity.this.getResources().getString(R.string.dialog_login_failed);
        final AlertDialog.Builder alertDialog = DialogHelper.getAlertDialog(LoginActivity.this, loginFailed);
        final String exceptionMessage = getLoginExceptionMessage(e);

        alertDialog.setMessage(exceptionMessage);
        alertDialog.show();
    }

    @Override
    public void onSessionInitSuccess(Session session) {
        goToIfSignedIn(EnumeratedActivity.MAIN_MENU);
    }

    @Override
    public void onSessionInitFailure(Exception e) {
    }

}
