package com.lamusoft.zenmom_pregnancy;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

/**
 * @noinspection ALL
 */
public class FetalDevelopmentChart extends FragmentActivity {
    private int weekNumber;
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

        // Retrieve weekNumber from Intent
        weekNumber = getIntent().getIntExtra("weekNumber", 0);

        // Set the default tab index based on weekNumber
        int defaultTabIndex = getDefaultTabIndex();
        pager.setCurrentItem(defaultTabIndex, true); // Set the default tab index

        ImageView disc = findViewById(R.id.disclaimerBtn);
        disc.setImageResource(R.drawable.baseline_share_24);
        disc.setOnClickListener(v -> ShareIntent.shareApp(FetalDevelopmentChart.this));
        disc.isClickable();
    }

    private void initializeViews() {
        back = findViewById(R.id.backBtn);
        heading = findViewById(R.id.toolHeading);
        tabLayout = findViewById(R.id.tabLayoutFetal);
        pager = findViewById(R.id.pagerId);
    }

    private void setupBackButton() {
        back.setOnClickListener(v -> onBackPressed());
    }

    private void setupHeading() {
        String headingTxt = "Fetal Development";
        heading.setText(headingTxt);
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

    private int getDefaultTabIndex() {
        int defaultTabIndex = 0;
        if (weekNumber > 8 && weekNumber <= 12) {
            defaultTabIndex = 1;
        } else if (weekNumber > 12 && weekNumber <= 16) {
            defaultTabIndex = 2;
        } else if (weekNumber > 16 && weekNumber <= 20) {
            defaultTabIndex = 3;
        } else if (weekNumber > 20 && weekNumber <= 24) {
            defaultTabIndex = 4;
        } else if (weekNumber > 24 && weekNumber <= 28) {
            defaultTabIndex = 5;
        } else if (weekNumber > 28 && weekNumber <= 32) {
            defaultTabIndex = 6;
        } else if (weekNumber > 32 && weekNumber <= 36) {
            defaultTabIndex = 7;
        } else if (weekNumber > 36 && weekNumber <= 40) {
            defaultTabIndex = 8;
        }
        return defaultTabIndex;
    }

    private void addTabs(TabLayout tabLayout) {
        for (int i = 0; i < 9; i++) {
            tabLayout.addTab(tabLayout.newTab());
        }
    }
}
