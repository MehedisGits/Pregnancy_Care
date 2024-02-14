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

public class FolicAcid extends AppCompatActivity {

    TextView fl1,fl2,fl3,fl4,fl5,fl6,fl7,fl8,fl9,fl10,fl11,fl12,fl13,fl14,fl15,fl16,fl17,fl18,fl19,fl20;
    ImageView dorpdownImage;
    CardView dropdownButton;
    LinearLayout moreSource, dataSourceInFolic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_folic_acid);
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.white));

        dorpdownImage = findViewById(R.id.dorpdownImagePrenatal);
        moreSource = findViewById(R.id.moreSource);
        dataSourceInFolic  =findViewById(R.id.dataSourceInFolic);

        dropdownButton = findViewById(R.id.dropdownBtnPrenatal);
        dropdownButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int visibility = (moreSource.getVisibility()==View.GONE)?View.VISIBLE: View.GONE;
                moreSource.setVisibility(visibility);
                dataSourceInFolic.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
                if (visibility == View.GONE){
                    dorpdownImage.setImageResource(R.drawable.baseline_arrow_drop_down_24);
                }
                if (visibility == View.VISIBLE){
                    dorpdownImage.setImageResource(R.drawable.baseline_arrow_drop_up_24);
                }

            }
        });

        ////HyperLinkSet
        fl1 = findViewById(R.id.fl1);
        String url = fl1.getText().toString();
        HyperLinkClick(fl1, url);
        fl2 = findViewById(R.id.fl2);
        String url1 = fl2.getText().toString();
        HyperLinkClick(fl2, url1);
        fl3 = findViewById(R.id.fl3);
        String url2 = fl3.getText().toString();
        HyperLinkClick(fl3, url2);
        fl4 = findViewById(R.id.fl4);
        String url3 = fl4.getText().toString();
        HyperLinkClick(fl4, url3);
        fl5 = findViewById(R.id.fl5);
        String url4 = fl5.getText().toString();
        HyperLinkClick(fl5, url4);
        fl6 = findViewById(R.id.fl6);
        String url5 = fl6.getText().toString();
        HyperLinkClick(fl6, url5);
        fl7 = findViewById(R.id.fl7);
        String url6 = fl7.getText().toString();
        HyperLinkClick(fl7, url6);
        fl8 = findViewById(R.id.fl8);
        String url7 = fl8.getText().toString();
        HyperLinkClick(fl8, url7);
        fl9 = findViewById(R.id.fl9);
        String url8 = fl9.getText().toString();
        HyperLinkClick(fl7, url8);
        fl10 = findViewById(R.id.fl10);
        String url9 = fl10.getText().toString();
        HyperLinkClick(fl10, url9);
        fl11 = findViewById(R.id.fl11);
        String url10 = fl11.getText().toString();
        HyperLinkClick(fl11, url10);
        fl12 = findViewById(R.id.fl12);
        String url11 = fl12.getText().toString();
        HyperLinkClick(fl12, url11);
        fl13 = findViewById(R.id.fl13);
        String url12 = fl13.getText().toString();
        HyperLinkClick(fl13, url12);
        fl14 = findViewById(R.id.fl14);
        String url13 = fl14.getText().toString();
        HyperLinkClick(fl14, url13);
        fl15 = findViewById(R.id.fl15);
        String url14 = fl15.getText().toString();
        HyperLinkClick(fl15, url14);
        fl16 = findViewById(R.id.fl16);
        String url15 = fl16.getText().toString();
        HyperLinkClick(fl16, url15);
        fl17 = findViewById(R.id.fl17);
        String url16 = fl17.getText().toString();
        HyperLinkClick(fl17, url16);
        fl18 = findViewById(R.id.fl18);
        String url17 = fl18.getText().toString();
        HyperLinkClick(fl18, url17);
        fl19 = findViewById(R.id.fl19);
        String url18 = fl19.getText().toString();
        HyperLinkClick(fl19, url18);
        fl20 = findViewById(R.id.fl);
        String url19 = fl20.getText().toString();
        HyperLinkClick(fl20, url19);




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

/*    public void expand(View view, LinearLayout layout) {
        int v = (view.getVisibility()==View.GONE)?View.VISIBLE: View.GONE;
        TransitionManager.beginDelayedTransition(layout, new AutoTransition());
        view.setVisibility(v);
    }*/
}