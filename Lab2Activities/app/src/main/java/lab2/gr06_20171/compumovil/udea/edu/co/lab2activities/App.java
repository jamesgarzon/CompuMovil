package lab2.gr06_20171.compumovil.udea.edu.co.lab2activities;

import android.app.Application;
import android.os.SystemClock;

import java.util.concurrent.TimeUnit;

/**
 * Created by james on 3/4/17.
 */



public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // Don't do this! This is just so cold launches take some time
        SystemClock.sleep(TimeUnit.SECONDS.toMillis(3));
    }
}


