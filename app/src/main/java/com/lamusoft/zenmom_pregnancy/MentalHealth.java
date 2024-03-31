package com.lamusoft.zenmom_pregnancy;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.bumptech.glide.Glide;

public class MentalHealth extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mental_health);
        getWindow().setStatusBarColor(ContextCompat.getColor(getApplicationContext(), R.color.white));

        TextView heading = findViewById(R.id.toolHeading);
        String hTxt = "Mental Health";
        heading.setText(hTxt);

        LinearLayout layout = findViewById(R.id.layout);
        ImageView disc = findViewById(R.id.disclaimerBtn);

        disc.setOnClickListener(v -> PopUp.createPopUp(getApplicationContext(), layout));
        disc.isClickable();


        String url = "https://github.com/RI-Mehedi/ZenMom-Image/blob/main/mental_health.jpg?raw=true"; // Replace with your actual image URL

        Glide.with(this)
                .load(url)
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.internet_error)
                .into((ImageView) findViewById(R.id.imageV));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
