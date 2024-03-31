package com.lamusoft.zenmom_pregnancy;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;

public class DietSection extends Fragment {

    LinearLayout firstTrimester, secondTrimester, thirdTrimester, foodsToAvoid, pregnancyBeautyTips;
    Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_diet_section, container, false);

        initializeUI(view);
        clickEventHandle();

        return view;
    }

    private void clickEventHandle() {
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
        foodsToAvoid.setOnClickListener(v -> {
            NutritionContent.title = "Foods to Avoid:";
            intent(R.layout.foods_to_avoid);
        });
        pregnancyBeautyTips.setOnClickListener(v -> {
            NutritionContent.title = "Beauty Tips:";
            intent(R.layout.beauty_during_pregnancy);
        });
    }

    private void initializeUI(View view) {
        // Initialize LinearLayouts
        context = view.getContext();
        firstTrimester = view.findViewById(R.id.firstTrimester);
        secondTrimester = view.findViewById(R.id.secondTrimester);
        thirdTrimester = view.findViewById(R.id.thirdTrimester);
        foodsToAvoid = view.findViewById(R.id.foodstoAvoid);
        pregnancyBeautyTips = view.findViewById(R.id.pregnancyBeautytips);
    }

    // Method to start NutritionContent activity with specific layout
    public void intent(int layout) {
        Intent intent = new Intent(context, NutritionContent.class);
        intent.putExtra("layout", layout);

        startActivity(intent);
    }
}