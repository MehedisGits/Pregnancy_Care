package com.lamusoft.zenmom_pregnancy;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.bumptech.glide.Glide;


public class PhysicalActivity extends AppCompatActivity {

    /**
     * @noinspection deprecation
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physical);
        getWindow().setStatusBarColor(ContextCompat.getColor(getApplicationContext(), R.color.white));

        // Set the heading text
        TextView toolHeading = findViewById(R.id.toolHeading);
        String hTxt = "Physical Health";
        toolHeading.setText(hTxt);

        // Set up the back button
        ImageView back = findViewById(R.id.backBtn);
        back.setOnClickListener(v -> onBackPressed());

        // Set up the disclaimer button and associated layout
        LinearLayout layout = findViewById(R.id.layout);
        ImageView disc = findViewById(R.id.disclaimerBtn);
        disc.setOnClickListener(v -> PopUp.createPopUp(getApplicationContext(), layout));

        // Load and display the image using Picasso
        String url = "https://github.com/RI-Mehedi/ZenMom-Image/blob/main/physical_activity.jpg?raw=true";
        ImageView imageV = findViewById(R.id.imageV);
        Glide.with(PhysicalActivity.this)
                .load(url)
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.internet_error)
                .into(imageV);
    }
}
