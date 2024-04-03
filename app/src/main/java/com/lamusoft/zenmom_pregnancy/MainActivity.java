package com.lamusoft.zenmom_pregnancy;

import android.os.Bundle;
import android.view.MenuItem;

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
}
//Menu Integration End===========================================

