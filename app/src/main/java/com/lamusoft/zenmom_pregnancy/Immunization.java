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

public class Immunization extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_immunization);
        getWindow().setStatusBarColor(ContextCompat.getColor(Immunization.this, R.color.white));

        TextView heading = findViewById(R.id.toolHeading);
        heading.setText("Immunization");

        LinearLayout layout = findViewById(R.id.layout);
        ImageView disc = findViewById(R.id.disclaimerBtn);
        disc.setOnClickListener(v -> PopUp.createPopUp(getApplicationContext(), layout));
        disc.setClickable(true);

        ImageView back = findViewById(R.id.backBtn);
        back.setOnClickListener(v -> onBackPressed());

        String url = "https://github.com/RI-Mehedi/ZenMom-Image/blob/main/immunization.jpg?raw=true";
        ImageView imageV = findViewById(R.id.imageV);
        Picasso.get().load(url)
                .resize(480, 360)
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.internet_error)
                .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                .networkPolicy(NetworkPolicy.NO_CACHE)
                .into(imageV);

        TextView seeMore = findViewById(R.id.seeMoreInCC);
        seeMore.setText("Show More");
        LinearLayout moreSourceInImmunization = findViewById(R.id.moreSourceInCC);
        LinearLayout dataSourceInImmunization = findViewById(R.id.dataSourceInCC);
        dataSourceInImmunization.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
        ImageView dorpdownImageImmunization = findViewById(R.id.dorpdownCComplaints);
        dorpdownImageImmunization.setOnClickListener(v -> {
            int vs = (moreSourceInImmunization.getVisibility() == View.GONE) ? View.VISIBLE : View.GONE;
            moreSourceInImmunization.setVisibility(vs);

            if (vs == View.GONE) {
                seeMore.setText("Show More");
                dorpdownImageImmunization.setImageResource(R.drawable.baseline_arrow_drop_down_24);
            }
            if (vs == View.VISIBLE) {
                seeMore.setText("Show Less");
                dorpdownImageImmunization.setImageResource(R.drawable.baseline_arrow_drop_up_24);
            }
        });
    }
}
