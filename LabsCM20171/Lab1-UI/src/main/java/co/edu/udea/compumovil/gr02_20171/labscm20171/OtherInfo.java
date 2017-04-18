package co.edu.udea.compumovil.gr02_20171.labscm20171;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RatingBar;
import android.widget.TextView;


public class OtherInfo extends AppCompatActivity implements View.OnClickListener{

    TextView txtShowInfo;

    Button btnShow;

    CheckBox chRead;
    CheckBox chWTV;
    CheckBox chDance;
    CheckBox chSing;
    CheckBox chSwimming;

    RatingBar rtRead;
    RatingBar rtWTV;
    RatingBar rtDance;
    RatingBar rtSing;
    RatingBar rtSwimming;
    String ratedValue;
    Person person;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_info);

<<<<<<< HEAD
        txtShowInfo = (TextView) findViewById(R.id.showInfo);
        btnShow = (Button) findViewById(R.id.button3);
=======
        Intent i = getIntent();
        person = (Person) i.getSerializableExtra("MyClass");


        txtShowInfo = (TextView) findViewById(R.id.showInfo);
        btnShow = (Button) findViewById(R.id.displayInfo);
>>>>>>> thirdLaboratoty





        rtRead = (RatingBar) findViewById(R.id.ratingBarRead);
        rtWTV = (RatingBar) findViewById(R.id.ratingWatchTV);
        rtDance = (RatingBar) findViewById(R.id.ratingBarDance);
        rtSing = (RatingBar) findViewById(R.id.ratingBarSing);
        rtSwimming = (RatingBar) findViewById(R.id.ratingBarSwimming);

        chRead = (CheckBox) findViewById(R.id.checkBoxRead);
        chWTV = (CheckBox) findViewById(R.id.checkBoxWatchTV);
        chDance = (CheckBox) findViewById(R.id.checkBoxDance);
        chSing = (CheckBox) findViewById(R.id.checkBoxSing);
        chSwimming = (CheckBox) findViewById(R.id.checkBoxSwimming);
<<<<<<< HEAD

        chRead.setOnClickListener(this);
        chWTV.setOnClickListener(this);
        chDance.setOnClickListener(this);
        chSing.setOnClickListener(this);
        chSwimming.setOnClickListener(this);

        btnShow.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){

                String text;
                text = "";
                if(chRead.isChecked()){
                    text = text + chRead.getText()+": " + rtRead.getRating() + " Estrellas \n";
                }
                if(chWTV.isChecked()){
                    text = text + chWTV.getText()+": " + rtWTV.getRating() + " Estrellas \n";
                }
                if(chDance.isChecked()){
                    text = text + chDance.getText()+": " + rtDance.getRating() + " Estrellas \n";
                }
                if(chSing.isChecked()){
                    text = text + chSing.getText()+": " + rtSing.getRating() + " Estrellas \n";
                }
                if(chSwimming.isChecked()){
                    text = text + chSwimming.getText()+": " + rtSwimming.getRating() + " Estrellas \n";
                }
                txtShowInfo.setText(text);
=======

        chRead.setOnClickListener(this);
        chWTV.setOnClickListener(this);
        chDance.setOnClickListener(this);
        chSing.setOnClickListener(this);
        chSwimming.setOnClickListener(this);

        btnShow.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){

                String text;
                text = "";
                if(chRead.isChecked()){
                    text = text + chRead.getText()+": " + rtRead.getRating() + " Estrellas \n";
                }
                if(chWTV.isChecked()){
                    text = text + chWTV.getText()+": " + rtWTV.getRating() + " Estrellas \n";
                }
                if(chDance.isChecked()){
                    text = text + chDance.getText()+": " + rtDance.getRating() + " Estrellas \n";
                }
                if(chSing.isChecked()){
                    text = text + chSing.getText()+": " + rtSing.getRating() + " Estrellas \n";
                }
                if(chSwimming.isChecked()){
                    text = text + chSwimming.getText()+": " + rtSwimming.getRating() + " Estrellas \n";
                }

                String datos = getIntent().getExtras().getString("datos");
                text = datos + text;
                txtShowInfo.setText(text);

                Intent intent = new Intent(OtherInfo.this, ShowInfo.class);

                intent.putExtra("MyClass", person);

                startActivity(intent);

>>>>>>> thirdLaboratoty
            }
        });


    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.checkBoxRead:
                if(chRead.isChecked()){
                    rtRead.setIsIndicator(false);
                }else {
                    rtRead.setIsIndicator(true);
                    rtRead.setRating(0);
                }
                break;
            case R.id.checkBoxWatchTV:
                if(chWTV.isChecked()){
                    rtWTV.setIsIndicator(false);
                }else {
                    rtWTV.setIsIndicator(true);
                    rtWTV.setRating(0);
                }
                break;
            case R.id.checkBoxDance:
                if(chDance.isChecked()){
                    rtDance.setIsIndicator(false);
                }else {
                    rtDance.setIsIndicator(true);
                    rtDance.setRating(0);
                }
                break;
            case R.id.checkBoxSing:
                if(chSing.isChecked()){
                    rtSing.setIsIndicator(false);
                }else {
                    rtSing.setIsIndicator(true);
                    rtSing.setRating(0);
                }
                break;
            case R.id.checkBoxSwimming:
                if(chSwimming.isChecked()){
                    rtSwimming.setIsIndicator(false);
                }else {
                    rtSwimming.setIsIndicator(true);
                    rtSwimming.setRating(0);
                }
                break;
        }

    }
}