package co.edu.udea.compumovil.gr02_20171.labscm20171;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Date;

public class ShowInfo extends AppCompatActivity {

    Person person;
    TextView showName;
    TextView showLastName;
    TextView showBirthday;
    TextView showSex;
    TextView showGrade;
    TextView showPhone;
    TextView showEmail;
    TextView showCounty;
    TextView showCity;
    TextView showAddress;
    TextView showHobbies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_info);

        Intent i = getIntent();
        person = (Person) i.getSerializableExtra("MyClass");

        showName = (TextView) findViewById(R.id.show_name);
        showLastName = (TextView) findViewById(R.id.show_lastname);
        showBirthday = (TextView) findViewById(R.id.show_birthday);
        showSex = (TextView) findViewById(R.id.show_sex);
        showGrade = (TextView) findViewById(R.id.show_grade);
        showPhone = (TextView) findViewById(R.id.show_phone);
        showEmail = (TextView) findViewById(R.id.show_email);
        showCounty = (TextView) findViewById(R.id.show_country);
        showCity = (TextView) findViewById(R.id.show_city);
        showAddress = (TextView) findViewById(R.id.show_address);
        showHobbies = (TextView) findViewById(R.id.show_hobbies);


        showName.setText("Nombre: "+person.getName());
        showLastName.setText("Apellido: "+person.getLastName());
        showBirthday.setText("Fecha Cumpleaños: "+person.getBirthday().toGMTString());
        showSex.setText("Sexo: "+person.getSex());
        showGrade.setText("Grado de escolaridad: "+person.getScholarityGrade());
        showPhone.setText("Teléfono: "+person.getPhone());
        showEmail.setText("Correo: "+person.getEmail());
        showCounty.setText("País: "+person.getCountry());
        showCity.setText("Ciudad: "+person.getCity());
        showAddress.setText("Dirección: "+person.getAddress());
        showHobbies.setText("Hobbies: "+person.getHobbies());


    }
}
