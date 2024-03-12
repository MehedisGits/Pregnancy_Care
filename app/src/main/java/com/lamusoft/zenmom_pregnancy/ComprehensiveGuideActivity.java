package com.lamusoft.zenmom_pregnancy;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;

public class ComprehensiveGuideActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comprehensive_guide);
        getWindow().setStatusBarColor(ContextCompat.getColor(ComprehensiveGuideActivity.this, R.color.white));

        initializeViews();
        setToolbar();
        setupRecyclerView();
    }

    private void initializeViews() {
        recyclerView = findViewById(R.id.recyclerInGuideActivity);
    }

    private void setToolbar() {
        ImageView backBtn = findViewById(R.id.backBtn);
        ImageView shareBtn = findViewById(R.id.disclaimerBtn);
        TextView toolHeading = findViewById(R.id.toolHeading);

        shareBtn.setImageResource(R.drawable.baseline_share_24);
        shareBtn.setOnClickListener(v -> ShareIntent.shareApp(ComprehensiveGuideActivity.this));

        backBtn.setOnClickListener(v -> onBackPressed());
        toolHeading.setText("Wellness Guide");
    }

    private void setupRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(ComprehensiveGuideActivity.this));

        // Initialize data and set up the adapter
        ArrayList<HashMap<String, Object>> arrayList = initializeData();
        MyAdapter adapter = new MyAdapter(ComprehensiveGuideActivity.this, arrayList);
        recyclerView.setAdapter(adapter);

        // Set click listener
        adapter.setOnClickListener((position, v) -> startGuideActivity(position));
    }

    private ArrayList<HashMap<String, Object>> initializeData() {
        ArrayList<HashMap<String, Object>> arrayList = new ArrayList<>();
        arrayList.add(createGuideItem("Prenatal Nutrition for a Healthy Pregnancy"));
        arrayList.add(createGuideItem("Folic Acid: for Every Woman"));
        arrayList.add(createGuideItem("Alcohol, Smoking, and Cannabis Use:"));
        arrayList.add(createGuideItem("Oral Health: Protect your Teeth and Gums"));
        arrayList.add(createGuideItem("Fitness: Tips, Myths, and Common Concerns"));
        arrayList.add(createGuideItem("Prioritizing Mental Health"));
        arrayList.add(createGuideItem("Pregnancy and Sex: What You Need to Know"));
        arrayList.add(createGuideItem("Immunization During Pregnancy"));
        arrayList.add(createGuideItem("Breastfeeding - Safety, Challenges, and Joys"));
        arrayList.add(createGuideItem("Common Pregnancy Discomforts"));

        return arrayList;
    }

    private HashMap<String, Object> createGuideItem(String title) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("title", title);
        return hashMap;
    }

    private void startGuideActivity(int position) {
        Class<?>[] guideActivities = {
                PrenatalNutrition.class, FolicAcid.class, AlcoholAndSmoke.class,
                OralHealth.class, PhysicalActivity.class, MentalHealth.class,
                SexualHealth.class, Immunization.class, Breastfeeding.class,
                CommonComplaints.class
        };

        if (position >= 0 && position < guideActivities.length) {
            startActivity(new Intent(getApplicationContext(), guideActivities[position]));
        }
    }

}
