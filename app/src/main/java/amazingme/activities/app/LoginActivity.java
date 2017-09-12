package amazingme.activities.app;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.amazingme.activities.R;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuthEmailException;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;

import amazingme.activities.util.DialogHelper;
import amazingme.app.AmazingMeApplicationContext;
import amazingme.app.EnumeratedActivity;
import amazingme.controller.ActivityManager;
import amazingme.controller.LoginHandlingActivity;
import amazingme.model.AmazingMeAppCompatActivity;

public class LoginActivity extends AmazingMeAppCompatActivity implements LoginHandlingActivity {
    private EditText emailEditText, passwordEditText;
    private Button loginBtn, registerBtn;
    private TextView forgotPasswordTextBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
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

                AmazingMeApplicationContext.restoreSession(email, password, LoginActivity.this);
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

    @Override
    public void handle(Task<AuthResult> task) {
        final String loginFailed = this.getResources().getString(R.string.dialog_login_failed);
        final AlertDialog.Builder alertDialog = DialogHelper.getAlertDialog(this, loginFailed);

        if (task.isSuccessful()) {
            goTo(EnumeratedActivity.MAIN_MENU);
        } else {
            final String exceptionMessage = getLoginExceptionMessage(task.getException());

            alertDialog.setMessage(exceptionMessage);
            alertDialog.show();
        }
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
