package co.edu.udea.gr06_20171compumovil.lab3services;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.content.SharedPreferencesCompat;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import co.edu.udea.gr06_20171compumovil.lab3services.Pojos.User;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

import static android.Manifest.permission.READ_CONTACTS;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {

    public String url = "https://stormy-oasis-88226.herokuapp.com/api";
    public EditText mUsernameET;
    public EditText mPasswordET;
    public Button mLoginButton;
    public Button mSignupButton;
    public TextView mLoginInfoTV;
    public User[] users;
    public static final String USER_PREFERNCES = "UserPreferences";

    SharedPreferences settings;
    SharedPreferences.Editor prefEditor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mUsernameET = (EditText) findViewById(R.id.input_username);
        mPasswordET = (EditText) findViewById(R.id.input_password);
        mLoginInfoTV = (TextView) findViewById(R.id.login_info_text_view);
        mLoginButton = (Button) findViewById(R.id.btn_login);
        mSignupButton = (Button) findViewById(R.id.btn_signup);
        Intent intent;



        mLoginButton.setOnClickListener(new OnClickListener() {
            //making object of RestAdapter
            RestAdapter adapter = new RestAdapter.Builder().setEndpoint(url).build();

            //Creating Rest Services
            RestInterface restInterface = adapter.create(RestInterface.class);


            @Override
            public void onClick(View v) {

                try {
                    InputMethodManager imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                } catch (Exception e) {

                }
                //Calling method to get whether report
                restInterface.getUser(new Callback<User[]>() {

                    @Override
                    public void success(User[] usersResponse, Response response) {
                        Log.d("REST", "URL: "+ response.getUrl());
                        // Check if no view has focus:

                        users = usersResponse;
                        User user = checkUser(mUsernameET.getText().toString(), mPasswordET.getText().toString(), users);
                        if (user != null) {
                           Log.d("REST", "Success - Usuario: " + user.toString());
                            mLoginInfoTV.setText("Login successful");
                            saveUserPreferences(user);
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);

                        }else {
                            mLoginInfoTV.setText("Cannot authenticate with data provided, please try again");
                        }

                    }

                    @Override
                    public void failure(RetrofitError error) {
                        Log.d("REST", "Error: " + error.toString());
                    }
                });
            }
        });

        mSignupButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(getApplicationContext(), SignupActivity.class);
                startActivity(intent);
            }
        });
    }

    public User checkUser(String username, String password, User[] users){
        for (User user : users) {
            if (    user.getUsername().equals(username) && user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }

    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = activity.getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public void saveUserPreferences(User user){
        settings = getSharedPreferences(USER_PREFERNCES, MODE_PRIVATE);
        prefEditor = settings.edit();

        prefEditor.putString("username", user.getUsername());
        prefEditor.putString("email", user.getEmail());
        prefEditor.putString("id", user.getId());
        prefEditor.putString("picture", user.getPicture());
        prefEditor.putInt("age", user.getAge());
        prefEditor.commit();
    }

}


