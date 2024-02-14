package com.lamusoft.pregnancyhelp;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private static ClickListener clickListener;
    Context context;
    ArrayList<HashMap<String, Object>> arrayList;

    public MyAdapter(Context context, ArrayList<HashMap<String, Object>> arrayList) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View layoutInflater = LayoutInflater.from(parent.getContext()).inflate(R.layout.guide_section_item, parent,  false);
        return new MyViewHolder(layoutInflater);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {
        String heading = arrayList.get(position).get("title").toString();
        int image = (int) arrayList.get(position).get("image");

        holder.guide_title.setText(heading);
        holder.guideImage.setImageResource(image);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView guide_title;
        ImageView guideImage;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener((View.OnClickListener) this);

            guide_title = itemView.findViewById(R.id.guide_title);
            guideImage = itemView.findViewById(R.id.guideImage);


        }
        @Override
        public void onClick(View v) {
            if (clickListener != null) {
                clickListener.onItemCLick(getAdapterPosition(), v);
            }
        }
    }
    public interface ClickListener{
        void onItemCLick(int position, View v);
    }
    public void setOnClickListener(ClickListener clickListener){
        this.clickListener = clickListener;
    }
}

