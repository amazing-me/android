package amazingme.activities.app;

import android.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.amazingme.activities.R;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuthEmailException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;

import amazingme.activities.util.DialogHelper;
import amazingme.app.AmazingMeApplicationContext;
import amazingme.app.EnumeratedActivity;
import amazingme.app.UserContext;
import amazingme.controller.RegistrationHandlingActivity;
import amazingme.model.AmazingMeAppCompatActivity;
import amazingme.model.Child;
import amazingme.model.GameResult;
import amazingme.model.Parent;
import amazingme.model.Problem;

public class RegisterActivity extends AmazingMeAppCompatActivity implements RegistrationHandlingActivity {
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
        //nextBtn = (Button) findViewById((R.id.nextBtn));

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = emailEditText.getText().toString();
                final String password = passwordEditText.getText().toString();
//
//                AmazingMeApplicationContext.createNewSession(email, password, RegisterActivity.this);
//
//                UserContext testUserContext = new UserContext();
//                testUserContext.currentChildUser = 0;
//                testUserContext.parent = new Parent("PARENT FIRST NAME", "PARENT LAST NAME", "allybmall@gmail.com", "", "");
//                Child child1 = new Child("CHILD 1 FIRST NAME", "CHILD 1 LAST NAME", Child.Sex.MALE, 3, null);
//                Child child2 = new Child("CHILD 2 FIRST NAME", "CHILD 2 LAST NAME", Child.Sex.FEMALE, 4, null);
//                testUserContext.children.put(0, child1);
//                testUserContext.children.put(1, child2);
//                testUserContext.gameResults.add(0, new GameResult(94, new Problem[] {Problem.DID_NOT_FINISH}));
//                AmazingMeApplicationContext.setUserContext(testUserContext);
//                AmazingMeApplicationContext.saveContext();

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
    public void handle(Task<AuthResult> task) {
        final String registrationFailed = this.getResources().getString(R.string.dialog_registration_failed);
        final AlertDialog.Builder alertDialog = DialogHelper.getAlertDialog(this, registrationFailed);

        if (task.isSuccessful()) {
            goTo(EnumeratedActivity.MAIN_MENU);
        } else {
            final String exceptionMessage = getRegistrationExceptionMessage(task.getException());

            alertDialog.setMessage(exceptionMessage);
            alertDialog.show();
        }
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
