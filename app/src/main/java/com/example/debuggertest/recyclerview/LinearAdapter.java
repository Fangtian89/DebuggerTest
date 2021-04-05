package com.example.debuggertest.recyclerview;

import android.content.Context;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import com.example.debuggertest.R;

public class LinearAdapter extends RecyclerView.Adapter<LinearAdapter.LinearViewHolder> {           //定义adapter


    private Context mContext;
    private OnItemClickListener mlistener;
    private int m=0,n=0,j=0,k=0,l=0;

    public LinearAdapter(Context context, OnItemClickListener listener) {                           //constructor, 传入constructor
        this.mContext=context;
        this.mlistener=listener;
        m=m+1;
        Log.d("nachricht","in Constructor "+m);
    }

    @Override
    public LinearAdapter.LinearViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {      //返回值 LineViewHolder，映射Layout_layout_item，创建VH并返回
        n=n+1;
        Log.d("nachricht","in onCreateViewHOlder "+n);
        View k=LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_linear_item,parent,false); //view k 就是这个item xml
        LinearViewHolder vHolder=new LinearViewHolder(k);                                           //可以缩写为下面
        //return new LinearViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_linear_item,parent,false)); //inflator 里面传入 具体内容的 xml

//        vHolder.textView.setText("Hallo World");
//       vHolder.mButton.setText("Button "+n);

        return vHolder;
    }

    @Override
    public void onBindViewHolder(LinearAdapter.LinearViewHolder holder, final int position) {       //为holder设置指定数据

        //holder.mButton.setText("Hi");
        j=j+1;
        Log.d("nachricht Position","Position is: "+position);
        holder.textView.setText("Hallo World"+position);
        holder.mButton.setText("Button "+position);

        holder.mButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Toast.makeText(mContext,"click..."+position,Toast.LENGTH_SHORT).show();
                    mlistener.onClick(position);
                }
        });
    }

    @Override
    public int getItemCount() {
        k=k+1;
        Log.d("nachricht","in getItemcount "+k);
        return 30;
    }

    class LinearViewHolder extends RecyclerView.ViewHolder{                                         //定义holder
        private TextView textView;
        private Button mButton;

        public LinearViewHolder( View itemView) {                       //constructor, 赋初始所有值,从OnCreateViewHolder 过来的View
            super(itemView);
            l=l+1;
            Log.d("nachricht","in LinearViewHolder "+l);
            textView=itemView.findViewById(R.id.tv_title);                                          //把具体内容xml 放进holder去
            mButton=itemView.findViewById(R.id.tv_button_1);

        }
    }
    public interface OnItemClickListener{
        void onClick(int pos);                                                                      //public abstract
    }
}
