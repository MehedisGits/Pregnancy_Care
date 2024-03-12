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

public class CommonComplaints extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_complaints);
        getWindow().setStatusBarColor(ContextCompat.getColor(CommonComplaints.this, R.color.white));

        TextView seeMore, heading;
        seeMore = findViewById(R.id.seeMoreInCC);
        seeMore.setText("Show More");

        heading = findViewById(R.id.toolHeading);
        heading.setText("Common Pregnancy Discomforts");
        LinearLayout layout = findViewById(R.id.layout);
        ImageView disc = findViewById(R.id.disclaimerBtn);
        disc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopUp.createPopUp(CommonComplaints.this, layout);
            }
        });

        ImageView back = findViewById(R.id.backBtn);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        String url = "https://github.com/RI-Mehedi/ZenMom-Image/blob/main/discomfort.jpg?raw=true";
        ImageView imageV = findViewById(R.id.imageV);
        Picasso.get().load(url)
                .resize(480, 360)
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.internet_error)
                .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                .networkPolicy(NetworkPolicy.NO_CACHE)
                .into(imageV);

        ImageView dropdown = findViewById(R.id.dorpdownCComplaints);
        LinearLayout moreInfo, infoLay;
        moreInfo = findViewById(R.id.moreSourceInCC);//Carry Gone Data

        infoLay = findViewById(R.id.dataSourceInCC); //Parent
        infoLay.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
        dropdown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int vb = (moreInfo.getVisibility() == View.GONE) ? View.VISIBLE : View.GONE;
                moreInfo.setVisibility(vb);
                if (vb == View.GONE) {
                    seeMore.setText("Show More");
                    dropdown.setImageResource(R.drawable.baseline_arrow_drop_down_24);
                }
                if (vb == View.VISIBLE) {
                    seeMore.setText("Show Less");
                    dropdown.setImageResource(R.drawable.baseline_arrow_drop_up_24);
                }
            }
        });
    }
}
