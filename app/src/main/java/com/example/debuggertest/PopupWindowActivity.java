package com.example.debuggertest;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.debuggertest.R;
import com.example.debuggertest.until.ToastUtil;

public class PopupWindowActivity extends AppCompatActivity {
private Button mBtnPop;
private PopupWindow mPop;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_window);
        mBtnPop=this.findViewById(R.id.btn_pop);


        mBtnPop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view= getLayoutInflater().inflate(R.layout.layout_pop,null);
                final TextView textView=view.findViewById(R.id.tv_good);

                textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //mPop.dismiss();                                                           //关掉popup
                        //do sth

                        mBtnPop.setText("already clicked");
                        textView.setText("ja");
                        ToastUtil.showMsg(getApplicationContext(),"ok it is good");
                    }
                });

                mPop=new PopupWindow(view, mBtnPop.getWidth(),ViewGroup.LayoutParams.WRAP_CONTENT);// (view,宽，高)
                mPop.setOutsideTouchable(true);                                                             //点击外面，dropdown 回收
                mPop.setFocusable(true);                                                                    //点击按钮，dropdown 回收
                //mPop.setAnimationStyle();也可以起到动画效果
                //mPop.showAtLocation();i试着用一下
                mPop.showAsDropDown(mBtnPop);                                                               //在这个button 的下面
            }
        });
    }
}
