package amazingme.activities.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.amazingme.activities.R;

import amazingme.app.EnumeratedActivity;
import amazingme.controller.ActivityManager;
import amazingme.database.FirebaseHelper;
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
                FirebaseHelper.createNewUser(email, password, RegisterActivity.this);
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ActivityManager activityManager = ActivityManager.getInstance();
                activityManager.goTo(RegisterActivity.this, EnumeratedActivity.LOGIN);
            }
        });
    }

    @Override
    public EnumeratedActivity activityName() {
        return EnumeratedActivity.REGISTRATION;
    }
}
