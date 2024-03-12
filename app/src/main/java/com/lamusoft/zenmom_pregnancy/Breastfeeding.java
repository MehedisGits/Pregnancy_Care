package com.lamusoft.zenmom_pregnancy;

import android.animation.LayoutTransition;
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

public class Breastfeeding extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breastfeeding);
        getWindow().setStatusBarColor(ContextCompat.getColor(Breastfeeding.this, R.color.white));

        TextView seeMore = findViewById(R.id.seeMoreInCC);
        seeMore.setText("Show More");

        TextView heading = findViewById(R.id.toolHeading);
        heading.setText("BreastFeeding");

        LinearLayout layout = findViewById(R.id.layout);
        ImageView disc = findViewById(R.id.disclaimerBtn);
        disc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopUp.createPopUp(Breastfeeding.this, layout);
            }
        });
        disc.isClickable();

        ImageView back = findViewById(R.id.backBtn);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        String url = "https://github.com/RI-Mehedi/ZenMom-Image/blob/main/breastfeeding.jpg?raw=true";
        ImageView imageV = findViewById(R.id.imageV);
        Picasso.get().load(url)
                .resize(720, 480)
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.internet_error)
                .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                .networkPolicy(NetworkPolicy.NO_CACHE)
                .into(imageV);

        LinearLayout moreSourceInBreast = findViewById(R.id.moreSourceInCC);
        LinearLayout dataSourceInBreast = findViewById(R.id.dataSourceInCC);
        dataSourceInBreast.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
        ImageView dorpdownImageBreast = findViewById(R.id.dorpdownCComplaints);
        dorpdownImageBreast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int vs = (moreSourceInBreast.getVisibility() == View.GONE)? View.VISIBLE: View.GONE;
                moreSourceInBreast.setVisibility(vs);
                if (vs== View.GONE){
                    seeMore.setText("Show More");
                    dorpdownImageBreast.setImageResource(R.drawable.baseline_arrow_drop_down_24);
                }if (vs== View.VISIBLE){
                    seeMore.setText("Show Less");
                    dorpdownImageBreast.setImageResource(R.drawable.baseline_arrow_drop_up_24);
                }
            }
        });

    }
}