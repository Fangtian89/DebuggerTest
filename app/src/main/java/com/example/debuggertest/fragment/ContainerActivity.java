package com.example.debuggertest.fragment;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.debuggertest.R;

public class ContainerActivity extends AppCompatActivity implements AFragment.IOnMessageClick {
private AFragment aFragment;
private BFragment bFragment;
private Button mBtnChange;
private TextView mTvTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);
        aFragment=AFragment.newInstanz("this is the A Fragment parameter from self-built so called 'constructor' ");

        //自动调 A fragment                                                    //把AFragment 添加到Activity 中，记得调用comm 方法,实例化AFragment, 用add 添加

        FragmentManager fragmentManager=getSupportFragmentManager();
        final FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fl_container,aFragment).addToBackStack(null);      //把aFragment 放入指定的 目标，在此为activity_container 里的fl_container
        fragmentTransaction.commitAllowingStateLoss();

        mBtnChange=findViewById(R.id.fl_change);
        mBtnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {                       //换B
                if(bFragment==null){                                //你判断bFragment 是否为空
                    bFragment=new BFragment();
                }
                FragmentManager fragmentManager=getSupportFragmentManager();  //要重新 commit 是需要重新Start 一个新 Transaction.
                final FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fl_container,bFragment);
                fragmentTransaction.commitAllowingStateLoss();
            }
        });
    }


    @Override
    public void onClick(String text) {
        mTvTitle=findViewById(R.id.tv_title);
        mTvTitle.setText(text);
    }

}
