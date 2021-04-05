package com.example.debuggertest.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


import androidx.recyclerview.widget.RecyclerView;

import com.example.debuggertest.R;

public class HorAdapter extends RecyclerView.Adapter {

    private TextView textview;
    private Context mContext;

    public HorAdapter(Context context) {
        this.mContext=context;
    }


    @Override
    public  LRViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View k= LayoutInflater.from(mContext).inflate(R.layout.layout_hor_item,parent,false); // LayoutInflater.from 返回一个inflater
        LRViewHolder lrViewHolder=new LRViewHolder(k);
        return lrViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        textview.setText("Hallo Hor View ,");
        textview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "click on "+ position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    class LRViewHolder extends RecyclerView.ViewHolder{                                             //定义holder
        public LRViewHolder( View itemView) {
            super(itemView);
            textview=itemView.findViewById(R.id.tv_hor_title);                                      //定义里面所有元素
        }
    }
}

