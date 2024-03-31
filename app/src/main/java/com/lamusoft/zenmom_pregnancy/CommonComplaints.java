package com.lamusoft.zenmom_pregnancy;

import android.animation.LayoutTransition;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.bumptech.glide.Glide;

public class CommonComplaints extends AppCompatActivity {

    /**
     * @noinspection deprecation
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_complaints);
        getWindow().setStatusBarColor(ContextCompat.getColor(CommonComplaints.this, R.color.white));

        TextView seeMore, heading;
        seeMore = findViewById(R.id.seeMoreInCC);

        String h = "Show More";
        seeMore.setText(h);

        heading = findViewById(R.id.toolHeading);

        String h1 = "Common Discomforts";
        heading.setText(h1);
        LinearLayout layout = findViewById(R.id.layout);
        ImageView disc = findViewById(R.id.disclaimerBtn);
        disc.setOnClickListener(v -> PopUp.createPopUp(CommonComplaints.this, layout));

        ImageView back = findViewById(R.id.backBtn);
        back.setOnClickListener(v -> onBackPressed());

        String url = "https://github.com/RI-Mehedi/ZenMom-Image/blob/main/discomfort.jpg?raw=true";
        ImageView imageV = findViewById(R.id.imageV);
        Glide.with(CommonComplaints.this)
                .load(url)
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.internet_error)
                .into(imageV);

        ImageView dropdown = findViewById(R.id.dropDownCComplaints);
        LinearLayout moreInfo, infoLay;
        moreInfo = findViewById(R.id.moreSourceInCC);//Carry Gone Data

        infoLay = findViewById(R.id.dataSourceInCC); //Parent
        infoLay.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
        dropdown.setOnClickListener(v -> {
            int vb = (moreInfo.getVisibility() == View.GONE) ? View.VISIBLE : View.GONE;
            moreInfo.setVisibility(vb);
            if (vb == View.GONE) {

                String showMore = "Show More";
                seeMore.setText(showMore);
                dropdown.setImageResource(R.drawable.baseline_arrow_drop_down_24);
            }
            if (vb == View.VISIBLE) {

                String showLess = "Show Less";
                seeMore.setText(showLess);
                dropdown.setImageResource(R.drawable.baseline_arrow_drop_up_24);
            }
        });
    }
}
