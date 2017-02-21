package co.edu.udea.compumovil.gr02_20171.labscm20171;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.SyncStatusObserver;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import java.util.Calendar;
import java.util.Date;

public class PersonalInfo extends AppCompatActivity {

    Person person = new Person();
    EditText nameTv;
    EditText lastNameTv;
    RadioButton sexRadioMale;
    RadioButton sexRadioFemale;
    Button nextButton;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_info);

        nameTv = (EditText) findViewById(R.id.edit_text_Name);
        lastNameTv = (EditText) findViewById(R.id.edit_text_last_name);
        spinner = (Spinner) findViewById(R.id.scholar_spinner);
        sexRadioMale =(RadioButton) findViewById(R.id.radioMale);
        sexRadioFemale =(RadioButton) findViewById(R.id.radioFemale);
        nextButton = (Button) findViewById(R.id.next);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.scholar_grade, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);



        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                person.setName(nameTv.getText().toString());
                person.setLastName(lastNameTv.getText().toString());
                person.setBirthday(new Date());
                person.setScholarityGrade(spinner.getSelectedItem().toString());

                System.out.println("MOTHERFUCKER");
                Log.d("APP", person.getName() );
                Log.d("APP", person.getLastName());
                Log.d("APP", person.getSex());
                Log.d("APP", person.getScholarityGrade());
                Log.d("APP", person.getBirthday().toString());

            }
        });



    }

    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    public static class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        @Override
        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

        }

    }

    public void onSexCheckBoxClicked(View view){
        boolean checked = ((RadioButton) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.radioMale:
                if (checked){
                    person.setSex(sexRadioMale.getText().toString());
                }
                break;
            case R.id.radioFemale:
                if (checked){
                    person.setSex(sexRadioMale.getText().toString());
                }
                break;
        }

    }



}
