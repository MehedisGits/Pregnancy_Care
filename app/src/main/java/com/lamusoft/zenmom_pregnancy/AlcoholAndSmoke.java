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

import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

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
        toolHeading.setText("Avoid drinks & smoke");

        ImageView disc = findViewById(R.id.disclaimerBtn);
        disc.setOnClickListener(v -> PopUp.createPopUp(AlcoholAndSmoke.this, findViewById(R.id.layout)));

        backBtnALco.isClickable();
        backBtnALco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        String url = "https://github.com/RI-Mehedi/ZenMom-Image/blob/main/alcohol%20and%20smoke.png?raw=true";
        ImageView imageV = findViewById(R.id.imageV);
        Picasso.get().load(url)
                .resize(720, 240)
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.internet_error)
                .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                .networkPolicy(NetworkPolicy.NO_CACHE)
                .into(imageV);

        //Expanding and Collapsing
        LinearLayout dataSourceInAlco, moreSourceInALco;
        dataSourceInAlco = findViewById(R.id.dataSourceInCC);
        dataSourceInAlco.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
        moreSourceInALco = findViewById(R.id.moreSourceInCC);
        CardView expandBtnAlco = findViewById(R.id.dropdownBtnAlco);
        ImageView dorpdownImageAlco = (ImageView) findViewById(R.id.dorpdownCComplaints);
        TextView seeMoreInAlcohol = findViewById(R.id.seeMoreInCC);
        seeMoreInAlcohol.setText("See More");
        expandBtnAlco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int visibility = (moreSourceInALco.getVisibility()==View.GONE)?View.VISIBLE: View.GONE;
                moreSourceInALco.setVisibility(visibility);
                if (visibility==View.GONE){
                    dorpdownImageAlco.setImageResource(R.drawable.baseline_arrow_drop_down_24);
                    seeMoreInAlcohol.setText("See More");
                }
                if (visibility==View.VISIBLE){
                    dorpdownImageAlco.setImageResource(R.drawable.baseline_arrow_drop_up_24);
                    seeMoreInAlcohol.setText("See Less");
                }
            }
        });


    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}