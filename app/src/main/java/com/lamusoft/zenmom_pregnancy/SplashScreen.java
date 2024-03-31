package com.lamusoft.zenmom_pregnancy;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.airbnb.lottie.LottieAnimationView;

@SuppressLint("CustomSplashScreen")
public class SplashScreen extends AppCompatActivity {

    private LinearLayout progressLayout;
    private ProgressBar progressBar;
    private int progress;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set the status bar color
        Window window = getWindow();
        window.setStatusBarColor(ContextCompat.getColor(SplashScreen.this, R.color.splash));
        // Make the activity fullscreen
        setContentView(R.layout.activity_splash_screen);

        LottieAnimationView lottieAnimationView = findViewById(R.id.splashLottie);
        lottieAnimationView.playAnimation();

        // Initialize views
        progressLayout = findViewById(R.id.progressLayout);

        new Thread(() -> {
            // Inflate the layout containing the ProgressBar
            LayoutInflater inflater = LayoutInflater.from(getApplicationContext());
            View view = inflater.inflate(R.layout.splash_progress_res, progressLayout, false);

            // Add the inflated layout to the progressLayout LinearLayout
            progressLayout.addView(view);

            // Find the ProgressBar within the inflated layout
            progressBar = view.findViewById(R.id.splashProgress);

            // Perform background work
            doWork();
            // Start the main activity regardless of the Android version
            startMainActivity();
        }).start();
    } //OnCreate Method END =================

    /**
     * @noinspection BusyWait
     */
    private void doWork() {
        for (progress = 20; progress <= 100; progress += 20) {
            try {
                // Simulate work being done
                Thread.sleep(200);
                // Update the progress bar on the UI thread
                runOnUiThread(() -> updateProgressBar(progress)); // Post updates to the UI thread
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void updateProgressBar(final int progress) {
        // Update progress on the UI thread
        runOnUiThread(() -> progressBar.setProgress(progress));
    }

    private void startMainActivity() {
        // Delay for a moment after the progress is complete
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            // Start the main activity
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            // Finish the splash screen activity
            finish();
        }, 0); // You can adjust the delay time as needed
    }
}
