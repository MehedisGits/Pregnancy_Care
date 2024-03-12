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

public class MentalHealth extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mental_health);
        getWindow().setStatusBarColor(ContextCompat.getColor(getApplicationContext(), R.color.white));

        TextView heading = findViewById(R.id.toolHeading);
        heading.setText("Mental Health");

        LinearLayout layout = findViewById(R.id.layout);
        ImageView disc = findViewById(R.id.disclaimerBtn);

        disc.setOnClickListener(v -> PopUp.createPopUp(getApplicationContext(), layout));
        disc.isClickable();

        // Use resource identifiers for placeholder and error images
        int placeholderResourceId = R.drawable.placeholder;
        int errorResourceId = R.drawable.internet_error;

        String imageUrl = "https://github.com/RI-Mehedi/ZenMom-Image/blob/main/mental_health.jpg?raw=true"; // Replace with your actual image URL

        // Load the image asynchronously using Picasso
        Picasso.get().load(imageUrl)
                .resize(480, 360)
                .placeholder(placeholderResourceId)
                .error(errorResourceId)
                .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                .networkPolicy(NetworkPolicy.NO_CACHE)
                .into((ImageView) findViewById(R.id.imageV));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
