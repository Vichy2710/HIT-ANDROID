package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.List;

public class MonAnAdapter extends RecyclerView.Adapter<MonAnAdapter.ViewHolder> {
    List<MonAn> monAns;
    Context context;
    public MonAnAdapter(Context context, List<MonAn> monAns){
        this.monAns=monAns;
        this.context=context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.one_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MonAn monAn = monAns.get(position);

        Picasso.get().load(monAn.getAvt()).into(holder.avt);
        holder.moanname.setText(monAn.getMoanname());
        holder.tien.setText(monAn.getTien());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ChiTietMonAn.class);
                Bundle bundle =  new Bundle();
                bundle.putSerializable("MonAn", monAn);
                intent.putExtras(bundle);

                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                //holder.itemView.setBackgroundColor(Color.parseColor("F9975D"));

                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return monAns.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView avt, monanId;
        TextView moanname, tien, nguyenlieu, congthuc;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            avt = itemView.findViewById(R.id.avt);
            moanname = itemView.findViewById(R.id.moanname);
            tien = itemView.findViewById(R.id.tien);
        }
    }
}
