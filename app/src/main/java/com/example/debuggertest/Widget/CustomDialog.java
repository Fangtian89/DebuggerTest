package com.example.debuggertest.Widget;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Point;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.debuggertest.R;


public class CustomDialog extends Dialog implements View.OnClickListener {

    private TextView mTvTitle,mTvMessage,mTvCancel,mTvConfirm;
    private String title,message,cancel,confirm;
    private IOnCancelListener cancelListener;                                       //只定义，不分配
    private IOnConfirmListener confirmListener;                                     //只定义，不分配

    public CustomDialog( Context context) {
        super(context);
    }

    public CustomDialog( Context context, int themeResId) {             //未用到这个constructor
        super(context, themeResId);
    }

    public CustomDialog( Context context, boolean cancelable, OnCancelListener cancelListener) {           //未用到这个constructor
        super(context, cancelable, cancelListener);
    }

    public CustomDialog setTitle(String title) {                                                            //SEtter
        this.title = title;
        return this;
    }

    public CustomDialog setMessage(String message) {                                                        //SEtter
        this.message = message;
        return this;
    }

    public CustomDialog setCancel(String cancel,IOnCancelListener listener) {                               //SEtter
        this.cancel = cancel;
        this.cancelListener=listener;
        return this;
    }

    public CustomDialog setConfirm(String confirm,IOnConfirmListener listener) {                            //SEtter
        this.confirm = confirm;
        this.confirmListener=listener;
        return this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_custom_dialog);
//------------------------------------------------------------------------------------------------
        WindowManager m = getWindow().getWindowManager();                                                               //设置宽度 方法
        Display d = m.getDefaultDisplay();
        WindowManager.LayoutParams p = getWindow().getAttributes();
        Point size = new Point();
        d.getSize(size);
        p.width = (int)(size.x * 0.8);
        getWindow().setAttributes(p);
//------------------------------------------------------------------------------------------------
        mTvTitle=findViewById(R.id.tv_title);
        mTvMessage=findViewById(R.id.tv_message);
        mTvCancel=findViewById(R.id.tv_quit);
        mTvConfirm=findViewById(R.id.tv_confirm);

        if (TextUtils.isEmpty(title)){
            mTvTitle.setText(title);
        }
        if (TextUtils.isEmpty(message)){
            mTvMessage.setText(message);
        }
        if (TextUtils.isEmpty(cancel)){
            mTvCancel.setText(cancel);
        }
        if (TextUtils.isEmpty(confirm)){
            mTvConfirm.setText(confirm);
        }

        mTvCancel.setOnClickListener(this);
        mTvConfirm.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_quit:
                if(cancelListener!=null){
                    cancelListener.onCancel(this);
                    dismiss();                                                              //是Dialog 里的一个方法

                }
                break;
            case R.id.tv_confirm:
                if(confirmListener!=null){
                    confirmListener.onConfirm(this);
                    dismiss();
                }
                break;
        }
    }

    public interface IOnCancelListener{                                 //自己定义一个接口
        void onCancel(CustomDialog dialog);                             //Abstract class
    }
    public interface IOnConfirmListener{                                 //自己定义一个接口
        void onConfirm(CustomDialog dialog);                              //Abstract class
    }
}
