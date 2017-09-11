package amazingme.activities.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.amazingme.activities.R;

import amazingme.app.EnumeratedActivity;
import amazingme.controller.ActivityManager;
import amazingme.model.AmazingMeAppCompatActivity;

import static com.amazingme.activities.R.id.backFPBtn;
import static com.amazingme.activities.R.id.sendPBtn;

public class ForgotPasswordActivity extends AmazingMeAppCompatActivity {

    private Button backBtn, sendBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        backBtn = (Button) findViewById(backFPBtn);
        sendBtn = (Button) findViewById(sendPBtn);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityManager.getInstance().goTo(ForgotPasswordActivity.this, EnumeratedActivity.LOGIN);
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
