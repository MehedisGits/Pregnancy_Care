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

import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

public class FolicAcid extends AppCompatActivity {

    private TextView seeMoreInFA;
    private ImageView dorpdownImage;
    private  CardView dropdownButton;
    private LinearLayout moreSource, dataSourceInFolic;
    private InterstitialAd interstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_folic_acid);
        getWindow().setStatusBarColor(ContextCompat.getColor(FolicAcid.this, R.color.white));

        //Toolbar
        ImageView backBTN, disc;
        backBTN = findViewById(R.id.backBtn);
        disc = findViewById(R.id.disclaimerBtn);
        LinearLayout layout = findViewById(R.id.layout);
        disc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopUp.createPopUp(FolicAcid.this, layout);
            }
        });
        disc.isClickable();

        TextView toolHeading = findViewById(R.id.toolHeading);
        toolHeading.setText("Folic Acid");
        backBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        String url  =  "https://github.com/RI-Mehedi/ZenMom-Image/blob/main/folic_acid.jpg?raw=true";
        ImageView imageV = findViewById(R.id.imageV);
        Picasso.get().load(url)
                .resize(480, 360)
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.internet_error)
                .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                .networkPolicy(NetworkPolicy.NO_CACHE)
                .into(imageV);

        //Expanding and Collapsing
        dorpdownImage = findViewById(R.id.dorpdownCComplaints);
        moreSource = findViewById(R.id.moreSourceInCC);
        dataSourceInFolic = findViewById(R.id.dataSourceInCC);
        seeMoreInFA = findViewById(R.id.seeMoreInCC);
        seeMoreInFA.setText("See More");

        dropdownButton = findViewById(R.id.dropdownBtnAlco);
        dropdownButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int visibility = (moreSource.getVisibility() == View.GONE) ? View.VISIBLE : View.GONE;
                moreSource.setVisibility(visibility);
                dataSourceInFolic.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
                if (visibility == View.GONE) {
                    dorpdownImage.setImageResource(R.drawable.baseline_arrow_drop_down_24);
                    seeMoreInFA.setText("See More");
                }
                if (visibility == View.VISIBLE) {
                    dorpdownImage.setImageResource(R.drawable.baseline_arrow_drop_up_24);
                    seeMoreInFA.setText("See Less");
                }

            }
        });
    }
}