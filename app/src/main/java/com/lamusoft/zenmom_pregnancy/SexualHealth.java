package com.lamusoft.zenmom_pregnancy;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.bumptech.glide.Glide;


public class SexualHealth extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sexual_health);

        // Set the status bar color
        getWindow().setStatusBarColor(ContextCompat.getColor(getApplicationContext(), R.color.white));

        // Set the heading text
        TextView heading = findViewById(R.id.toolHeading);
        String hTxt = "Sexual Health";
        heading.setText(hTxt);

        // Set up the back button
        ImageView back = findViewById(R.id.backBtn);
        back.setOnClickListener(new View.OnClickListener() {
            /**
             * @noinspection deprecation
             */
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        // Set up the disclaimer button
        ImageView disc = findViewById(R.id.disclaimerBtn);
        disc.setOnClickListener(v -> PopUp.createPopUp(getApplicationContext(), findViewById(R.id.layout)));

        // Load the image using Picasso
        String url = "https://github.com/RI-Mehedi/ZenMom-Image/blob/main/sexual_health.jpg?raw=true";

        ImageView imageV = findViewById(R.id.imageV);
        if (imageV != null) {
            Glide.with(this)
                    .load(url)
                    .placeholder(R.drawable.placeholder)
                    .error(R.drawable.internet_error)
                    .into(imageV);
    }

    }
}
