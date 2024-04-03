package com.lamusoft.zenmom_pregnancy;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.airbnb.lottie.LottieAnimationView;

import java.util.Calendar;

public class DatePickerActivity extends AppCompatActivity {

    // Constants
    private final String START_DATE_KEY = "start_date";

    private EditText dateEdText;

    // Variables
    private String startDateStr;
    private Context context;
    private SharedPreferences sharedPreferences;
    private Calendar startDateCalendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_picker);

        // Set status bar color
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.white));

        // Initialize context and SharedPreferences
        context = this;
        String PREF_FILE_KEY = "progress_pref";
        sharedPreferences = getSharedPreferences(PREF_FILE_KEY, Context.MODE_PRIVATE);

        // Initialize startDateCalendar
        startDateCalendar = Calendar.getInstance();

        // Find UI elements by ID
        // UI elements
        TextView howWeCalculateBtn = findViewById(R.id.howWeCalculateBtn);
        dateEdText = findViewById(R.id.dateEdText);
        Button getStart = findViewById(R.id.getStartedBtn);

        howWeCalculateBtn.setOnClickListener(v -> showAlertDialogue());
        LottieAnimationView animationView = findViewById(R.id.welcomeLottie);
        animationView.setAnimation(R.raw.welcome);
        animationView.playAnimation();

        TextView privacyBtn = findViewById(R.id.privacyBtn);
        privacyBtn.setOnClickListener(v -> {
            String url = "https://sites.google.com/view/privacypolicyzenmom/%E0%A6%B9%E0%A6%AE";
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));

            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            } else {
                Toast.makeText(this, "No app found to handle this action", Toast.LENGTH_SHORT).show();
            }
        });

        // Set click listeners
        dateEdText.setOnClickListener(v -> showDatePickerDialog());

        // Retrieve start date from SharedPreferences
        startDateStr = sharedPreferences.getString(START_DATE_KEY, "");

        // Handle "Get Started" button click
        getStart.setOnClickListener(v -> {
            if (startDateStr.isEmpty()) {
                dateEdText.setError("Enter a Valid Date");
            } else {
                startActivity(new Intent(context, MainActivity.class));
            }
        });

    }

    private void showAlertDialogue() {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Why are we asking and how we calculate it?")
                .setMessage("""
                        Wondering why we're asking for your last period date? It's because it helps us with some important stuff:

                        Figuring Out Your Due Date:
                        We use it to estimate when your baby might be due. Pretty handy, right?

                        Keeping Track of Your Pregnancy:
                        We'll use the info to make sure everything's going smoothly for you and your baby.

                        Adjusting for Differences:
                        Every pregnancy is different, so we'll tweak things if needed to give you the best advice.

                        Getting Ready for Baby:
                        Knowing your due date helps you plan and prepare for the big day!

                        So, sharing your last period date helps us help you better! \uD83D\uDE09
                        """)
                .setPositiveButton("OK", (dialog, which) -> {
                    // Optional: add functionality for when OK button is clicked
                })
                .show(); // This displays the dialog
    }

    // Show a Date Picker Dialog
    private void showDatePickerDialog() {
        // Get current date
        int year = startDateCalendar.get(Calendar.YEAR);
        int month = startDateCalendar.get(Calendar.MONTH);
        int dayOfMonth = startDateCalendar.get(Calendar.DAY_OF_MONTH);

        // Show DatePickerDialog
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                context,
                (view, year1, monthOfYear, dayOfMonth1) -> {
                    String selectedDate = dayOfMonth1 + "/" + (monthOfYear + 1) + "/" + year1;
                    saveStartDate(selectedDate);
                    startDateCalendar.set(year1, monthOfYear, dayOfMonth1);
                    dateEdText.setText(selectedDate);
                    startDateStr = selectedDate;
                },
                year,
                month,
                dayOfMonth
        );
        datePickerDialog.show();
    }

    // Save start date using SharedPreferences
    private void saveStartDate(String startDate) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(START_DATE_KEY, startDate);
        editor.apply();
    }
}
