package com.lamusoft.zenmom_pregnancy;

import android.annotation.SuppressLint;
import android.content.Context;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;

public class PopUp {
    public static View createPopUp(Context context, View parent) {
        // Inflate the popup layout
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        @SuppressLint("InflateParams") View popupView = inflater.inflate(R.layout.medical_disc, null);

        // Create a PopupWindow with a smooth transition
        PopupWindow popupWindow = new PopupWindow(
                popupView,
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT,
                true);
        TransitionManager.beginDelayedTransition((ViewGroup) popupView, new AutoTransition());

        // Configure the PopupWindow
        popupWindow.setOutsideTouchable(false);

        // Show the popup at the center of the screen
        parent.post(() -> {
            popupWindow.showAtLocation(parent, Gravity.CENTER, 0, 0);

            // Set up the Continue button
            TextView continueBtn = popupView.findViewById(R.id.continueBtn);
            continueBtn.setOnClickListener(v -> popupWindow.dismiss());
        });

        return popupView;
    }
}
