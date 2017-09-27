package amazingme.activities.app;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.amazingme.activities.R;

import org.joda.time.DateTime;
import org.joda.time.Instant;
import org.joda.time.LocalDate;
import org.joda.time.Months;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import amazingme.app.EnumeratedActivity;
import amazingme.model.AmazingMeAppCompatActivity;
import amazingme.model.Child;
import amazingme.model.KnownDevelopmentalDisabilities;

public class ChildRegistrationActivity extends AmazingMeAppCompatActivity {

    private Button backBtn, doneBtn;
    private Spinner birthMonth, birthDay, birthYear;
    private int month, day, year;
    private Child.Sex sex;

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
        initSexSpinner();
        backBtn = (Button) findViewById(R.id.child_registration_add_another_button);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goTo(EnumeratedActivity.PCP_INFORMATION);
            }
        });
    }

    private void initDoneButton() {
        //todo -> actually get some arguments for the sex
        doneBtn = (Button) findViewById(R.id.child_registration_done_button);
        doneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstName = ((EditText) findViewById(R.id.child_registration_first_name)).getText().toString();
                String lastName = ((EditText) findViewById(R.id.child_registration_last_name)).getText().toString();
                LocalDate dateOfBirth = new LocalDate(year, month, day);

                Child child = new Child(firstName, lastName, sex, dateOfBirth, new LinkedList<KnownDevelopmentalDisabilities>());
                getUserContext().addChild(child);
                getAppContext().saveUserContext();

                goTo(EnumeratedActivity.LANDING_PAGE);
            }
        });
    }

    private void initSexSpinner() {
        birthMonth = (Spinner) findViewById(R.id.child_registration_sex_spinner);
        ArrayAdapter<CharSequence> dataAdapter = ArrayAdapter.createFromResource(this, R.array.sex_options, android.R.layout.simple_spinner_item);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        birthMonth.setAdapter(dataAdapter);
        birthMonth.setOnItemSelectedListener(new SexSpinnerListener());
    }

    private void initMonthSpinner() {
        birthMonth = (Spinner) findViewById(R.id.child_registration_month_spinner);
        ArrayAdapter<CharSequence> dataAdapter = ArrayAdapter.createFromResource(this, R.array.months, android.R.layout.simple_spinner_item);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        birthMonth.setAdapter(dataAdapter);
        birthMonth.setOnItemSelectedListener(new MonthSpinnerListener());
    }

    private void initDaySpinner() {
        birthDay = (Spinner) findViewById(R.id.child_registration_day_spinner);
        ArrayAdapter<CharSequence> dataAdapter = ArrayAdapter.createFromResource(this, R.array.days, android.R.layout.simple_spinner_item);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        birthDay.setAdapter(dataAdapter);
        birthDay.setOnItemSelectedListener(new DaySpinnerListener());
    }

    private void initYearSpinner() {
        birthYear = (Spinner) findViewById(R.id.child_registration_year_spinner);
        ArrayAdapter<CharSequence> dataAdapter = ArrayAdapter.createFromResource(this, R.array.years, android.R.layout.simple_spinner_item);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        birthYear.setAdapter(dataAdapter);
        birthYear.setOnItemSelectedListener(new YearSpinnerListener());
    }

    //TODO -> make these a separate class that can be used for other places.

    private class MonthSpinnerListener implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            if (!parent.getItemAtPosition(position).toString().equalsIgnoreCase("MONTH")) {
                month = Integer.parseInt(parent.getItemAtPosition(position).toString());
            }
            Toast.makeText(parent.getContext(), String.valueOf(month), Toast.LENGTH_LONG).show();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {
            Toast.makeText(parent.getContext(), "Month", Toast.LENGTH_LONG).show();
        }
    }

    private class SexSpinnerListener implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            //would rather figure out how to give the hint but whatever
            if (!parent.getItemAtPosition(position).toString().toUpperCase().equalsIgnoreCase("SEX")) {
                sex = Child.Sex.valueOf(parent.getItemAtPosition(position).toString().toUpperCase());
            }
            Toast.makeText(parent.getContext(), String.valueOf(sex), Toast.LENGTH_LONG).show();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {
            Toast.makeText(parent.getContext(), "Sex", Toast.LENGTH_LONG).show();
        }
    }


    private class DaySpinnerListener implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            if (!parent.getItemAtPosition(position).toString().equalsIgnoreCase("DAY")) {
                day = Integer.parseInt(parent.getItemAtPosition(position).toString());
            }
            Toast.makeText(parent.getContext(), String.valueOf(day), Toast.LENGTH_LONG).show();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {
            Toast.makeText(parent.getContext(), "Day", Toast.LENGTH_LONG).show();
        }
    }

    private class YearSpinnerListener implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            if (!parent.getItemAtPosition(position).toString().equalsIgnoreCase("YEAR")) {
                year = Integer.parseInt(parent.getItemAtPosition(position).toString());
            }
            Toast.makeText(parent.getContext(), String.valueOf(year), Toast.LENGTH_LONG).show();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {
            Toast.makeText(parent.getContext(), "Year", Toast.LENGTH_LONG).show();
        }
    }
}
