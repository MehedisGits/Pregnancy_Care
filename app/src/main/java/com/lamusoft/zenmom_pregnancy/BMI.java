package com.lamusoft.zenmom_pregnancy;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.airbnb.lottie.LottieAnimationView;

public class BMI extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        getWindow().setStatusBarColor(ContextCompat.getColor(BMI.this, R.color.white));

        LottieAnimationView lottieAnimationView = findViewById(R.id.lottie);
        lottieAnimationView.setRepeatCount(5);
        lottieAnimationView.playAnimation();

        ImageView backBtn, discBtn;
        backBtn =findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        discBtn =findViewById(R.id.disclaimerBtn);
        discBtn.setVisibility(View.GONE);
        TextView heading = findViewById(R.id.toolHeading);
        heading.setText("BMI Calculator");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}