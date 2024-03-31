package com.lamusoft.zenmom_pregnancy;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;


/**
 * @noinspection deprecation
 */
public class HomemadeTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homemade_test);
        getWindow().setStatusBarColor(ContextCompat.getColor(HomemadeTest.this, R.color.white));

        TextView heading = findViewById(R.id.toolHeading);
        String headingText = "Homemade Tests";
        heading.setText(headingText);

        ImageView backBtn = findViewById(R.id.backBtn);
        backBtn.setOnClickListener(v -> onBackPressed());

        ImageView share = findViewById(R.id.disclaimerBtn);
        share.setImageResource(R.drawable.baseline_share_24);
        share.setOnClickListener(v -> ShareIntent.shareApp(HomemadeTest.this));

        setClickListeners();
    }

    private void setClickListeners() {
        LinearLayout salt = findViewById(R.id.salt);
        setHomemadeTestClickListener(salt, "Salt", R.string.salt, R.string.saltC);

        LinearLayout sugar = findViewById(R.id.sugar);
        setHomemadeTestClickListener(sugar,"Sugar", R.string.sugar, R.string.sugarC);

        LinearLayout vinegar = findViewById(R.id.vinegar);
        setHomemadeTestClickListener(vinegar,"Vinegar", R.string.Vinegar,
                R.string.VinegarC);

        LinearLayout shampoo = findViewById(R.id.shampoo);
        setHomemadeTestClickListener(shampoo,"Shampoo", R.string.shampoo, R.string.shampooC);

        LinearLayout wheat = findViewById(R.id.wheat);
        setHomemadeTestClickListener(wheat,"Wheat and Barley", R.string.wheat, R.string.wheatC);

        LinearLayout soda = findViewById(R.id.soda);
        setHomemadeTestClickListener(soda,"Baking Soda", R.string.soda, R.string.sodaC);
    }

    private void setHomemadeTestClickListener(LinearLayout layout, String titleH ,int titleResId, int bodyResId)
    {
        layout.setOnClickListener(v -> {
            String title = getString(titleResId);
            String body = getString(bodyResId);

            Intent intent = new Intent(getApplicationContext(), PregnancySignsContent.class);
            intent.putExtra("title", title);
            intent.putExtra("body", body);
            intent.putExtra("heading", titleH);

        });
    }
}
