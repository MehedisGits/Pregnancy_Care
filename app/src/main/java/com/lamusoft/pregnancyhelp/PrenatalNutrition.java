package com.lamusoft.pregnancyhelp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import android.animation.LayoutTransition;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class PrenatalNutrition extends AppCompatActivity {

    TextView sl1, sl2, sl3, sl4, sl5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prenatal_nutrition);
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.white));

        sl1 = findViewById(R.id.fl1);
        sl2 = findViewById(R.id.fl2);
        sl3 = findViewById(R.id.fl3);
        sl4 = findViewById(R.id.fl4);
        sl5 = findViewById(R.id.fl5);

        String url1 = sl1.getText().toString();
        HyperLinkClick(sl1, url1);
        String url2 = sl2.getText().toString();
        HyperLinkClick(sl2, url2);
        String url3 = sl3.getText().toString();
        HyperLinkClick(sl3, url3);
        String url4 = sl4.getText().toString();
        HyperLinkClick(sl4, url4);
        String url5 = sl5.getText().toString();
        HyperLinkClick(sl5, url5);

        LinearLayout dataSource = findViewById(R.id.dataSOurceInPrenatal);
        dataSource.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);

        LinearLayout moreDataSource = findViewById(R.id.moreDataSource);
        CardView dropdownBtnPrenatal = findViewById(R.id.dropdownBtnPrenatal);
        ImageView dorpdownImagePrenatal = findViewById(R.id.dorpdownImagePrenatal);

        dropdownBtnPrenatal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int visibility = (moreDataSource.getVisibility()==View.GONE)?View.GONE: View.VISIBLE;
                moreDataSource.setVisibility(visibility);
                if (visibility==View.GONE){
                    dorpdownImagePrenatal.setImageResource(R.drawable.baseline_arrow_drop_up_24);
                    moreDataSource.setVisibility(View.VISIBLE);
                }if (visibility==View.VISIBLE){
                    dorpdownImagePrenatal.setImageResource(R.drawable.baseline_arrow_drop_down_24);
                    moreDataSource.setVisibility(View.GONE);
                }
            }
        });

    }
    private void HyperLinkClick(TextView tv, String url){
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });
    }
}