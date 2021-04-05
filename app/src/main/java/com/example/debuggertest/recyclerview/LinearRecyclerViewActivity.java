package com.example.debuggertest.recyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.debuggertest.R;

public class  LinearRecyclerViewActivity extends AppCompatActivity {                                 //本页主程序
    private RecyclerView mRvMain;                                                                   //模板地址

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_recycler_view);                                     //xml 地址
        mRvMain=findViewById(R.id.rv_main);                                                         //放模板//模板地址
        mRvMain.setLayoutManager(new LinearLayoutManager(LinearRecyclerViewActivity.this)); //可以 manage 一个  Grid layout manager, Staggered Layout
        mRvMain.addItemDecoration(new MyDecoration());                                     //
        mRvMain.setAdapter(new LinearAdapter(this, new LinearAdapter.OnItemClickListener() {//新建了一个类里面的匿名内部类OnItemClickListener()，回调接口方法
            @Override
            public void onClick(int pos) {
                Toast.makeText(LinearRecyclerViewActivity.this,"click..."+pos,Toast.LENGTH_SHORT).show();
            }
        }));

    }

    class MyDecoration extends RecyclerView.ItemDecoration{                                         //装饰，下面加横线
        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.set(0,0,0,getResources().getDimensionPixelOffset(R.dimen.dividerHeight));
        }
    }
}
