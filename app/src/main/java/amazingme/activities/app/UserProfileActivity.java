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

public class UserProfileActivity extends AmazingMeAppCompatActivity {

    private Button backBtn, doneBtn, childBtn;
    private EditText firstnameEditText, lastnameEditText, ageEditText, sexEditText;
    private TextView profview,abilityview;
    private Spinner yesnoSpinner, malefemale;

    public UserProfileActivity() { super(R.layout.activity_user_profile); }

    @Override
    public EnumeratedActivity activityName() {
        return EnumeratedActivity.USERPROFILE;
    }

    @Override
<<<<<<< HEAD
    public void bindToUserInterface() {
        backBtn = (Button) findViewById(R.id.user_profile_back_button);
        doneBtn = (Button) findViewById(R.id.button3);
        childBtn = (Button) findViewById(R.id.button2);
        firstnameEditText = (EditText) findViewById(R.id.editText2);
        lastnameEditText = (EditText) findViewById(R.id.editText4);
        ageEditText = (EditText) findViewById(R.id.editText5);
        //sexEditText = (EditText) findViewById(R.id.editText7);
        profview = (TextView) findViewById(R.id.textView4);
        abilityview = (TextView) findViewById(R.id.textView5);

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

=======
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
>>>>>>> 4f8bc0777e41e86da0f6c6504670dbf934801efb

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goTo(EnumeratedActivity.REGISTRATION);
            }
        });
    }
}
