package com.example.debuggertest.recyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;

import com.example.debuggertest.R;

public class HorRecyclerViewActivity extends AppCompatActivity {
    private RecyclerView mRvHor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hor_recycler_view);
        mRvHor=findViewById(R.id.rv_hor);
        mRvHor.setLayoutManager(new LinearLayoutManager(HorRecyclerViewActivity.this,LinearLayoutManager.HORIZONTAL,false));
//        LinearLayoutManager layoutmanager=new LinearLayoutManager(HorRecyclerViewActivity.this );
//        layoutmanager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRvHor.addItemDecoration(new Hor_Decoration());
        mRvHor.setAdapter(new HorAdapter(HorRecyclerViewActivity.this));
    }
    class Hor_Decoration extends RecyclerView.ItemDecoration{
        @Override
        public void getItemOffsets( Rect outRect,  View view,  RecyclerView parent,  RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.set(0,0,getResources().getDimensionPixelOffset(R.dimen.dividerHeight),0);
        }
    }
}
