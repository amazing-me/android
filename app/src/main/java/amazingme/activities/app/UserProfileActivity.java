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
<<<<<<< Updated upstream
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        backBtn = (Button) findViewById(backToRegisterBtn);
=======
    public EnumeratedActivity activityName() {
        return EnumeratedActivity.USERPROFILE;
    }
    //git stash
    @Override
    public void bindToUserInterface() {
        backBtn = (Button) findViewById(R.id.user_profile_back_button);
        doneBtn = (Button) findViewById(R.id.button3);
        childBtn = (Button) findViewById(R.id.button2);
        firstnameEditText = (EditText) findViewById(R.id.editText2);
        lastnameEditText = (EditText) findViewById(R.id.editText4);
        ageEditText = (EditText) findViewById(R.id.editText5);
        sexEditText = (EditText) findViewById(R.id.editText7);
        profview = (TextView) findViewById(R.id.textView4);
        abilityview = (TextView) findViewById(R.id.textView5);

        yesnoSpinner = (Spinner) findViewById(R.id.spinner1);

        ArrayAdapter<String> spinAdapter = new ArrayAdapter<String>(UserProfileActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.yesno));
        spinAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        yesnoSpinner.setAdapter(spinAdapter);
>>>>>>> Stashed changes

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
