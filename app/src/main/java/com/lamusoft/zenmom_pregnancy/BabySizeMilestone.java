package com.lamusoft.zenmom_pregnancy;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class BabySizeMilestone extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baby_size_milestone);

        getWindow().setStatusBarColor(ContextCompat.getColor(getApplicationContext(), R.color.white));

        tabLayout = findViewById(R.id.tabLayoutBabySize);
        pager = findViewById(R.id.pagerIdBabySize);

        ImageView backBtn = findViewById(R.id.backBtn);
        ImageView disc;
        disc = findViewById(R.id.disclaimerBtn);
        disc.setImageResource(R.drawable.baseline_share_24);
        disc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShareIntent.shareApp(BabySizeMilestone.this);
            }
        });
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        TextView heading = findViewById(R.id.toolHeading);
        heading.setText("Track Baby Size");


        SizeAdapter sizeAdapter = new SizeAdapter(getSupportFragmentManager());
        pager.setAdapter(sizeAdapter);
        tabLayout.setupWithViewPager(pager);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public class SizeAdapter extends FragmentPagerAdapter {
        int count;

        public SizeAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {

            switch (position){
                case 0: return new SizeMilestone("https://images.unsplash.com/photo-1501740326664-5571ff5e30a6?q=80&w=1473&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D", "Very Small", "Very Small", "Very Small");//1to3
                case 1: return new SizeMilestone("https://github.com/RI-Mehedi/ZenMom-Image/blob/main/poppy_seed.png?raw=true", "Poppy seed", "2 mm", "Very Small");//4
                case 2: return new SizeMilestone("https://github.com/RI-Mehedi/ZenMom-Image/blob/main/sesame.png?raw=true", "Sesame", "2 mm", "Very Small");//5
                case 3: return new SizeMilestone("https://github.com/RI-Mehedi/ZenMom-Image/blob/main/lentils.png?raw=true", "Lentils", "6 mm", "Very Small");//6
                case 4: return new SizeMilestone("https://github.com/RI-Mehedi/ZenMom-Image/blob/main/parched_rice.png?raw=true", "Parched rice", "10 mm", "Very Small");//7
                case 5: return new SizeMilestone("https://github.com/RI-Mehedi/ZenMom-Image/blob/main/pumpkin_seed.png?raw=true", "Pumpkin seed", "16 mm", "Very Small");//8
                case 6: return new SizeMilestone("https://github.com/RI-Mehedi/ZenMom-Image/blob/main/cherry.png?raw=true", "Cherry", "22 mm", "Very Small");//9
                case 7: return new SizeMilestone("https://github.com/RI-Mehedi/ZenMom-Image/blob/main/strawberry.png?raw=true", "Small Strawberry", "30mm", "Very Small");//10
                case 8: return new SizeMilestone("https://github.com/RI-Mehedi/ZenMom-Image/blob/main/plum.png?raw=true", "Plum", "41 mm", "Very Small");//11
                case 9: return new SizeMilestone("https://github.com/RI-Mehedi/ZenMom-Image/blob/main/paper_lemons.png?raw=true", "Lemon", "5.4 cm", "18 Grams");//12
                case 10: return new SizeMilestone("https://github.com/RI-Mehedi/ZenMom-Image/blob/main/hog_plum.png?raw=true", "Hog-plum", "7.4 cm", "25 Grams");//13
                case 11: return new SizeMilestone("https://github.com/RI-Mehedi/ZenMom-Image/blob/main/apple.png?raw=true", "Apple", "8.5 cm", "57 Grams");//14
                case 12: return new SizeMilestone("https://github.com/RI-Mehedi/ZenMom-Image/blob/main/pomegranate.png?raw=true", "Pomegranate", "10.1 cm", "70 Grams");//15
                case 13: return new SizeMilestone("https://github.com/RI-Mehedi/ZenMom-Image/blob/main/carambola.png?raw=true", "Carambola", "11.6 cm", "70 Grams");//16
                case 14: return new SizeMilestone("https://github.com/RI-Mehedi/ZenMom-Image/blob/main/banana.png?raw=true", "Banana", "12 cm", "150 Grams");//17
                case 15: return new SizeMilestone("https://github.com/RI-Mehedi/ZenMom-Image/blob/main/okra.png?raw=true", "Okra", "14.2 cm", "190 Grams");//18
                case 16: return new SizeMilestone("https://github.com/RI-Mehedi/ZenMom-Image/blob/main/carrot.png?raw=true", "carrot", "15.3 cm", "240 Grams");//19
                case 17: return new SizeMilestone("https://github.com/RI-Mehedi/ZenMom-Image/blob/main/cucumber.png?raw=true", "Cucumber", "25.6 cm", "300 Grams");//20
                case 18: return new SizeMilestone("https://img.freepik.com/free-vector/exotic-tropical-fruit-icon-cartoon_18591-51654.jpg?t=st=1710056141~exp=1710059741~hmac=9dfc485f10a80373f255419e94dd8e77d8a4adcb462a0a60d5887889801228c2&w=740", "Sea Banana", "26.7 cm", "350 Grams");//21
                case 19: return new SizeMilestone("https://img.freepik.com/free-photo/sweet-potatoes_144627-33699.jpg?t=st=1710056189~exp=1710059789~hmac=6f9c165dbe83c3cf3103677a0ce7679f6d8efa1559ae0573dc885786c2cd27a4&w=826", "Sweet Potato", "27.8 cm", "430 Grams");//22
                case 20: return new SizeMilestone("https://img.freepik.com/free-photo/fresh-papaya-fruit_144627-34219.jpg?t=st=1710056241~exp=1710059841~hmac=c29c0fb3c1a720ffe39527036a7457066883aedea2b5da9b87d106ed064e0007&w=826", "Papaya", "28.9 cm", "500 Grams");//23
                case 21: return new SizeMilestone("https://github.com/RI-Mehedi/ZenMom-Image/blob/main/green_coconut.png?raw=true", "Green Coconut", "30 cm", "600 Grams");//24
                case 22: return new SizeMilestone("https://img.freepik.com/free-photo/photo-pineapple-white-background_125540-4599.jpg?w=826", "Pineapple", "34.6 cm", "660 Grams");//25
                case 23: return new SizeMilestone("https://img.freepik.com/free-photo/cauliflower-isolated_1203-6777.jpg?t=st=1710056428~exp=1710060028~hmac=17fd9d2b0050d2a75ed7c3d310eb8dc5b543cdaad3f4b95d0d7e877d88aa9464&w=826", "Cauliflower", "35.6 cm", "760 Grams");//26
                case 24: return new SizeMilestone("https://img.freepik.com/free-photo/bitter-melon_74190-4097.jpg?t=st=1710056545~exp=1710060145~hmac=583d67c5ee38f2a252cd3711ebe2c32842ed716b4807286c9b25165213955cd0&w=826", "Sponge gourd", "36.6 cm", "875 Grams");//27
                case 25: return new SizeMilestone("https://github.com/RI-Mehedi/ZenMom-Image/blob/main/snake_gourd.png?raw=true", "Snake gourd", "37.6 cm", "1 kg");//28
                case 26: return new SizeMilestone("https://github.com/RI-Mehedi/ZenMom-Image/blob/main/white_cabbage.png?raw=true", "White Cabbage", "38.6 cm", "1.2 kg");//29
                case 27: return new SizeMilestone("https://github.com/RI-Mehedi/ZenMom-Image/blob/main/green_coconut.png?raw=true", "Coconut", "39.9 cm", "1.3 kg");//30
                case 28: return new SizeMilestone("https://github.com/RI-Mehedi/ZenMom-Image/blob/main/muskmelon.png?raw=true", "Muskmelon", "41.1 cm", "1.5 kg");//31
                case 29: return new SizeMilestone("https://img.freepik.com/free-photo/photo-pineapple-white-background_125540-4599.jpg?w=826", "Pineapple", "42.4 cm", "1.7 kg");//32
                case 30: return new SizeMilestone("https://github.com/RI-Mehedi/ZenMom-Image/blob/main/butternusquash.png?raw=true", "Butternu squash", "43.7 cm", "1.9 kg");//33
                case 31: return new SizeMilestone("https://github.com/RI-Mehedi/ZenMom-Image/blob/main/honey_melon.png?raw=true", "Honey Melon", "45 cm", "2.1 kg");//34
                case 32: return new SizeMilestone("https://github.com/RI-Mehedi/ZenMom-Image/blob/main/double_papaya.png?raw=true", "Double Papaya", "46.2 cm", "2.4 kg");//35
                case 33: return new SizeMilestone("https://github.com/RI-Mehedi/ZenMom-Image/blob/main/watermelon.png?raw=true", "Watermelon", "47.4 cm", "2.6 kg");//36
                case 34: return new SizeMilestone("https://github.com/RI-Mehedi/ZenMom-Image/blob/main/doublecoconut.png?raw=true", "Double Coconut", "48.6 cm", "2.9 kg");//37
                case 35: return new SizeMilestone("https://github.com/RI-Mehedi/ZenMom-Image/blob/main/calabash.png?raw=true", "Calabash", "49.8 cm", "3 kg");//38
                case 36: return new SizeMilestone("https://github.com/RI-Mehedi/ZenMom-Image/blob/main/double_pineapple.png?raw=true", "Double Pineapple", "50.7cm", "3.3 kg");//39
                case 37: return new SizeMilestone("https://github.com/RI-Mehedi/ZenMom-Image/blob/main/jackfruit.png?raw=true", "Big Jackfruit", "51.2cm", "3.5 kg");//40

            }return null;
        }

        @Override
        public int getCount() {
            return 38;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                case 0: return "1 to 3 weeks";
                case 1: return "4th week";
                case 2: return "5th week";
                case 3: return "6th week";
                case 4: return "7th week";
                case 5: return "8th week";
                case 6: return "9th week";
                case 7: return "10th week";
                case 8: return "11th week";
                case 9: return "12th week";
                case 10: return "13th week";
                case 11: return "14th week";
                case 12: return "15th week";
                case 13: return "16th week";
                case 14: return "17th week";
                case 15: return "18th week";
                case 16: return "19th week";
                case 17: return "20th week";
                case 18: return "21th week";
                case 19: return "22th week";
                case 20: return "23th week";
                case 21: return "24th week";
                case 22: return "25th week";
                case 23: return "26th week";
                case 24: return "27th week";
                case 25: return "28th week";
                case 26: return "29th week";
                case 27: return "30th week";
                case 28: return "31th week";
                case 29: return "32th week";
                case 30: return "33th week";
                case 31: return "34th week";
                case 32: return "35th week";
                case 33: return "36th week";
                case 34: return "37th week";
                case 35: return "38th week";
                case 36: return "39th week";
                case 37: return "40th week";

            }
            return null;
        }
    }
}