package com.lamusoft.zenmom_pregnancy;

import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

/**
 * @noinspection deprecation, deprecation, deprecation
 */
public class MainActivity extends AppCompatActivity {

    private final BottomNavigationView.OnNavigationItemSelectedListener navListener = this::onNavigationItemSelected;
    private boolean backPressedOnce = false;

    //Start On Create Method >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this, R.color.white));

        BottomNavigationView bottomNav = findViewById(R.id.navigationBar);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        //Set Default Fragment
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new HomeFragment()).commit();

        //ToolBar Integration ================================
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    } // OnCreate Method END =========================


    private boolean onNavigationItemSelected(MenuItem menuItem) {
        Fragment selectedfragment = null;

        if (menuItem.getItemId() == R.id.navHome) {
            selectedfragment = new HomeFragment();
        } else if (menuItem.getItemId() == R.id.navDiet) {
            selectedfragment = new DietSection();
        } else if (menuItem.getItemId() == R.id.navTest) {
            selectedfragment = new Tests();
        } else if (menuItem.getItemId() == R.id.more) {
            selectedfragment = new More();
        }

        assert selectedfragment != null;
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedfragment).commit();
        return true;
    }

    @Override
    public void onBackPressed() {
        // Check if the main activity was started from the Onboarding activity
        boolean fromOnboarding = getIntent().getBooleanExtra("fromOnboarding", false);
        if (fromOnboarding) {
            // If it was started from Onboarding, exit the app directly
            finishAffinity(); // Finish all activities in the task
        } else {
            // If not, handle the back press event accordingly
            if (backPressedOnce) {
                // If back is pressed again within a short time, exit the app
                super.onBackPressed();
                finishAffinity(); // Finish all activities in the task
            } else {
                // Show a toast message indicating to press back again to exit
                Toast.makeText(getApplicationContext(), "Press back again to exit", Toast.LENGTH_SHORT).show();

                // Set backPressedOnce to true to track the first back press
                backPressedOnce = true;

                // Reset backPressedOnce after a certain delay (e.g., 2 seconds)
                new Handler().postDelayed(() -> backPressedOnce = false, 2000);
            }
        }
    }



}
//Menu Integration End===========================================

