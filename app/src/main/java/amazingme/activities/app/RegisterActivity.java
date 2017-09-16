package amazingme.activities.app;

import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.amazingme.activities.R;
import com.google.firebase.auth.FirebaseAuthEmailException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;

import amazingme.activities.util.DialogHelper;
import amazingme.app.EnumeratedActivity;
import amazingme.controller.ISessionRegisterHandler;
import amazingme.database.Session;
import amazingme.model.AmazingMeAppCompatActivity;

public class RegisterActivity extends AmazingMeAppCompatActivity implements ISessionRegisterHandler {

    private EditText emailEditText, passwordEditText;
    private Button registerBtn, backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        emailEditText = (EditText) findViewById(R.id.emailEditText);
        passwordEditText = (EditText) findViewById(R.id.passwordEditText);
        registerBtn = (Button) findViewById(R.id.registerBtn);
        backBtn = (Button) findViewById(R.id.backBtn);
        //nextBtn = (Button) findViewById((R.id.nextBtn));

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = emailEditText.getText().toString();
                final String password = passwordEditText.getText().toString();

                getContext().getSessionManager().register(email, password, RegisterActivity.this);
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goTo(EnumeratedActivity.LOGIN);
            }
        });
    }

    @Override
    public EnumeratedActivity activityName() {
        return EnumeratedActivity.REGISTRATION;
    }

    @Override
    public void onSessionRegisterSuccess(Session session) {
        goTo(EnumeratedActivity.MAIN_MENU);
    }

    @Override
    public void onSessionRegisterFailure(Exception e) {
        final String registrationFailed = RegisterActivity.this.getResources().getString(R.string.dialog_registration_failed);
        final AlertDialog.Builder alertDialog = DialogHelper.getAlertDialog(RegisterActivity.this, registrationFailed);
        final String exceptionMessage = getRegistrationExceptionMessage(e);

        alertDialog.setMessage(exceptionMessage);
        alertDialog.show();
    }

    private String getRegistrationExceptionMessage(final Exception exception) {
        final String registrationTag = this.getResources().getString(R.string.tag_registration);
        String exceptionMessage;

        try {
            throw exception;
        } catch (FirebaseAuthEmailException e) {
            exceptionMessage = this.getResources().getString(R.string.error_invalid_email);
        } catch (FirebaseAuthUserCollisionException e) {
            exceptionMessage = this.getResources().getString(R.string.error_user_exists);
        } catch (FirebaseAuthWeakPasswordException e) {
            exceptionMessage = this.getResources().getString(R.string.error_weak_password);
        } catch (Exception e) {
            Log.e(registrationTag, e.getMessage());
            exceptionMessage = this.getResources().getString(R.string.error_unknown);
        }
        return exceptionMessage;
    }

}
