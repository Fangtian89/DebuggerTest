package com.example.debuggertest.button;

import android.app.Activity;
import android.view.View;

import com.example.debuggertest.until.ToastUtil;

public class ButtonExternClickListener implements View.OnClickListener { //第四种方法
    private Activity activity;
    public ButtonExternClickListener(Activity activity) {
        this.activity=activity;
    }

    @Override
    public void onClick(View v) {
        ToastUtil.showMsg(activity,"第四种方法，通过事件源类");
    }


}
