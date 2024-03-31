package com.lamusoft.zenmom_pregnancy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;

public class Weeks29to32 extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.weeks_29to32, container, false);

        ImageView gifV = v.findViewById(R.id.gifView);
        String url = "https://raw.githubusercontent.com/rakibul-islam-mehedi/ZenMom-Image/main/fetus.gif";
        Glide.with(this)
                .load(url)
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.internet_error)
                .into(gifV);

        return v;
    }
}