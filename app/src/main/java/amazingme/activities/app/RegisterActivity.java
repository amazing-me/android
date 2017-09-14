package amazingme.activities.app;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.amazingme.activities.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuthEmailException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;

import amazingme.activities.util.DialogHelper;
import amazingme.app.EnumeratedActivity;
import amazingme.database.ISession;
import amazingme.model.AmazingMeAppCompatActivity;

public class RegisterActivity extends AmazingMeAppCompatActivity {

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

            getContext().getSessionManager().registerSession(email, password, "First Last")
            .addOnSuccessListener(new OnSuccessListener<ISession>() {
                @Override
                public void onSuccess(ISession iSession) {
                    goTo(EnumeratedActivity.MAIN_MENU);
                }
            })
            .addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    final String registrationFailed = RegisterActivity.this.getResources().getString(R.string.dialog_registration_failed);
                    final AlertDialog.Builder alertDialog = DialogHelper.getAlertDialog(RegisterActivity.this, registrationFailed);
                    final String exceptionMessage = getRegistrationExceptionMessage(e);

                    alertDialog.setMessage(exceptionMessage);
                    alertDialog.show();
                }
            });

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
    public EnumeratedActivity activityName() {
        return EnumeratedActivity.REGISTRATION;
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
