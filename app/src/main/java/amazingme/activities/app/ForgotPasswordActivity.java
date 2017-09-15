package amazingme.activities.app;

import android.view.View;
import android.widget.Button;

import com.amazingme.activities.R;

import amazingme.app.EnumeratedActivity;
import amazingme.model.AmazingMeAppCompatActivity;

public class ForgotPasswordActivity extends AmazingMeAppCompatActivity {

    private Button backBtn, sendBtn;

    public ForgotPasswordActivity() {
        super(R.layout.activity_forgot_password);
    }

    @Override
    public EnumeratedActivity activityName() {
        return EnumeratedActivity.FORGOT_PASSWORD;
    }

    @Override
    public void bindToUserInterface() {
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
}
