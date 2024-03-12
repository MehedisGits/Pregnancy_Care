package com.lamusoft.zenmom_pregnancy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

public class SizeMilestone extends Fragment {

    private String length;
    private String weight;
    private String compare;
    private String url;

    public SizeMilestone(String url, String compareTV, String length, String weight) {
        this.url = url;
        this.compare = compareTV;
        this.length = length;
        this.weight = weight;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_sizemilestone, container, false);


        ImageView imageView = v.findViewById(R.id.imageV);
        TextView weightTV = v.findViewById(R.id.weightTV);
        TextView lenthTV = v.findViewById(R.id.lentghTV);
        TextView compareTV = v.findViewById(R.id.compareTV);

        if (imageView != null){
            Picasso.get().load(url)
                    .resize(360, 240)
                    .placeholder(R.drawable.placeholder)
                    .error(R.drawable.internet_error)
                    .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                    .networkPolicy(NetworkPolicy.NO_CACHE)
                    .into(imageView);

        } if (length != null){
            lenthTV.setText(length);
        } if (weight != null){
            weightTV.setText(weight);
        } if (compareTV != null){
            compareTV.setText(compare);
        }

        return v;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        length = null;
        weight = null;
        compare = null;
        url = null;
    }
}