package amazingme.activities.app;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.amazingme.activities.R;

import amazingme.app.EnumeratedActivity;
import amazingme.model.AmazingMeAppCompatActivity;

public class ForgotPasswordActivity extends AmazingMeAppCompatActivity {

    private Button backBtn, sendBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        backBtn = (Button) findViewById(R.id.forgot_password_back_button);
        sendBtn = (Button) findViewById(R.id.forgot_password_send_button);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goTo(EnumeratedActivity.LOGIN);
            }
        });

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: Implement Forgot Password Functionality
            }
        });

    }

    @Override
    public EnumeratedActivity activityName() {
        return EnumeratedActivity.FORGOTPASSWORD;
    }
}
