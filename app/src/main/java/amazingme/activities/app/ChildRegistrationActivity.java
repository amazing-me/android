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

public class ChildRegistrationActivity extends AmazingMeAppCompatActivity {

    //private Button backBtn, doneBtn;
    //private Spinner birthMonth, birthDay, birthYear;
    //private String month, day, year;
    private Button backBtn, doneBtn, childBtn;
    private EditText firstnameEditText, lastnameEditText, ageEditText, sexEditText;
    private TextView profview, abilityview, sexview;
    private Spinner yesnoSpinner, malefemale;

    public ChildRegistrationActivity() {
        super(R.layout.activity_child_registration);
    }

    @Override
    public EnumeratedActivity activityName() {
        return EnumeratedActivity.CHILD_REGISTRATION;
    }

    @Override
    public void bindToUserInterface() {
        //initMonthSpinner();
        //initDaySpinner();
        //initYearSpinner();
        //initDoneButton();
        //backBtn = (Button) findViewById(R.id.child_registration_add_another_button);
        //backBtn.setOnClickListener(new View.OnClickListener() {
        //@Override
        //public void onClick(View v) {
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

        ArrayAdapter<String> spinAdapter = new ArrayAdapter<String>(ChildRegistrationActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.yesno));
        spinAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        yesnoSpinner.setAdapter(spinAdapter);

        ArrayAdapter<String> spinAdapter2 = new ArrayAdapter<String>(ChildRegistrationActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.sex));
        spinAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        malefemale.setAdapter(spinAdapter2);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goTo(EnumeratedActivity.REGISTRATION);
            }
        });

        childBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goTo(EnumeratedActivity.CHILD_REGISTRATION);
            }
        });
    }

    /*private void initDoneButton() {
        //todo -> save the date of birth and calculate age (child can calculate)
        //todo -> actually get some arguments for the sex
        doneBtn = (Button) findViewById(R.id.child_registration_done_button);
        doneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstName = ((EditText) findViewById(R.id.child_registration_first_name)).getText().toString();
                String lastName = ((EditText) findViewById(R.id.child_registration_last_name)).getText().toString();
                AmazingMeApplicationContext.addChild(new Child(firstName, lastName, Child.Sex.MALE, 3, new LinkedList<KnownDevelopmentalDisabilities>()));
                AmazingMeApplicationContext.saveContext();
                goTo(EnumeratedActivity.LANDING_PAGE);
            }
        });
    }*/

    /*private void initMonthSpinner() {
        birthMonth = (Spinner) findViewById(R.id.child_registration_month_spinner);
        // create this list as a resource
        List<String> categories = new ArrayList<String>();
        categories.add("january");
        categories.add("November");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, categories);
        //adapter should be able to be set by constants here
        birthMonth.setAdapter(dataAdapter);
        birthMonth.setOnItemSelectedListener(new MonthSpinnerListener());
    }

    private void initDaySpinner() {
        birthDay = (Spinner) findViewById(R.id.child_registration_day_spinner);
        List<String> categories = new ArrayList<String>();
        categories.add("1");
        categories.add("15");
        categories.add("31");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, categories);
        birthDay.setAdapter(dataAdapter);
        birthDay.setOnItemSelectedListener(new DaySpinnerListener());
    }

    private void initYearSpinner() {
        birthYear = (Spinner) findViewById(R.id.child_registration_year_spinner);
        List<String> categories = new ArrayList<String>();
        categories.add("1993");
        categories.add("2000");
        categories.add("2017");
        categories.add("2020");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, categories);
        birthYear.setAdapter(dataAdapter);
        birthYear.setOnItemSelectedListener(new YearSpinnerListener());
    }

    private class MonthSpinnerListener extends ChildRegistrationActivity implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            month = parent.getItemAtPosition(position).toString();
            //Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {
            //Toast.makeText(parent.getContext(), "Val", Toast.LENGTH_LONG).show();
        }
    }

    private class DaySpinnerListener implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            day = parent.getItemAtPosition(position).toString();
            //Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {
            //Toast.makeText(parent.getContext(), "Val", Toast.LENGTH_LONG).show();
        }
    }

    private class YearSpinnerListener implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            year = parent.getItemAtPosition(position).toString();
            //Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {
            //Toast.makeText(parent.getContext(), "Val", Toast.LENGTH_LONG).show();
        }
    }*/
}

