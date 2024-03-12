package com.lamusoft.zenmom_pregnancy;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class TestingGuide extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testing_guide);
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.white));

        TextView heading = findViewById(R.id.toolHeading);
        heading.setText("Test Kit Guide");

        ImageView backBtn = findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        LinearLayout layout = findViewById(R.id.layout);

        ImageView disc;
        disc = findViewById(R.id.disclaimerBtn);
        disc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopUp.createPopUp(getApplicationContext(), layout);
            }
        });
    }
}