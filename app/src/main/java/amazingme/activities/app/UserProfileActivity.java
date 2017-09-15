package amazingme.activities.app;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.amazingme.activities.R;

import amazingme.app.EnumeratedActivity;
import amazingme.model.AmazingMeAppCompatActivity;

import static com.amazingme.activities.R.id.user_profile_back_button;

public class UserProfileActivity extends AmazingMeAppCompatActivity {

    private Button backBtn, doneBtn, childBtn;
    private EditText firstnameEditText, lastnameEditText, ageEditText, sexEditText;
    private TextView profview,abilityview, sexview;
    private Spinner yesnoSpinner, malefemale;

    public UserProfileActivity() { super(R.layout.activity_user_profile); }

    @Override
    public EnumeratedActivity activityName() {
        return EnumeratedActivity.USERPROFILE;
    }

    @Override
    public void bindToUserInterface() {
        backBtn = (Button) findViewById(user_profile_back_button);
        doneBtn = (Button) findViewById(R.id.button3);
        childBtn = (Button) findViewById(R.id.button2);
        firstnameEditText = (EditText) findViewById(R.id.editText2);
        lastnameEditText = (EditText) findViewById(R.id.editText4);
        ageEditText = (EditText) findViewById(R.id.editText5);
        //sexEditText = (EditText) findViewById(R.id.editText7);
        profview = (TextView) findViewById(R.id.textView4);
        abilityview = (TextView) findViewById(R.id.textView5);
        sexview = (TextView) findViewById(R.id.lable);

        yesnoSpinner = (Spinner) findViewById(R.id.spinner1);
        malefemale = (Spinner) findViewById(R.id.spinner2);

        ArrayAdapter<String> spinAdapter = new ArrayAdapter<String>(UserProfileActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.yesno));
        spinAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        yesnoSpinner.setAdapter(spinAdapter);

        ArrayAdapter<String> spinAdapter2 = new ArrayAdapter<String>(UserProfileActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.sex));
        spinAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        malefemale.setAdapter(spinAdapter2);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goTo(EnumeratedActivity.REGISTRATION);
            }
        });
    }
}
