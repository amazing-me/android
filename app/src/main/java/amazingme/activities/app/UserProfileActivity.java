package amazingme.activities.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.amazingme.activities.R;

import amazingme.app.EnumeratedActivity;
import amazingme.model.AmazingMeAppCompatActivity;

import static com.amazingme.activities.R.id.backToRegisterBtn;

public class UserProfileActivity extends AmazingMeAppCompatActivity {

    private Button backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        backBtn = (Button) findViewById(backToRegisterBtn);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent backIntent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(backIntent);
            }
        });
    }

    @Override
    public EnumeratedActivity activityName() {
        return EnumeratedActivity.USERPROFILE;
    }
}
