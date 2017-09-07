package amazingme.activities.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.amazingme.activities.R;

import amazingme.app.EnumeratedActivity;
import amazingme.database.FirebaseHelper;
import amazingme.model.AmazingMeAppCompatActivity;

public class RegisterActivity extends AmazingMeAppCompatActivity {
    private EditText firstNameEditText, lastNameEditText, emailEditText, passwordEditText;
    private Button registerBtn, backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        firstNameEditText = (EditText) findViewById(R.id.firstNameEditText);
        lastNameEditText = (EditText) findViewById(R.id.lastNameEditText);
        emailEditText = (EditText) findViewById(R.id.emailEditText);
        passwordEditText = (EditText) findViewById(R.id.passwordEditText);
        registerBtn = (Button) findViewById(R.id.registerBtn);
        backBtn = (Button) findViewById(R.id.backBtn);


        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstName = firstNameEditText.getText().toString();
                String lastName = lastNameEditText.getText().toString();
                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                FirebaseHelper.createNewUser(firstName, lastName, email, password, getApplicationContext());
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent backIntent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(backIntent);
            }
        });
    }

    @Override
    public EnumeratedActivity activityName() {
        return EnumeratedActivity.REGISTRATION;
    }
}
