package com.example.debuggertest.recyclerview;

import android.content.Context;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.debuggertest.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.zip.Inflater;

public class GridAdapter extends RecyclerView.Adapter {
    private Context mContext;
    private TextView textView;
    private OnItemClickListener mListener;

    public GridAdapter(Context context, OnItemClickListener listener) {
        this.mContext=context;
        this.mListener=listener;
    }

    @Override
    public GridHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.layout_grid_item,parent,false);
        GridHolder gridHolder=new GridHolder(view);
        return gridHolder;
        //return new GridHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_grid_item,parent,false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        textView.setText("Hallo Gridview");
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(mContext, "click on "+position, Toast.LENGTH_SHORT).show();
                mListener.onClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 80;
    }

    class GridHolder extends RecyclerView.ViewHolder{

        public GridHolder(View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.tv_grid_title);
        }
    }

    public interface OnItemClickListener{
        void onClick(int pos);

    }

}
