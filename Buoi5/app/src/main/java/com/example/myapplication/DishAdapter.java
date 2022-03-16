package com.example.myapplication;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DishAdapter extends RecyclerView.Adapter<DishAdapter.ViewHolder> {
    private Context aContext;
    private ArrayList<Dish> aDishes;

    public DishAdapter(Context mContext, ArrayList<Dish> aDishes) {
        this.aContext = mContext;
        this.aDishes = aDishes;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(aContext);
        View dishView = inflater.inflate(R.layout.dish, parent, false);
        ViewHolder viewHolder = new ViewHolder(dishView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        position = holder.getAdapterPosition();
        holder.aDishImage.setImageResource(aDishes.get(position).getDishImage());
        holder.aDishType.setText(aDishes.get(position).getDishType());
        holder.aDishName.setText(aDishes.get(position).getDishName());
        holder.aDishCost.setText(aDishes.get(position).getDishCost());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.itemView.setBackgroundColor(Color.parseColor("#ff7b00"));
            }
        });

    }

    @Override
    public int getItemCount() {
        return aDishes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView aDishImage;
        private TextView aDishType;
        private TextView aDishName;
        private TextView aDishCost;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            aDishImage = itemView.findViewById(R.id.dish_image);
            aDishType = itemView.findViewById(R.id.dish_type);
            aDishName = itemView.findViewById(R.id.dish_name);
            aDishCost = itemView.findViewById(R.id.dish_cost);
        }
    }
};


