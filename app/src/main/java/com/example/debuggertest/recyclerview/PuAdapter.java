package com.example.debuggertest.recyclerview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.debuggertest.R;

public class PuAdapter extends RecyclerView.Adapter<PuAdapter.PuHolder> {
    private Context mContext;
    private int m;

    public PuAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public PuHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PuHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_staggered_grid_recyclerview_item,parent,false));
    }

    @Override
    public void onBindViewHolder( PuAdapter.PuHolder holder,final int position) {
        Log.d("news","position is: "+position);
        if (position%2!=0){
            holder.imageView.setImageResource(R.drawable.lottoball);
        }else {
            holder.imageView.setImageResource(R.drawable.money);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,"click on Position "+position,Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return 30;
    }

    class PuHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        public PuHolder( View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.iv);
        }
    }


}
