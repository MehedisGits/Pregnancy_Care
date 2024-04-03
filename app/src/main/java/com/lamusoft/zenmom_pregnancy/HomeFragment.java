package com.lamusoft.zenmom_pregnancy;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class HomeFragment extends Fragment {
    public static int GET_WEEK_NUM;
    private ConstraintLayout motherHealthGuideSection, babySizeSection, trackerActivity;
    private ImageView partnerSupport;
    private LinearLayout babyGrowthSection;
    private Context context;
    private TextView remainingDaysTV, runningWeeksNumberTV, currentWeekDayTV, completedPercentageTv;
    private Handler handler;
    private Runnable progressRunnable;
    private Calendar startDateCalendar;
    private ProgressBar pregnancyProgressbar;

    @SuppressLint("NewApi")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // Initialize UI elements
        context = getContext();
        babySizeSection = view.findViewById(R.id.babySizeSection);
        partnerSupport = view.findViewById(R.id.partnerSupport);
        motherHealthGuideSection = view.findViewById(R.id.motherHealthGuideSection);
        babyGrowthSection = view.findViewById(R.id.babyGrowthSection);

        remainingDaysTV = view.findViewById(R.id.remainingDaysTextView);
        runningWeeksNumberTV = view.findViewById(R.id.numberOfWeeksTextView);
        currentWeekDayTV = view.findViewById(R.id.currentWeekDayTV);
        completedPercentageTv = view.findViewById(R.id.completedPercentageTv);
        pregnancyProgressbar = view.findViewById(R.id.pregnancyProgressBar);
        trackerActivity = view.findViewById(R.id.trackerActivity);

        String PREF_FILE_KEY = "progress_pref";
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_FILE_KEY, Context.MODE_PRIVATE);

        String START_DATE_KEY = "start_date";
        String startDateStr = sharedPreferences.getString(START_DATE_KEY, "");

        if (startDateStr.isEmpty()) {
            // Delay showing the popup until the fragment's view is created
            // to avoid parent view being null
            handler = new Handler();
            handler.postDelayed(() -> trackerActivity.setVisibility(View.GONE), 100);
        } else {
            startDateCalendar = Calendar.getInstance();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
            try {
                Date startDate = dateFormat.parse(startDateStr);

                if (startDate != null) {
                    startDateCalendar.setTime(startDate);
                }
                startProgressTracker();
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }

        setClickListeners();
        return view;
    }

    //Start Tracking the Progress
    private void startProgressTracker() {
        handler = new Handler();
        progressRunnable = new Runnable() {
            @Override
            public void run() {
                updateProgress();
                handler.postDelayed(this, 60000);
            }
        };
        handler.post(progressRunnable);
    }

    //Update Progress
    @SuppressLint("SetTextI18n")
    private void updateProgress() {
        Calendar currentDate = Calendar.getInstance();
        long differenceMillis = currentDate.getTimeInMillis() - startDateCalendar.getTimeInMillis();
        long remainingDays = 280 - (differenceMillis / (1000 * 60 * 60 * 24));
        long runningWeeks = differenceMillis / (1000 * 60 * 60 * 24 * 7);
        long currentWeekDay = (differenceMillis / (1000 * 60 * 60 * 24)) % 7;

        double completedPercentage = ((280 - remainingDays) * 100.0) / 280;
        String formattedPercentage = String.format(Locale.getDefault(), "%.1f%%", completedPercentage);

        remainingDaysTV.setText(String.valueOf(remainingDays));
        runningWeeksNumberTV.setText(String.valueOf(runningWeeks));
        currentWeekDayTV.setText("+" + currentWeekDay + " day");

        GET_WEEK_NUM = (int) runningWeeks;

        // Update ProgressBar
        completedPercentageTv.setText(formattedPercentage);

        pregnancyProgressbar.setProgress((int) (280 - remainingDays));
    }

    //Click Event Handle of All Section in Home Fragment
    private void setClickListeners() {
        babySizeSection.setOnClickListener(v -> startNewActivity(BabySizeMilestone.class));
        motherHealthGuideSection.setOnClickListener(v -> startNewActivity(ComprehensiveGuideActivity.class));
        babyGrowthSection.setOnClickListener(v -> startNewActivity(FetalDevelopmentChart.class));
        partnerSupport.setOnClickListener(v -> startNewActivity(PartnerSupport.class));

    }

    // Event On ClickListen==============
    private void startNewActivity(Class<?> activityClass) {
        Intent intent = new Intent(context, activityClass);
        intent.putExtra("weekNumber", GET_WEEK_NUM);
        startActivity(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (handler != null) {
            handler.removeCallbacks(progressRunnable);
        }
    }

}
