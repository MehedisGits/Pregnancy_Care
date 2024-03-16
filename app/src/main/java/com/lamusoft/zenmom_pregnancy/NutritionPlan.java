package com.lamusoft.zenmom_pregnancy;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class NutritionPlan extends AppCompatActivity {

    /**
     * @noinspection deprecation
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutrition_plan);
        getWindow().setStatusBarColor(ContextCompat.getColor(NutritionPlan.this, R.color.white));

        // Initialize LinearLayouts
        LinearLayout firstTrimester = findViewById(R.id.firstTrimester);
        LinearLayout secondTrimester = findViewById(R.id.secondTrimester);
        LinearLayout thirdTrimester = findViewById(R.id.thirdTrimester);
        LinearLayout foodstoAvoid = findViewById(R.id.foodstoAvoid);
        LinearLayout pregnancyBeautytips = findViewById(R.id.pregnancyBeautytips);

        // Initialize TextViews and ImageViews
        TextView heading = findViewById(R.id.toolHeading);
        ImageView backBtn = findViewById(R.id.backBtn);
        String h = "Diet and Nutrition";
        heading.setText(h);

        // Back button click listener
        backBtn.setOnClickListener(v -> onBackPressed());

        /* Share button click listener */
        ImageView share = findViewById(R.id.disclaimerBtn);
        share.setImageResource(R.drawable.baseline_share_24);
        share.setOnClickListener(v -> ShareIntent.shareApp(NutritionPlan.this));

        // Click listeners for each nutrition category
        firstTrimester.setOnClickListener(v -> {
            NutritionContent.title = "Tips: First Trimester";


            intent(R.layout.first_trimester_nutrition);
        });
        secondTrimester.setOnClickListener(v -> {
            NutritionContent.title = "Tips: Second Trimester";


            intent(R.layout.second_trimester_nutrition);


        });
        thirdTrimester.setOnClickListener(v -> {
            NutritionContent.title = "Tips: Third Trimester";


            intent(R.layout.third_trimester_nutrition);
        });
        foodstoAvoid.setOnClickListener(v -> {
            NutritionContent.title = "Foods to Avoid:";

            intent(R.layout.foods_to_avoid);
        });
        pregnancyBeautytips.setOnClickListener(v -> {
            NutritionContent.title = "Beauty Tips:";
            intent(R.layout.beauty_during_pregnancy);
        });
    }

    // Method to start NutritionContent activity with specific layout
    public void intent(int layout) {
        Intent intent = new Intent(NutritionPlan.this, NutritionContent.class);
        intent.putExtra("layout", layout);

        startActivity(intent);
    }

}
