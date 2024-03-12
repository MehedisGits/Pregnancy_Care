package com.lamusoft.zenmom_pregnancy;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

public class MainActivity extends AppCompatActivity {

    private LinearLayout BMI, guideSection, babySizeSection, babyGrowthSection, partnerSupport, diet, pregnancySign, testKitGuide, urineTestSection, homemadeTestSection ;
    private LottieAnimationView lottieMore;

    private AdView bannerHome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this, R.color.white));

//        bannerHome = findViewById(R.id.bannerHome);


        //Ads for next Update
        /*loadBanner();*/

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initializeViews();
        setClickListeners();

    }
    private AdSize getAdSize() {
        // Determine the screen width (less decorations) to use for the ad width.
        Display display = getWindowManager().getDefaultDisplay();
        DisplayMetrics outMetrics = new DisplayMetrics();
        display.getMetrics(outMetrics);

        float density = outMetrics.density;

        float adWidthPixels = bannerHome.getWidth();

        // If the ad hasn't been laid out, default to the full screen width.
        if (adWidthPixels == 0) {
            adWidthPixels = outMetrics.widthPixels;
        }

        int adWidth = (int) (adWidthPixels / density);
        return AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(MainActivity.this, adWidth);
    }

    private void loadBanner() {

        // Create a new ad view.
        AdView adView = new AdView(MainActivity.this);
        adView.setAdSize(getAdSize());
        adView.setAdUnitId("ca-app-pub-3940256099942544/9214589741");

        // Replace ad container with new ad view.
        bannerHome.removeAllViews();
        bannerHome.addView(adView);

        // Start loading the ad in the background.
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
    }

    private void initializeViews() {
        lottieMore = findViewById(R.id.lottieMore);
        lottieMore.playAnimation();

        pregnancySign = findViewById(R.id.pregnancySign);
        testKitGuide = findViewById(R.id.testKitGuide);
        diet = findViewById(R.id.diet);
        babySizeSection = findViewById(R.id.babySizeSection);
        urineTestSection = findViewById(R.id.urineTestSection);
        partnerSupport = findViewById(R.id.partnerSupport);
        guideSection = findViewById(R.id.guideSection);
        babyGrowthSection = findViewById(R.id.babyGrowthSection);
        homemadeTestSection = findViewById(R.id.homemadeTestSection);
        BMI = findViewById(R.id.bmiCalculator);
    }

    private void setClickListeners() {
        homemadeTestSection.setOnClickListener(v -> startNewActivity(HomemadeTest.class));
        pregnancySign.setOnClickListener(v -> startNewActivity(PregnancySigns.class));
        testKitGuide.setOnClickListener(v -> startNewActivity(TestingGuide.class));
        diet.setOnClickListener(v -> startNewActivity(NutritionPlan.class));
        babySizeSection.setOnClickListener(v -> startNewActivity(BabySizeMilestone.class));
        guideSection.setOnClickListener(v -> startNewActivity(ComprehensiveGuideActivity.class));
        babyGrowthSection.setOnClickListener(v -> startNewActivity(FetalDevelopmentChart.class));
        partnerSupport.setOnClickListener(v -> startNewActivity(PartnerSupport.class));
        urineTestSection.setOnClickListener(v -> startNewActivity(UrineTestGuide.class));
        BMI.setOnClickListener(v -> startNewActivity( BMI.class));
    }
    private void startNewActivity( Class<?> activityClass) {
        startActivity(new Intent(MainActivity.this, activityClass));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

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
}
