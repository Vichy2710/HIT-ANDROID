package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CongViecAdapter extends BaseAdapter {
    private MainActivity context;
    private int layout;
    private List<CongViec> congViecList;

    public CongViecAdapter(MainActivity context, int layout, List<CongViec> congViecList) {
        this.context = context;
        this.layout = layout;
        this.congViecList = congViecList;
    }

    @Override
    public int getCount() {
        return congViecList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    private class ViewHolder{
        TextView text;
        ImageView edit, erase;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view==null){
            holder = new ViewHolder();
            LayoutInflater inflater =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);
            holder.text = view.findViewById(R.id.text);
            holder.edit = view.findViewById(R.id.edit);
            holder.erase = view.findViewById(R.id.erase);
            view.setTag(holder);
        }else{
            holder=(ViewHolder) view.getTag();
        }

        CongViec congViec = congViecList.get(i);
        holder.text.setText(congViec.getTen());

        // bat su kien edit and erase
        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.dialog_edit_note(congViec.getTen(), congViec.getId());
            }
        });

        holder.erase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.dialog_erase_note(congViec.getId());
            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.dialog_show_note(congViec.getTen());
            }
        });

        return view;
    }
}
