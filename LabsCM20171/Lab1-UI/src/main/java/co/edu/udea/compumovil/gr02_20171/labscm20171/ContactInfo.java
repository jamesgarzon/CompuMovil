package co.edu.udea.compumovil.gr02_20171.labscm20171;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class ContactInfo extends AppCompatActivity {

    private AutoCompleteTextView autoCompleteCountries;
    private AutoCompleteTextView autoCompleteCities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_info);

        autoCompleteCountries = (AutoCompleteTextView) findViewById(R.id.autoCompleteCountry);
        autoCompleteCities = (AutoCompleteTextView) findViewById(R.id.autoCompleteCities);

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
