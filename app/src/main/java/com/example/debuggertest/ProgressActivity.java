package com.example.debuggertest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.debuggertest.R;
import com.example.debuggertest.until.ToastUtil;
                                                                                //主要介绍2中progress, progressBar , ProgressDialog
public class ProgressActivity extends AppCompatActivity {
    private ProgressBar mPb3;                                                   //d对一个progressbar jingx
    private Button mBtnStart,mBtnProgressDialog1,mBtnProgressDialog2,mBtnProgressDialog3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);
        mPb3 = findViewById(R.id.pb3);
        mPb3.setProgress(30);
        mBtnStart = findViewById(R.id.btn_start);
        mBtnProgressDialog1=findViewById(R.id.btn_progress_dialog1);
        mBtnProgressDialog2=findViewById(R.id.btn_progress_dialog2);
        mBtnProgressDialog3=findViewById(R.id.btn_progress_dialog3);

        mBtnStart.setOnClickListener(new View.OnClickListener() {                                       //progress bar 实验一种加载方法
            @Override
            public void onClick(View v) {
                handler.sendEmptyMessage(0);
            }
        });
//---------------------------------------------------------------------------------------------------------------
        mBtnProgressDialog1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog progressDialog=new ProgressDialog(ProgressActivity.this);        //会生成一个progressDialog 的对话框,不断的加载
                progressDialog.setTitle("zur Info");
                progressDialog.setMessage("on loading");
                progressDialog.setCancelable(false);                                                    // 取消不了，必须等加载完成,k可以用dismiss方法，有条件的取消掉
                progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {             //主动离开时，取消progressbar
                    @Override
                    public void onCancel(DialogInterface dialog) {                                          // 重要，新知识，OnCancelListener
                        ToastUtil.showMsg(getApplicationContext(),"cancel it");
                    }
                });
                progressDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {           //若用dismiss 方法，则会取代OnCancel，取消progressbar
                    @Override
                    public void onDismiss(DialogInterface dialog) {                                         // 重要，新知识，OnDismissListener
                        ToastUtil.showMsg(getApplicationContext(),"dismiss it");
                    }
                });

                progressDialog.show();
            }
        });
//---------------------------------------------------------------------------------------------------------------
        mBtnProgressDialog2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog progressDialog=new ProgressDialog(ProgressActivity.this);        //会生成一个progressDialog 的对话框
                progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);                       //以进度条的方式, 及progressbar
                progressDialog.setTitle("zur Info");
                progressDialog.setMessage("Downloading...");
                progressDialog.setButton(DialogInterface.BUTTON_POSITIVE, "sehr gut", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ToastUtil.showMsg(getApplicationContext(),"goooood!");
                    }
                });
                progressDialog.show();
            }
        });
//---------------------------------------------------------------------------------------------------------------
        mBtnProgressDialog3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog progressDialog=new ProgressDialog(ProgressActivity.this);        //会生成一个progressDialog 的对话框
                progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);                       //以进度条的方式
                progressDialog.setTitle("zur Info");
                progressDialog.setMessage("Downloading...");
                progressDialog.setButton(DialogInterface.BUTTON_POSITIVE, "very good!!!", new DialogInterface.OnClickListener() { //可以像Dialogactiviy 那样加 确认(positve)，取消(negative)， 等等
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    ToastUtil.showMsg(getApplicationContext(),"das ist eine gute Antwort");
                }
                });
                progressDialog.show();
            }
        });
    }
    final Handler handler=new Handler(){                                          //handler见事件的处理
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(mPb3.getProgress()<100){
                handler.postDelayed(runnable,500);
            }else{
                ToastUtil.showMsg(getApplicationContext(),"finish loading...");
            }
        }
    };

    Runnable runnable=new Runnable() {
        @Override
        public void run() {
            mPb3.setProgress(mPb3.getProgress()+5);
            handler.sendEmptyMessage(0);
        }
    };



    }

