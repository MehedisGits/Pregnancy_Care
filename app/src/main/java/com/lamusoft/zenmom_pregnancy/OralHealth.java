package com.lamusoft.zenmom_pregnancy;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.bumptech.glide.Glide;


public class OralHealth extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oral_health);
        getWindow().setStatusBarColor(ContextCompat.getColor(getApplicationContext(), R.color.white));

        // Toolbar setup
        ImageView backBTN = findViewById(R.id.backBtn);
        TextView toolHeading = findViewById(R.id.toolHeading);
        String hTxt = "Oral Health";
        toolHeading.setText(hTxt);
        backBTN.setOnClickListener(new View.OnClickListener() {
            /**
             * @noinspection deprecation
             */
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        // Disclaimer setup
        LinearLayout layout = findViewById(R.id.layout);
        ImageView disc = findViewById(R.id.disclaimerBtn);
        disc.setOnClickListener(v -> PopUp.createPopUp(getApplicationContext(), layout));
        disc.isClickable();

        // Load image with Picasso
        String url = "https://raw.githubusercontent.com/rakibul-islam-mehedi/ZenMom-Image/main/oral_health.jpg";
        ImageView imageV = findViewById(R.id.imageV);
        Glide.with(OralHealth.this)
                .load(url)
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.internet_error)
                .into(imageV);

        // Expanding and Collapsing section
        LinearLayout moreSourceInOral = findViewById(R.id.moreSourceInCC);
        ImageView dropDownImageOral = findViewById(R.id.dropDownCComplaints);
        TextView seeMoreInOral = findViewById(R.id.seeMoreInCC);
        seeMoreInOral.setText(R.string.see_more);

        // Toggle visibility on click
        dropDownImageOral.setOnClickListener(v -> {
            int vbt = (moreSourceInOral.getVisibility() == View.GONE) ? View.VISIBLE : View.GONE;
            moreSourceInOral.setVisibility(vbt);

            // Update text and icon based on visibility
            if (vbt == View.GONE) {
                seeMoreInOral.setText(R.string.see_more);
                dropDownImageOral.setImageResource(R.drawable.baseline_arrow_drop_down_24);
            }
            if (vbt == View.VISIBLE) {
                seeMoreInOral.setText(R.string.see_less);
                dropDownImageOral.setImageResource(R.drawable.baseline_arrow_drop_up_24);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
