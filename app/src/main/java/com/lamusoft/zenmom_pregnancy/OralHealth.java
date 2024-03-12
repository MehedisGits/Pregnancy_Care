package com.lamusoft.zenmom_pregnancy;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

public class OralHealth extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oral_health);
        getWindow().setStatusBarColor(ContextCompat.getColor(getApplicationContext(), R.color.white));

        // Toolbar setup
        ImageView backBTN = findViewById(R.id.backBtn);
        TextView toolHeading = findViewById(R.id.toolHeading);
        toolHeading.setText("Oral Health");
        backBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        // Disclaimer setup
        LinearLayout layout = findViewById(R.id.layout);
        ImageView disc = findViewById(R.id.disclaimerBtn);
        disc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopUp.createPopUp(getApplicationContext(), layout);
            }
        });
        disc.isClickable();

        // Load image with Picasso
        String url = "https://github.com/RI-Mehedi/ZenMom-Image/blob/main/oral_health.jpg?raw=true";
        ImageView imageV = findViewById(R.id.imageV);
        Picasso.get().load(url)
                .resize(480, 360)
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.internet_error)
                .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                .networkPolicy(NetworkPolicy.NO_CACHE)
                .into(imageV);

        // Expanding and Collapsing section
        LinearLayout moreSourceInOral = findViewById(R.id.moreSourceInCC);
        LinearLayout dataSourceInAlco = findViewById(R.id.dataSourceInCC);
        ImageView dorpdownImageOral = findViewById(R.id.dorpdownCComplaints);
        TextView seeMoreInOral = findViewById(R.id.seeMoreInCC);
        seeMoreInOral.setText("See More");

        // Toggle visibility on click
        dorpdownImageOral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int vbt = (moreSourceInOral.getVisibility() == View.GONE) ? View.VISIBLE : View.GONE;
                moreSourceInOral.setVisibility(vbt);

                // Update text and icon based on visibility
                if (vbt == View.GONE) {
                    seeMoreInOral.setText("See More");
                    dorpdownImageOral.setImageResource(R.drawable.baseline_arrow_drop_down_24);
                }
                if (vbt == View.VISIBLE) {
                    seeMoreInOral.setText("See Less");
                    dorpdownImageOral.setImageResource(R.drawable.baseline_arrow_drop_up_24);
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
