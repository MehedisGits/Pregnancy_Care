package com.lamusoft.zenmom_pregnancy;

import android.animation.LayoutTransition;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import com.bumptech.glide.Glide;


public class AlcoholAndSmoke extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alcohol_and_smoke);
        getWindow().setStatusBarColor(ContextCompat.getColor(AlcoholAndSmoke.this, R.color.white));

        //Toolbar
        ImageView backBtnALco;
        backBtnALco = findViewById(R.id.backBtn);
        TextView toolHeading = findViewById(R.id.toolHeading);

        String heading = "Avoid drinks & smoke";
        toolHeading.setText(heading);

        ImageView disc = findViewById(R.id.disclaimerBtn);
        disc.setOnClickListener(v -> PopUp.createPopUp(AlcoholAndSmoke.this, findViewById(R.id.layout)));

        backBtnALco.isClickable();
        backBtnALco.setOnClickListener(new View.OnClickListener() {
            /**
             * @noinspection deprecation
             */
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        String url = "https://github.com/RI-Mehedi/ZenMom-Image/blob/main/alcohol%20and%20smoke.png?raw=true";
        ImageView imageV = findViewById(R.id.imageV);
        Glide.with(AlcoholAndSmoke.this)
                .load(url)
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.internet_error)
                .into(imageV);

        //Expanding and Collapsing
        LinearLayout dataSourceInAlco, moreSourceInALco;
        dataSourceInAlco = findViewById(R.id.dataSourceInCC);
        dataSourceInAlco.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
        moreSourceInALco = findViewById(R.id.moreSourceInCC);
        CardView expandBtnAlco = findViewById(R.id.dropdownBtnAlco);
        ImageView dropDownImageV = findViewById(R.id.dropDownCComplaints);
        TextView seeMoreInAlcohol = findViewById(R.id.seeMoreInCC);

        seeMoreInAlcohol.setText(R.string.see_more);
        expandBtnAlco.setOnClickListener(v -> {
            int visibility = (moreSourceInALco.getVisibility() == View.GONE) ? View.VISIBLE : View.GONE;
            moreSourceInALco.setVisibility(visibility);
            if (visibility == View.GONE) {
                dropDownImageV.setImageResource(R.drawable.baseline_arrow_drop_down_24);
                seeMoreInAlcohol.setText(R.string.see_more);
            }
            if (visibility == View.VISIBLE) {
                dropDownImageV.setImageResource(R.drawable.baseline_arrow_drop_up_24);
                seeMoreInAlcohol.setText(R.string.see_less);
            }
        });


    }

}