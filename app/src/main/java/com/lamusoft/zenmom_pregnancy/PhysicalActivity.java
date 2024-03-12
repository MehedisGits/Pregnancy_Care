package com.lamusoft.zenmom_pregnancy;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

public class PhysicalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physical);
        getWindow().setStatusBarColor(ContextCompat.getColor(getApplicationContext(), R.color.white));

        // Set the heading text
        TextView toolHeading = findViewById(R.id.toolHeading);
        toolHeading.setText("Physical Health");

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
        Picasso.get().load(url)
                .resize(480, 360)
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.internet_error)
                .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                .networkPolicy(NetworkPolicy.NO_CACHE)
                .into(imageV);
    }
}
