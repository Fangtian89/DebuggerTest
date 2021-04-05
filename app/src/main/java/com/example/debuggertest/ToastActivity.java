package com.example.debuggertest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.debuggertest.R;
import com.example.debuggertest.until.ToastUtil;

public class ToastActivity extends AppCompatActivity {
    private Button mBtnToast1,mBtnToast2,mBtnToast3,mBtnToast4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);

        mBtnToast1=findViewById(R.id.btn_toast_1);
        mBtnToast2=findViewById(R.id.btn_toast_2);
        mBtnToast3=findViewById(R.id.btn_toast_3);
        mBtnToast4=findViewById(R.id.btn_toast_4);
        OnClick click=new OnClick();

        mBtnToast1.setOnClickListener(click);
        mBtnToast2.setOnClickListener(click);
        mBtnToast3.setOnClickListener(click);
        mBtnToast4.setOnClickListener(click);
    }

    class OnClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_toast_1:
                    Toast.makeText(ToastActivity.this,"normal Toast",Toast.LENGTH_LONG).show();  //返回值是一个toast
                    break;
                case R.id.btn_toast_2:
                    Toast toast=Toast.makeText(getApplicationContext(),"in the center",Toast.LENGTH_LONG); //把Toast 放到另一个位置
                    toast.setGravity(Gravity.CENTER_VERTICAL,0,0);
                    toast.show();
                    //toast.cancel(); 有这个方法，zur Info
                    break;
                case R.id.btn_toast_3:                                                                          //
                    Toast toastCustom=new Toast(getApplicationContext());
                    View view=LayoutInflater.from(ToastActivity.this).inflate(R.layout.layout_toast,null);  //加载layout

                    ImageView imageview=(ImageView)findViewById(R.id.iv_toast);
                    TextView textView=findViewById(R.id.tv_toast);

                    imageview.setImageResource(R.drawable.sharp_directions_car_black_18dp);                     //地址不对
                    textView.setText("welcome here");

                    toastCustom.setView(view);
                    toastCustom.show();
                    break;

                case R.id.btn_toast_4:
                    ToastUtil.showMsg(getApplicationContext(),"用class 包装过的Toast"); //用类来实现的好处是，当多次点击时，message 只显示最后一次
                    break;
            }
        }
    }
}
