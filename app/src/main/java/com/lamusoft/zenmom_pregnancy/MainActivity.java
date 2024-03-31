package com.lamusoft.zenmom_pregnancy;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
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

    //Menu Integration Start=========================================
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    //3 Dot Menu Option
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.about) {
            startActivity(new Intent(MainActivity.this, AboutUs.class));
        } else if (id == R.id.privacy) {
            startActivity(new Intent(MainActivity.this, PrivacyPolicy.class));
        } else if (id == R.id.share) {
            ShareIntent.shareApp(MainActivity.this);
        } else if (id == R.id.rating) {
            try {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.lamusoft.zenmom_pregnancy")));
            } catch (ActivityNotFoundException e) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.lamusoft.zenmom_pregnancy")));
            }
        } else if (id == R.id.terms) {
            startActivity(new Intent(MainActivity.this, TermsAndConditions.class));
        }
        return true;
    }

    private boolean onNavigationItemSelected(MenuItem menuItem) {
        Fragment selectedfragment = null;

        if (menuItem.getItemId() == R.id.navHome) {
            selectedfragment = new HomeFragment();
        } else if (menuItem.getItemId() == R.id.navDiet) {
            selectedfragment = new DietSection();
        } else if (menuItem.getItemId() == R.id.navTest) {
            selectedfragment = new Tests();
        }

        assert selectedfragment != null;
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedfragment).commit();
        return true;
    }
}
//Menu Integration End===========================================

