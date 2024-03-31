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

public class PrenatalNutrition extends AppCompatActivity {

    /**
     * @noinspection deprecation
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prenatal_nutrition);

        getWindow().setStatusBarColor(ContextCompat.getColor(getApplicationContext(), R.color.white));

        // Toolbar
        ImageView backBTN = findViewById(R.id.backBtn);
        TextView toolHeading = findViewById(R.id.toolHeading);
        String hTxt = "Prenatal Nutrition";
        toolHeading.setText(hTxt);

        backBTN.setOnClickListener(v -> onBackPressed());

        // Disclaimer Popup
        LinearLayout layout = findViewById(R.id.layout);
        ImageView disc = findViewById(R.id.disclaimerBtn);
        disc.setOnClickListener(v -> PopUp.createPopUp(getApplicationContext(), layout));

        // Layout Transition
        LinearLayout dataSource = findViewById(R.id.dataSOurceInPrenatal);
        dataSource.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);

        // Initialization
        LinearLayout moreDataSource = findViewById(R.id.moreDataSource);
        CardView dropdownBtnPrenatal = findViewById(R.id.dropdownBtnAlco);
        ImageView dropdownImagePrenatal = findViewById(R.id.dropDownCComplaints);
        TextView seeMoreINPrenatal = findViewById(R.id.seeMoreINPrenatal);

        ImageView imageV = findViewById(R.id.imageV);
        String url = "https://github.com/RI-Mehedi/ZenMom-Image/blob/main/prenatal_nutrition" +
                ".jpg?raw=true";
        Glide.with(PrenatalNutrition.this)
                .load(url)
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.internet_error)
                .into(imageV);

        // Click Event for Expanding or Collapsing
        seeMoreINPrenatal.setText(R.string.see_more);
        dropdownBtnPrenatal.setOnClickListener(v -> {
            int visibility = (moreDataSource.getVisibility() == View.GONE) ? View.VISIBLE : View.GONE;
            moreDataSource.setVisibility(visibility);

            if (visibility == View.GONE) {
                seeMoreINPrenatal.setText(R.string.see_more);
                dropdownImagePrenatal.setImageResource(R.drawable.baseline_arrow_drop_down_24);
            }
            if (visibility == View.VISIBLE) {
                seeMoreINPrenatal.setText(R.string.see_less);
                dropdownImagePrenatal.setImageResource(R.drawable.baseline_arrow_drop_up_24);
            }
        });
    }
}
