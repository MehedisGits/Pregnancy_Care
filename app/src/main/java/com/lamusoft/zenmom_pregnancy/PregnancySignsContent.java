package com.lamusoft.zenmom_pregnancy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class PregnancySignsContent extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signs_content);

        // Set the status bar color
        getWindow().setStatusBarColor(ContextCompat.getColor(getApplicationContext(), R.color.white));

        // Get data from the intent
        Intent intent = getIntent();
        if (intent != null) {
            String title = intent.getStringExtra("title");
            String body = intent.getStringExtra("body");
            String tH = intent.getStringExtra("heading");

            // Initialize views
            TextView heading = findViewById(R.id.toolHeading);
            heading.setText(tH);

            TextView cHeading = findViewById(R.id.signsTitle);
            cHeading.setText(title);

            TextView content = findViewById(R.id.signsText);
            content.setText(body);
        }

        // Set up back button
        ImageView backBtn = findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            /**
             * @noinspection deprecation
             */
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        // Set up share button
        ImageView share = findViewById(R.id.disclaimerBtn);
        share.setImageResource(R.drawable.baseline_share_24);
        share.setOnClickListener(v -> ShareIntent.shareApp(PregnancySignsContent.this));
    }

}
