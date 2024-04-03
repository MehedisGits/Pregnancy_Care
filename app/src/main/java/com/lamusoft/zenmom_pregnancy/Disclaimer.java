package com.lamusoft.zenmom_pregnancy;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

/**
 * @noinspection deprecation
 */
public class Disclaimer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disclaimer);

        getWindow().setStatusBarColor(ContextCompat.getColor(Disclaimer.this, R.color.white));

        ImageView backBtn, discBtn;
        backBtn = findViewById(R.id.backBtn);
        backBtn.setOnClickListener(v -> onBackPressed());
        discBtn = findViewById(R.id.disclaimerBtn);
        discBtn.setVisibility(View.GONE);
    }
}