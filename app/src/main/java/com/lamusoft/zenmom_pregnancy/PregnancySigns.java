package com.lamusoft.zenmom_pregnancy;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

public class PregnancySigns extends AppCompatActivity {

    private CardView missedPeriod, morningSickness, breastChanges, frequentUrination, fatigue, increasedAppetite, moodSwing, changesSkin, weightGain, movement, swelling;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregnancy_signs);
        getWindow().setStatusBarColor(ContextCompat.getColor(getApplicationContext(), R.color.white));

        initializeViews();
        setStatusBarAndHeading();


        ImageView disc = findViewById(R.id.disclaimerBtn);

        LinearLayout layout = findViewById(R.id.layout);
        disc.setOnClickListener(v -> PopUp.createPopUp(getApplicationContext(), layout));

        setClickListeners(missedPeriod, R.string.missedPeriods, R.string.missedPC);
        setClickListeners(morningSickness, R.string.morningSickness, R.string.morningC);
        setClickListeners(breastChanges, R.string.breastChanges, R.string.breastC);
        setClickListeners(frequentUrination, R.string.uniration, R.string.urinationC);
        setClickListeners(fatigue, R.string.fatigue, R.string.fatigueC);
        setClickListeners(increasedAppetite, R.string.appetite, R.string.appetiteC);
        setClickListeners(moodSwing, R.string.mood_swing, R.string.mood_swingC);
        setClickListeners(changesSkin, R.string.changesSkin, R.string.changesSkinC);
        setClickListeners(weightGain, R.string.weightGain, R.string.weightGainC);
        setClickListeners(movement, R.string.babyMovement, R.string.babyMovementC);
        setClickListeners(swelling, R.string.Swelling, R.string.SwellingC);
    }
    private void initializeViews() {
        missedPeriod = findViewById(R.id.missedPeriod);
        morningSickness = findViewById(R.id.morningSickness);
        breastChanges = findViewById(R.id.breastChanges);
        frequentUrination = findViewById(R.id.frequentUrination);
        fatigue = findViewById(R.id.fatgue);
        increasedAppetite = findViewById(R.id.increasedAppetitte);
        moodSwing = findViewById(R.id.moodSwing);
        changesSkin = findViewById(R.id.changesSkin);
        weightGain = findViewById(R.id.weightGain);
        movement = findViewById(R.id.movement);
        swelling = findViewById(R.id.swelling);
    }

    /**
     * @noinspection deprecation
     */
    private void setStatusBarAndHeading() {
        ImageView backBtn = findViewById(R.id.backBtn);
        TextView heading = findViewById(R.id.toolHeading);
        String signsAndSymptoms = "Signs & Symptoms";
        heading.setText(signsAndSymptoms);

        backBtn.setOnClickListener(v -> onBackPressed());
    }

    private void setClickListeners(CardView cardView, int titleResId, int articleResId) {
        cardView.setOnClickListener(v -> {
            String title = getString(titleResId);
            String article = getString(articleResId);

            Intent intent = new Intent(getApplicationContext(), PregnancySignsContent.class);
            intent.putExtra("title", title);
            intent.putExtra("body", article);
            intent.putExtra("heading", "Pregnancy Signs");

            startActivity(intent);
        });
    }
}
