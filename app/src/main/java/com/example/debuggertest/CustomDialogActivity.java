package com.example.debuggertest;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.debuggertest.R;
import com.example.debuggertest.Widget.CustomDialog;
import com.example.debuggertest.until.ToastUtil;

public class CustomDialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_dialog);

        CustomDialog customDialog=new CustomDialog(CustomDialogActivity.this);
        customDialog.setTitle("这是个提示").setMessage("确认删除此项？")
                .setCancel("取消", new CustomDialog.IOnCancelListener() {
            @Override
            public void onCancel(CustomDialog dialog) {
                ToastUtil.showMsg(getApplicationContext(),"cancel...");
            }
        }).setConfirm("确定", new CustomDialog.IOnConfirmListener() {
            @Override
            public void onConfirm(CustomDialog dialog) {
                ToastUtil.showMsg(getApplicationContext(),"confirm...");
            }
        }).show();
    }
}
