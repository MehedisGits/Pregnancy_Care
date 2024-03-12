package com.lamusoft.zenmom_pregnancy;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class AboutUs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        getWindow().setStatusBarColor(ContextCompat.getColor(AboutUs.this, R.color.white));

        ImageView backBtn, disc;
        backBtn = findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        disc = findViewById(R.id.disclaimerBtn);
        disc.setVisibility(View.GONE);
        TextView heading = findViewById(R.id.toolHeading);
        heading.setText(R.string.about);

    }
}