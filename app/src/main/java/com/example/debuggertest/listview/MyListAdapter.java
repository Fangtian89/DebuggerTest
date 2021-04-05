package com.example.debuggertest.listview;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.debuggertest.R;

public class MyListAdapter extends BaseAdapter {                                                    //创建映射

private Context mContext;
private LayoutInflater mLayoutInflator;


    public MyListAdapter(Context context) {                                                         //constructor 转如context
        this.mContext=context;
        mLayoutInflator=LayoutInflater.from(context);

        Log.d("news","it runs in constructor ");
    }


    @Override
    public int getCount() {                                                                         //获取数据的总的数量，返回 int 类型的结果；
        Log.d("news","it runs in getCount ");
        return 15;

    }

    @Override
    public long getItemId(int position) {                                                           //获取指定位置数据的id，返回该数据的id，一般以数据所在的位置作为它的id；
        Log.d("news","it runs in getItemID");
        return 0;
    }

    @Override
    public Object getItem(int position) {                                                           //获取指定位置的数据，返回该数据；
        Log.d("news","it runs in getItem");
        return null;
    }

    static class ViewHolder{                                                                        //定义holder

        public ImageView imageView;                                                                 //里面内容
        public TextView tv_Title,tv_Time,tv_Content;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {                         //返回每行样式

        ViewHolder holder=null ;
        if(convertView==null) {
            convertView = mLayoutInflator.inflate(R.layout.layout_list_item, null);           //inflator 里面传入布局，得到一个view
            holder = new ViewHolder();
            holder.imageView = convertView.findViewById(R.id.iv);
            holder.tv_Title = convertView.findViewById(R.id.tv_title);
            holder.tv_Time = convertView.findViewById(R.id.tv_time);
            holder.tv_Content = convertView.findViewById(R.id.tv_content);
            convertView.setTag(holder);


        }else {
            holder= (ViewHolder) convertView.getTag();                                              //重新获取viewholder
        }
        holder.tv_Title.setText("This is the caption");
        holder.tv_Time.setText("2020-10-31");
        holder.tv_Content.setText("this is our content");
        Glide.with(mContext).load("https://bilder.t-online.de/b/88/04/90/46/id_88049046/610/tid_da/grillen-einige-lebensmittel-koennen-durch-das-grillen-zur-gefahr-fuer-die-gesundheit-werden-symbolbild-.jpg").into(holder.imageView);

        Log.d("news","it runs in getView");
        return convertView;
    }
}
