package com.example.debuggertest.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import com.example.debuggertest.R;
public class LinearMultiHolderRecyclerViewActivity extends AppCompatActivity {
    private RecyclerView mRvMulti;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_multi_holder_recycler_view);
        mRvMulti=findViewById(R.id.tv_multi);
        mRvMulti.setLayoutManager(new LinearLayoutManager(LinearMultiHolderRecyclerViewActivity.this));
        mRvMulti.setAdapter(new LinearMultiHolderAdapter(this));
    }
}
