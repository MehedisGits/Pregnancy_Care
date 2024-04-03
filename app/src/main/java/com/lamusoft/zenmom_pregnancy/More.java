package com.lamusoft.zenmom_pregnancy;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;

public class More extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_more, container, false);

        LinearLayout aboutUsLay, rateLay, termsLay, privacyLay, disclaimerLay, shareLay;
        aboutUsLay = view.findViewById(R.id.aboutUsLay);
        aboutUsLay.setOnClickListener(v -> startActivity(AboutUs.class));

        rateLay = view.findViewById(R.id.rateLay);
        rateLay.setOnClickListener(v -> {
            try {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.lamusoft.zenmom_pregnancy")));
            } catch (ActivityNotFoundException e) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.lamusoft.zenmom_pregnancy")));
            }
        });

        termsLay = view.findViewById(R.id.termsLay);
        termsLay.setOnClickListener(v -> startActivity(TermsAndConditions.class));

        privacyLay = view.findViewById(R.id.privacyLay);
        privacyLay.setOnClickListener(v -> startActivity(PrivacyPolicy.class));

        disclaimerLay = view.findViewById(R.id.disclaimerLay);
        disclaimerLay.setOnClickListener(v -> startActivity(Disclaimer.class));

        shareLay = view.findViewById(R.id.shareLay);
        shareLay.setOnClickListener(v -> ShareIntent.shareApp(requireContext()));


        return view;
    }

    /**
     * @noinspection rawtypes
     */
    private void startActivity(Class aClass) {
        startActivity(new Intent(getContext(), aClass));
    }
}