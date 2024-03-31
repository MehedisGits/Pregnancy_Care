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


public class Breastfeeding extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breastfeeding);
        getWindow().setStatusBarColor(ContextCompat.getColor(Breastfeeding.this, R.color.white));

        TextView seeMore = findViewById(R.id.seeMoreInCC);
        seeMore.setText(R.string.see_more);

        TextView heading = findViewById(R.id.toolHeading);
        String hTxt = "BreastFeeding";
        heading.setText(hTxt);

        LinearLayout layout = findViewById(R.id.layout);
        ImageView disc = findViewById(R.id.disclaimerBtn);
        disc.setOnClickListener(v -> PopUp.createPopUp(Breastfeeding.this, layout));
        disc.isClickable();

        ImageView back = findViewById(R.id.backBtn);
        back.setOnClickListener(new View.OnClickListener() {
            /**
             * @noinspection deprecation
             */
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        String url = "https://github.com/RI-Mehedi/ZenMom-Image/blob/main/breastfeeding.jpg?raw=true";
        ImageView imageV = findViewById(R.id.imageV);
        Glide.with(Breastfeeding.this)
                .load(url)
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.internet_error)
                .into(imageV);

        LinearLayout moreSourceInBreast = findViewById(R.id.moreSourceInCC);
        LinearLayout dataSourceInBreast = findViewById(R.id.dataSourceInCC);
        dataSourceInBreast.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
        ImageView dropDownImageBreast = findViewById(R.id.dropDownCComplaints);
        dropDownImageBreast.setOnClickListener(v -> {
            int vs = (moreSourceInBreast.getVisibility() == View.GONE) ? View.VISIBLE : View.GONE;
            moreSourceInBreast.setVisibility(vs);
            if (vs == View.GONE) {
                seeMore.setText(R.string.see_more);
                dropDownImageBreast.setImageResource(R.drawable.baseline_arrow_drop_down_24);
            }
            if (vs == View.VISIBLE) {
                seeMore.setText(R.string.see_less);
                dropDownImageBreast.setImageResource(R.drawable.baseline_arrow_drop_up_24);
            }
        });

    }
}