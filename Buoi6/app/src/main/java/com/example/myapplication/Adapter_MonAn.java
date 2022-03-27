package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Adapter_MonAn extends RecyclerView.Adapter<Adapter_MonAn.ViewHolder> {

    private Context context;
    private List<MonAn> monAns;

    public Adapter_MonAn() {
    }

    public void setData(List<MonAn> monAns) {
        this.monAns = monAns;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View monAnView = inflater.inflate(R.layout.mon_an, parent, false);
        ViewHolder viewHolder = new ViewHolder(monAnView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        position = holder.getAdapterPosition();
        holder.aAvt.setImageResource(monAns.get(position).getAvt());
        holder.aMonanname.setText(monAns.get(position).getMoanname());
        holder.aTien.setText(monAns.get(position).getTien());

//        int finalPosition = position;
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent toDetail = new Intent(context, Detail.class);
//                toDetail.putExtra("position", finalPosition);
//                context.startActivity(toDetail);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return monAns.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView aAvt;
        private TextView aMonanname;
        private TextView aTien;

        public ViewHolder(@NonNull View monAnView) {
            super(monAnView);
            aAvt = monAnView.findViewById(R.id.avt);
            aMonanname = monAnView.findViewById(R.id.moanname);
            aTien = monAnView.findViewById(R.id.tien);
        }
    }
}

