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

public class PartnerSupport extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partner_support);
        getWindow().setStatusBarColor(ContextCompat.getColor(getApplicationContext(), R.color.white));

        TextView heading = findViewById(R.id.toolHeading);
        heading.setText("Partner support");
        ImageView back = findViewById(R.id.backBtn);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        ImageView share = findViewById(R.id.disclaimerBtn);
        share.setImageResource(R.drawable.baseline_share_24);
        share.setOnClickListener(v -> ShareIntent.shareApp(getApplicationContext()));

        ImageView imageV = findViewById(R.id.img);

        String url = "https://github.com/RI-Mehedi/ZenMom-Image/blob/main/partner%20support.jpg?raw=true";
        Picasso.get().load(url)
                .resize(480, 360)
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.internet_error)
                .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                .networkPolicy(NetworkPolicy.NO_CACHE)
                .into(imageV);
    }
}