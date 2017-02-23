package co.edu.udea.compumovil.gr02_20171.labscm20171;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

public class ContactInfo extends AppCompatActivity {

    private AutoCompleteTextView autoCompleteCountries;
    private AutoCompleteTextView autoCompleteCities;
    private EditText phoneEditText;
    private EditText emailEditText;
    private Button nextContacInfo;
    private Person person = null;
    private EditText addressEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_info);
        Log.d("MYAPP", "ContactInfo");

        Intent i = getIntent();
        person = (Person) i.getSerializableExtra("MyClass");

        autoCompleteCountries = (AutoCompleteTextView) findViewById(R.id.autoCompleteCountry);
        autoCompleteCities = (AutoCompleteTextView) findViewById(R.id.autoCompleteCities);
        phoneEditText = (EditText) findViewById(R.id.editText);
        emailEditText = (EditText) findViewById(R.id.editText2);
        nextContacInfo = (Button) findViewById(R.id.nextContacInfo);
        addressEditText = (EditText) findViewById(R.id.editText3);

        nextContacInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                person.setPhone(phoneEditText.getText().toString());
                person.setEmail(emailEditText.getText().toString());
                person.setAddress(addressEditText.getText().toString());
                person.setCountry(autoCompleteCountries.getText().toString());
                person.setCity(autoCompleteCities.getText().toString());

                Intent intent = new Intent(ContactInfo.this, OtherInfo.class);

                intent.putExtra("MyClass", person);

                startActivity(intent);
            }
        });

        String[] countries = getResources().getStringArray(R.array.countries);
        String[] cities = getResources().getStringArray(R.array.mainCitiesColombia);

        ArrayAdapter<String> adapterCountries = new ArrayAdapter<String>
                (this,android.R.layout.simple_list_item_1,countries);
        ArrayAdapter<String> adapterCities = new ArrayAdapter<String>
                (this,android.R.layout.simple_list_item_1,cities);

        autoCompleteCountries.setAdapter(adapterCountries);
        autoCompleteCities.setAdapter(adapterCities);
    }
}
