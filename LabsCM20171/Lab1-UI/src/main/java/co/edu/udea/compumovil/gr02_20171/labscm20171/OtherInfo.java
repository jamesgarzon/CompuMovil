package co.edu.udea.compumovil.gr02_20171.labscm20171;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RatingBar;

public class OtherInfo extends AppCompatActivity {

    RatingBar ratingBar;
    String ratedValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_info);

        ratingBar = (RatingBar) findViewById(R.id.ratingBarRead);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating,
                                        boolean fromUser) {
                ratedValue = String.valueOf(ratingBar.getRating());
//                rateMessage.setText("You have rated the Product : "
//                        + ratedValue + "/5.");
            }
        });
    }
}
