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

public class FolicAcid extends AppCompatActivity {

    private TextView seeMoreInFA;
    private ImageView dropDownImage;
    private LinearLayout moreSource, dataSourceInFolic;

    /**
     * @noinspection deprecation
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_folic_acid);
        getWindow().setStatusBarColor(ContextCompat.getColor(FolicAcid.this, R.color.white));

        // Toolbar
        ImageView backBTN = findViewById(R.id.backBtn);
        ImageView disc = findViewById(R.id.disclaimerBtn);
        LinearLayout layout = findViewById(R.id.layout);
        disc.setOnClickListener(v -> PopUp.createPopUp(FolicAcid.this, layout));
        disc.isClickable();

        TextView toolHeading = findViewById(R.id.toolHeading);
        String heading = "Folic Acid";
        toolHeading.setText(heading);

        backBTN.setOnClickListener(v -> onBackPressed());

        // Load image from URL using Picasso
        String url = "https://github.com/RI-Mehedi/ZenMom-Image/blob/main/folic_acid.jpg?raw=true";
        ImageView imageV = findViewById(R.id.imageV);
        Glide.with(FolicAcid.this)
                .load(url)
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.internet_error)
                .into(imageV);

        // Expanding and Collapsing functionality
        dropDownImage = findViewById(R.id.dropDownCComplaints);
        moreSource = findViewById(R.id.moreSourceInCC);
        dataSourceInFolic = findViewById(R.id.dataSourceInCC);
        seeMoreInFA = findViewById(R.id.seeMoreInCC);
        seeMoreInFA.setText(getString(R.string.see_more));

        CardView dropdownButton = findViewById(R.id.dropdownBtnAlco);
        dropdownButton.setOnClickListener(v -> {
            int visibility = (moreSource.getVisibility() == View.GONE) ? View.VISIBLE : View.GONE;
            moreSource.setVisibility(visibility);
            dataSourceInFolic.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
            if (visibility == View.GONE) {
                dropDownImage.setImageResource(R.drawable.baseline_arrow_drop_down_24);
                seeMoreInFA.setText(getString(R.string.see_more));
            }
            if (visibility == View.VISIBLE) {
                dropDownImage.setImageResource(R.drawable.baseline_arrow_drop_up_24);
                seeMoreInFA.setText(getString(R.string.see_less));
            }
        });
    }
}
