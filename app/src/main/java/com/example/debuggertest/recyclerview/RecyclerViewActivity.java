package com.example.debuggertest.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import com.example.debuggertest.R;

public class RecyclerViewActivity extends AppCompatActivity {

    private Button mBtnLinear,mBtnHor,mBtnGrid,mBtnPu,mBtnMulti;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        mBtnLinear=findViewById(R.id.btn_liner);
        mBtnLinear.setOnClickListener(new View.OnClickListener() {         //点击进入一个 listview, LinearRecyclerViewActivity
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecyclerViewActivity.this, LinearRecyclerViewActivity.class); //进入RecyclerView 页面
                startActivity(intent);
            }
        });

        mBtnHor=findViewById(R.id.btn_hor);
        mBtnHor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecyclerViewActivity.this, HorRecyclerViewActivity.class); //进入RecyclerView 页面
                startActivity(intent);
            }
        });

        mBtnGrid=findViewById(R.id.btn_grid);
        mBtnGrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RecyclerViewActivity.this,GridRecyclerViewActivity.class);//进入gridview  页面
                startActivity(intent);
            }
        });

        mBtnPu=findViewById(R.id.btn_pu);
        mBtnPu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RecyclerViewActivity.this,PuRecyclerViewActivity.class);
                startActivity(intent);
            }
        });

        mBtnMulti=findViewById(R.id.btn_multi);
        mBtnMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RecyclerViewActivity.this,LinearMultiHolderRecyclerViewActivity.class);
                startActivity(intent);
            }
        });



    }
}
