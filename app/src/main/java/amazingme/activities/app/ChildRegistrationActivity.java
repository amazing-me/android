package amazingme.activities.app;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.amazingme.activities.R;

import org.joda.time.LocalDate;

import java.util.Calendar;
import java.util.LinkedList;

import amazingme.app.EnumeratedActivity;
import amazingme.app.AmazingMeAppCompatActivity;
import amazingme.model.Child;
import amazingme.model.KnownDevelopmentalDisabilities;
import amazingme.util.DateAdapter;

public class ChildRegistrationActivity extends AmazingMeAppCompatActivity {

    private Button addAnotherChildButton, doneBtn;
    private Spinner birthMonth, birthDay, birthYear;
    private int month, day, year;
    private Child.Sex sex;
    private String firstName, lastName;
    private DatePickerFragment datePickerFragment = new DatePickerFragment();

    public ChildRegistrationActivity() { super(R.layout.activity_child_registration); }

    @Override
    public EnumeratedActivity activityName() {
        return EnumeratedActivity.CHILD_REGISTRATION;
    }

    @Override
    public void bindToUserInterface() {
        initDoneButton();
        initSexSpinner();
        addAnotherChildButton = (Button) findViewById(R.id.child_registration_add_another_button);
        addAnotherChildButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstName = ((EditText) findViewById(R.id.child_registration_first_name)).getText().toString();
                lastName = ((EditText) findViewById(R.id.child_registration_last_name)).getText().toString();

                registerChild(firstName, lastName, sex, EnumeratedActivity.CHILD_REGISTRATION);
            }
        });
    }

    private void initDoneButton() {
        //todo -> actually get some arguments for the sex
        doneBtn = (Button) findViewById(R.id.child_registration_done_button);
        doneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstName = ((EditText) findViewById(R.id.child_registration_first_name)).getText().toString();
                lastName = ((EditText) findViewById(R.id.child_registration_last_name)).getText().toString();
                registerChild(firstName, lastName, sex, EnumeratedActivity.MAIN_MENU);
            }
        });
    }

    private void registerChild(final String firstName, final String lastName, final Child.Sex sex, EnumeratedActivity nextActivity) {
        if (fieldsAreValidated()) {
            long dateOfBirth = datePickerFragment.getDateOfBirth();
            // TODO -> I don't like that I instantiated the child here... pass all the info to the context and let it do the work. maybe use a factory/builder pattern
            Child child = new Child(firstName, lastName, sex, dateOfBirth, new LinkedList<KnownDevelopmentalDisabilities>());
            getUserContext().addChild(child);
            getAppContext().saveUserContext();

            goTo(nextActivity);
        } else {
            showChildRegistrationFailedAlertDialog();
        }
    }

    private boolean fieldsAreValidated() {
        return ((!firstName.isEmpty()) && (!lastName.isEmpty()));
    }

    private void showChildRegistrationFailedAlertDialog() {
        final String childRegistrationFailed = ChildRegistrationActivity.this.getResources().getString(R.string.child_registration_failed);
        final String exceptionMessage = ChildRegistrationActivity.this.getResources().getString(R.string.generic_empty_field_error_message);

        this.showAlertDialogBox(childRegistrationFailed, exceptionMessage, null);
    }

    private void initSexSpinner() {
        birthMonth = (Spinner) findViewById(R.id.child_registration_sex_spinner);
        ArrayAdapter<CharSequence> dataAdapter = ArrayAdapter.createFromResource(this, R.array.sex_options, android.R.layout.simple_spinner_item);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        birthMonth.setAdapter(dataAdapter);
        birthMonth.setOnItemSelectedListener(new SexSpinnerListener());
    }

    //TODO -> make these a separate class that can be used for other places.

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


    public void showDatePickerDialog(View v) {
        datePickerFragment.show(getSupportFragmentManager(), "datePicker");
    }

    public static class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {

        private long date;

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            // Do something with the date chosen by the user
            date = DateAdapter.convertLocalDateToMillis(new LocalDate(year, month, day));
        }

        public long getDateOfBirth() {
            return date;
        }
    }
}