package amazingme.activities.app;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.amazingme.activities.R;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import amazingme.app.AmazingMeApplicationContext;
import amazingme.app.EnumeratedActivity;
import amazingme.model.AmazingMeAppCompatActivity;
import amazingme.model.Child;
import amazingme.model.KnownDevelopmentalDisabilities;

public class ChildRegistrationActivity extends AmazingMeAppCompatActivity {

    private Button backBtn, doneBtn;
    private Spinner birthMonth, birthDay, birthYear;
    private String month, day, year;

    public ChildRegistrationActivity() { super(R.layout.activity_child_registration); }

    @Override
    public EnumeratedActivity activityName() {
        return EnumeratedActivity.CHILD_REGISTRATION;
    }

    @Override
    public void bindToUserInterface() {
        initMonthSpinner();
        initDaySpinner();
        initYearSpinner();
        initDoneButton();
        backBtn = (Button) findViewById(R.id.child_registration_add_another_button);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void initDoneButton() {
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
    }

    private void initMonthSpinner() {
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
    }
}
