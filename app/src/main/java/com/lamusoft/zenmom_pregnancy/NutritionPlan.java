package com.lamusoft.zenmom_pregnancy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class NutritionPlan extends AppCompatActivity {
    private LinearLayout firstTrimester, secondTrimester, thirdTrimester, foodstoAvoid, pregnancyBeautytips;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutrition_plan);
        getWindow().setStatusBarColor(ContextCompat.getColor(getApplicationContext(), R.color.white));

        // Initialize LinearLayouts
        firstTrimester = findViewById(R.id.firstTrimester);
        secondTrimester = findViewById(R.id.secondTrimester);
        thirdTrimester = findViewById(R.id.thirdTrimester);
        foodstoAvoid = findViewById(R.id.foodstoAvoid);
        pregnancyBeautytips = findViewById(R.id.pregnancyBeautytips);

        // Initialize TextViews and ImageViews
        TextView heading = findViewById(R.id.toolHeading);
        ImageView backBtn = findViewById(R.id.backBtn);
        heading.setText("Diet and Nutrition");

        // Back button click listener
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        // Share button click listener
        ImageView share = findViewById(R.id.disclaimerBtn);
        share.setImageResource(R.drawable.baseline_share_24);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShareIntent.shareApp(NutritionPlan.this);
            }
        });

        // Click listeners for each nutrition category
        firstTrimester.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NutritionContent.title = "Tips: First Trimester";


                intent(R.layout.first_trimester_nutrition);
            }
        });
        secondTrimester.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NutritionContent.title = "Tips: Second Trimester";


                intent(R.layout.second_trimester_nutrition);


            }
        });
        thirdTrimester.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NutritionContent.title = "Tips: Third Trimester";


                intent(R.layout.third_trimester_nutrition);
            }
        });
        foodstoAvoid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NutritionContent.title = "Foods to Avoid:";

                intent(R.layout.foods_to_avoid);
            }
        });
        pregnancyBeautytips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NutritionContent.title ="Beauty Tips:";
                intent(R.layout.beauty_during_pregnancy);
            }
        });
    }

    // Method to start NutritionContent activity with specific layout
    public void intent(int layout) {
        Intent intent = new Intent(NutritionPlan.this, NutritionContent.class);
        intent.putExtra("layout", layout);

        startActivity(intent);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
