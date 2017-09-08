package amazingme.activities.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.amazingme.activities.R;

import amazingme.app.EnumeratedActivity;
import amazingme.database.FirebaseHelper;
import amazingme.model.AmazingMeAppCompatActivity;

public class LoginActivity extends AmazingMeAppCompatActivity {
    private EditText emailEditText, passwordEditText;
    private Button loginBtn, registerBtn;
    private TextView forgotpasswordTextBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailEditText = (EditText) findViewById(R.id.emailEditText);
        passwordEditText = (EditText) findViewById(R.id.passwordEditText);
        loginBtn = (Button) findViewById(R.id.loginBtn);
        registerBtn = (Button) findViewById(R.id.registerBtn);
        forgotpasswordTextBtn = (TextView) findViewById(R.id.forgotpasswordBtn);

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent registerIntent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(registerIntent);
            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String email = emailEditText.getText().toString();
                final String password = passwordEditText.getText().toString();

                FirebaseHelper.loginUser(email, password, LoginActivity.this);
            }
        });

        forgotpasswordTextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent registerIntent = new Intent(getApplicationContext(), ForgotPasswordActivity.class);
                startActivity(registerIntent);
            }
        });
    }

    @Override
    public EnumeratedActivity activityName() {
        return EnumeratedActivity.LOGIN;
    }
}
