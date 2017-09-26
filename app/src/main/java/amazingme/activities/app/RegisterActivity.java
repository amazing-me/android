package amazingme.activities.app;

import android.app.AlertDialog;
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

    public RegisterActivity() { super(R.layout.activity_register); }

    @Override
    public EnumeratedActivity activityName() {
        return EnumeratedActivity.REGISTRATION;
    }

    @Override
    public void bindToUserInterface() {
        emailEditText = (EditText) findViewById(R.id.register_activity_email_edit_text);
        passwordEditText = (EditText) findViewById(R.id.register_activity_password_edit_text);
        registerBtn = (Button) findViewById(R.id.register_activity_register_button);
        backBtn = (Button) findViewById(R.id.register_activity_back_button);

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = emailEditText.getText().toString();
                final String password = passwordEditText.getText().toString();

                getAppContext().sessionRegister(email, password, RegisterActivity.this);
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
    public void onSessionRegisterSuccess(Session session) {
        goTo(EnumeratedActivity.USER_PROFILE);
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
