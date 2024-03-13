package com.lamusoft.zenmom_pregnancy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private final Context context;
    private final ArrayList<HashMap<String, Object>> arrayList;
    private ClickListener clickListener;

    public MyAdapter(Context context, ArrayList<HashMap<String, Object>> arrayList) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the layout for each item in the RecyclerView
        View layoutInflater = LayoutInflater.from(parent.getContext()).inflate(R.layout.guide_section_item, parent, false);
        return new MyViewHolder(layoutInflater);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        // Bind data to the ViewHolder
        String heading = arrayList.get(position).get("title").toString();
        holder.guideTitle.setText(heading);
        holder.guideImage.setImageResource(R.drawable.sweetpregnancy);
    }

    @Override
    public int getItemCount() {
        // Return the total number of items in the data set
        return arrayList.size();
    }

    // Set a click listener for the RecyclerView items
    public void setOnClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    // Interface to handle item clicks
    public interface ClickListener {
        void onItemClick(int position, View v);
    }

    // ViewHolder class to represent each item in the RecyclerView
    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final TextView guideTitle;
        private final ImageView guideImage;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            // Set the click listener for the item
            itemView.setOnClickListener(this);

            // Initialize views in the ViewHolder
            guideTitle = itemView.findViewById(R.id.guide_title);
            guideImage = itemView.findViewById(R.id.guideImage);
        }

        @Override
        public void onClick(View v) {
            // Handle item click through the interface
            if (clickListener != null) {
                clickListener.onItemClick(getAdapterPosition(), v);
            }
        }
    }
}
