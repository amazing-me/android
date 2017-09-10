package amazingme.activities.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.amazingme.activities.R;

import amazingme.app.EnumeratedActivity;
import amazingme.model.AmazingMeAppCompatActivity;

public class ForgotPasswordActivity extends AmazingMeAppCompatActivity {

    private Button backFPBtn, sendPBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        backFPBtn = (Button) findViewById(R.id.backFPBtn);
        sendPBtn = (Button) findViewById(R.id.sendPBtn);

        backFPBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent backIntent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(backIntent);
            }
        });

        sendPBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent backIntent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(backIntent);
            }
        });

    }

    @Override
    public EnumeratedActivity activityName() {
        return EnumeratedActivity.FORGOTPASSWORD;
    }
}
