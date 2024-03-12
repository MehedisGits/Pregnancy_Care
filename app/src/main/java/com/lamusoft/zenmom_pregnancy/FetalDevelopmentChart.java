package com.lamusoft.zenmom_pregnancy;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class FetalDevelopmentChart extends FragmentActivity {

    private ViewPager pager;
    private TabLayout tabLayout;
    private ImageView back;
    private TextView heading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fetal_development_chart);
        getWindow().setStatusBarColor(ContextCompat.getColor(FetalDevelopmentChart.this, R.color.white));

        initializeViews();
        setupBackButton();
        setupHeading();
        setupTabLayout();
        setupViewPager();

        ImageView disc = findViewById(R.id.disclaimerBtn);
        disc.setImageResource(R.drawable.baseline_share_24);
        disc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShareIntent.shareApp(FetalDevelopmentChart.this);
            }
        });
        disc.isClickable();
    }

    private void initializeViews() {
        back = findViewById(R.id.backBtn);
        heading = findViewById(R.id.toolHeading);
        tabLayout = findViewById(R.id.tabLayoutFetal);
        pager = findViewById(R.id.pagerId);
    }

    private void setupBackButton() {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void setupHeading() {
        heading.setText("Fetal Development");
    }

    private void setupTabLayout() {
        tabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);
        addTabs(tabLayout);
    }

    private void setupViewPager() {
        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        pager.setAdapter(adapter);
        tabLayout.setupWithViewPager(pager, true);
        tabLayout.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager.setCurrentItem(tab.getPosition(), true);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                // Not needed for now
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                // Not needed for now
            }
        });
    }

    private void addTabs(TabLayout tabLayout) {
        for (int i = 0; i < 9; i++) {
            tabLayout.addTab(tabLayout.newTab());
        }
    }
}
