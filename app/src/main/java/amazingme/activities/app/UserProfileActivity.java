package amazingme.activities.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.amazingme.activities.R;

import static com.amazingme.activities.R.id.backToRegisterBtn;

public class UserProfileActivity extends AppCompatActivity {

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
}
