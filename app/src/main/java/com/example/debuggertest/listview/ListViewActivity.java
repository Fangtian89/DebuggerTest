package com.example.debuggertest.listview;

import android.app.Activity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.debuggertest.R;

public class ListViewActivity extends Activity {                                                    //本页主程序
    private ListView mLv1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);                                                //load 的activity，模板 页面

        mLv1=(ListView) findViewById(R.id.lv_1);                                                    //指向这个模板元素
        mLv1.setAdapter(new MyListAdapter(ListViewActivity.this));                          //启动映射, 把 自定义的adapter 放进去, parameter是context

        mLv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {                         //匿名内部类，省掉一个实现类
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                position=position+1;
                Toast.makeText(ListViewActivity.this," 短点击 position:"+position,Toast.LENGTH_SHORT).show();

                //可以添加其他事件
            }
        });

       mLv1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
           @Override
           public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
               position=position+1;
               Toast.makeText(ListViewActivity.this,"长点击 position"+position,Toast.LENGTH_LONG).show();
               return true;                                                                         //长按处理结束，不需要其他处理
           }
       });

    }
}
