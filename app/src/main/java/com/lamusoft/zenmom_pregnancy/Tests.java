package com.lamusoft.zenmom_pregnancy;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;

public class Tests extends Fragment {
    LinearLayout BMI, pregnancySign, testKitGuide, urineTestSection, homemadeTestSection;
    Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tests, container, false);


        context = getContext();
        pregnancySign = view.findViewById(R.id.pregnancySign);
        testKitGuide = view.findViewById(R.id.testKitGuide);
        urineTestSection = view.findViewById(R.id.urineTestSection);
        homemadeTestSection = view.findViewById(R.id.homemadeTestSection);
        BMI = view.findViewById(R.id.bmiCalculator);

        clickHandle();

        return view;
    }

    private void clickHandle() {
        urineTestSection.setOnClickListener(v -> startNewActivity(UrineTestGuide.class));
        BMI.setOnClickListener(v -> startNewActivity(BMI.class));
        homemadeTestSection.setOnClickListener(v -> startNewActivity(HomemadeTest.class));
        pregnancySign.setOnClickListener(v -> startNewActivity(PregnancySigns.class));
        testKitGuide.setOnClickListener(v -> startNewActivity(TestingGuide.class));
    }

    private void startNewActivity(Class<?> activityClass) {
        startActivity(new Intent(context, activityClass));
    }
}