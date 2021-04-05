package com.example.debuggertest.recyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.debuggertest.R;
public class PuRecyclerViewActivity extends AppCompatActivity {
    private RecyclerView mRvPu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pu_recycler_view);
        mRvPu=(RecyclerView) findViewById(R.id.rv_pu);
        mRvPu.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        mRvPu.addItemDecoration(new PuDecoration());
        mRvPu.setAdapter(new PuAdapter(this));
    }

    class PuDecoration extends RecyclerView.ItemDecoration{
        @Override
        public void getItemOffsets(Rect outRect, View view,  RecyclerView parent,  RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.set(1,1,1,1);
        }
    }
}
