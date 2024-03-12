package com.lamusoft.zenmom_pregnancy;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Window;
import android.widget.ProgressBar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.airbnb.lottie.LottieAnimationView;

public class SplashScreen extends AppCompatActivity {

    private LottieAnimationView lottiAnim;
    private ProgressBar progressBar2;
    private int progress;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set the status bar color
        Window window = getWindow();
        window.setStatusBarColor(ContextCompat.getColor(SplashScreen.this, R.color.splash));
        // Make the activity fullscreen
        setContentView(R.layout.activity_splash_screen);

        //Ad initialize
   /*     MobileAds.initialize(SplashScreen.this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });*/

        // Initialize views
        lottiAnim = findViewById(R.id.lottiAnim);
        progressBar2 = findViewById(R.id.progressBar2);

        // Start the Lottie animation
        lottiAnim.playAnimation();

        // Start a thread to perform background work
        new Thread(() -> {
            doWork();
            startMainActivity();
        }).start();
    }

    private void doWork() {
        for (progress = 20; progress <= 100; progress += 20) {
            try {
                // Simulate work being done
                Thread.sleep(500);
                // Update the progress bar on the UI thread
                updateProgressBar(progress);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void updateProgressBar(final int progress) {
        // Update progress on the UI thread
        runOnUiThread(() -> progressBar2.setProgress(progress));
    }

    private void startMainActivity() {
        // Delay for a moment after the progress is complete
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            // Start the main activity
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            // Finish the splash screen activity
            finish();
        }, 00); // You can adjust the delay time as needed
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
