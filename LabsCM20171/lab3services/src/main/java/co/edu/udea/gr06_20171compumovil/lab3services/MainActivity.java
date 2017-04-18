package co.edu.udea.gr06_20171compumovil.lab3services;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import co.edu.udea.gr06_20171compumovil.lab3services.Pojos.Event;
import co.edu.udea.gr06_20171compumovil.lab3services.Pojos.User;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, eventsFragment.OnListFragmentInteractionListener, ProfileFragment.OnFragmentInteractionListener{

    public static final String USER_PREFERNCES = "UserPreferences";
    User user;

    TextView mUsernameHeaderTV;
    TextView mEmailHeaderTV;
    ImageView mPictureHeaderImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);


        NavigationView mnavigationView = (NavigationView) findViewById(R.id.nav_view);
        View hView =  mnavigationView.getHeaderView(0);

        mUsernameHeaderTV = (TextView) hView.findViewById(R.id.username_header);
        mEmailHeaderTV = (TextView) hView.findViewById(R.id.email_header);
        mPictureHeaderImage = (ImageView) hView.findViewById(R.id.profile_image_header);

        SharedPreferences UserPreferences = getSharedPreferences(USER_PREFERNCES, MODE_PRIVATE);
//        UserPreferences.edit().clear().commit();

        user = new User();
        user.setUsername(UserPreferences.getString("username", null));
        user.setEmail(UserPreferences.getString("email", null));
        user.setId(UserPreferences.getString("id", null));
        user.setAge(UserPreferences.getInt("age", 0));
        user.setPicture(UserPreferences.getString("picture", null));

        Log.d("REST SERVICE WORK", "username: "+ user.getUsername());

        mUsernameHeaderTV.setText(user.getUsername());
        mEmailHeaderTV.setText(user.getEmail());
        Picasso.with(getApplicationContext()).load(user.getPicture()).resize(170, 170).into(mPictureHeaderImage);


//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//
//            }
//        });


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);

        return true;
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Fragment fragment = null;
        Boolean selectedFragment = false;


        if (id == R.id.nav_profile) {
            fragment = new ProfileFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.main_container, fragment).commit();

            // Handle the camera action
        } else if (id == R.id.nav_events) {
            fragment = new eventsFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.main_container, fragment).commit();

        } else if (id == R.id.nav_logout){
            SharedPreferences UserPreferences = getSharedPreferences(USER_PREFERNCES, MODE_PRIVATE);
            UserPreferences.edit().clear().commit();
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);
            finish();
        } else if (id == R.id.nav_update_events){

        }



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onListFragmentInteraction(Event item) {

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
