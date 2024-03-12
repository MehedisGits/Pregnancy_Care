package com.lamusoft.zenmom_pregnancy;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

public class SexualHealth extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sexual_health);

        // Set the status bar color
        getWindow().setStatusBarColor(ContextCompat.getColor(getApplicationContext(), R.color.white));

        // Set the heading text
        TextView heading = findViewById(R.id.toolHeading);
        heading.setText("Sexual Health");

        // Set up the back button
        ImageView back = findViewById(R.id.backBtn);
        back.setOnClickListener(new View.OnClickListener() {
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
        Picasso.get().load(url)
                .resize(480, 360)
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.internet_error)
                .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                .networkPolicy(NetworkPolicy.NO_CACHE)
                .into(imageV);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
