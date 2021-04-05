package com.example.debuggertest;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.debuggertest.R;
import com.example.debuggertest.until.ToastUtil;

public class HandlerActivity extends AppCompatActivity {
    private Handler mHandler,mHandler_2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);

        //--------------------最简单一种常见用法， 延时跳转------------------------------------------------
        mHandler=new Handler();
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(HandlerActivity.this,NewPageActivity.class);
                startActivity(intent);
            }
        },3000);
//--------------------------第二种常见用法------------------------------------------------------------
        mHandler_2=new Handler(){
            @Override
            public void handleMessage(@NonNull Message msg) {               //处理消息
                super.handleMessage(msg);
                switch ((msg.what)){
                    case 1:
                        ToastUtil.showMsg(HandlerActivity.this,"1 is revoked from another thread");
                }
            }
        };

        new Thread(){
            @Override
            public void run() {
                super.run();
                Message message=new Message();
                message.what=1;
                mHandler_2.sendMessage(message );//   把message 放入 handler
            }
        }.start();
    }
//---------------------------------------------------------------------------------------------------------------------
}
