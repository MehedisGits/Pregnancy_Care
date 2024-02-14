package com.lamusoft.pregnancyhelp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.HashMap;

public class ComprehensiveGuideActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<HashMap<String, Object>> arrayList = new ArrayList<>();

    String[] heading = {String.valueOf(R.string.folicAcidHeading)};

    int[] layouts = {R.layout.guide_section_item};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comprehensive_guide);
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.white));

        recyclerView = findViewById(R.id.recyclerInGuideActivity);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        putData(arrayList);

        MyAdapter adapter = new MyAdapter(this, arrayList);
        recyclerView.setAdapter(adapter);

        adapter.setOnClickListener(new MyAdapter.ClickListener() {
            @Override
            public void onItemCLick(int position, View v) {

                if (position == 0) {
                    startActivity(new Intent(getApplicationContext(), PrenatalNutrition.class));
                }
                if (position==1){
                    startActivity(new Intent(getApplicationContext(), FolicAcid.class));
                }
            }
        });

    }
    private void putData(ArrayList<HashMap<String, Object>> arrayList){

        HashMap<String, Object> hashMap;

        hashMap = new HashMap<>();
        hashMap.put("title", "Prenatal Nutrition for a Healthy Pregnancy");
        hashMap.put("image", R.drawable.prenatal_nutrition);
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("title", "Folic Acid: A Crucial Element for Every Woman");
        hashMap.put("image", R.drawable.folic_acid_cover);
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("title", "Prenatal uehfui Nutrition");
        hashMap.put("image", R.drawable.baby_growth);
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("title", "Prenatal ");
        hashMap.put("image", R.drawable.pregnancy_guide);
        arrayList.add(hashMap);


    }

}
