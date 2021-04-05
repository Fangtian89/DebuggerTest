package com.example.debuggertest.button;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.debuggertest.HandlerActivity;
import com.example.debuggertest.R;
import com.example.debuggertest.Widget.MyButton;
import com.example.debuggertest.until.ToastUtil;

public class ButtonFunctionActivity extends AppCompatActivity implements View.OnClickListener {
private Button mBtn_1,mBtn_2,mBtn_3,mBtn_4,mBtn_5,mBtn_6,mBtn_8;
private MyButton mBtn_7;
private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {                                // 三大要素，事件源，事件，listener
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_function);

        mBtn_1=findViewById(R.id.btn_method_1);
        mBtn_2=findViewById(R.id.btn_method_2);
        mBtn_3=findViewById(R.id.btn_method_3);
        mBtn_4=findViewById(R.id.btn_method_4);
        mBtn_5=findViewById(R.id.btn_method_5);
        mBtn_6=findViewById(R.id.btn_method_6);
        mBtn_7=findViewById(R.id.btn_method_7);
        //------------------第一种方法，通过内部类，适合多个同样功能的button--------------------------------------------------
        BtnFunction_1 click=new BtnFunction_1();
        mBtn_1.setOnClickListener(click);

        //-------------------第二种方法，通过匿名内部类，其实就是回调OnClickListner 接口的方法----------------------------------------------------------------------

        mBtn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showMsg(ButtonFunctionActivity.this,"通过匿名内部类");
            }
        });

        //-------------------第三种方法，通过事件源类，即ButtonFunctionActivity extends AppCompatActivity implements View.OnClickListener-----------
        mBtn_3.setOnClickListener(ButtonFunctionActivity.this);

        //-------------------第四种方法，通过外部类----------------------------------------------------------------------
        mBtn_4.setOnClickListener(new ButtonExternClickListener(ButtonFunctionActivity.this));

        //-------------------Button 的其他点击 事件，第6个按钮，OnTouchListener---------------------------------------------------------------------
        mBtn_6.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        ToastUtil.showMsg(ButtonFunctionActivity.this,"向下按动");
                    case MotionEvent.ACTION_UP:
                        ToastUtil.showMsg(ButtonFunctionActivity.this,"向上抬起");
//                    case MotionEvent.ACTION_HOVER_ENTER:
//                        ToastUtil.showMsg(ButtonFunctionActivity.this,"Hover enter");
                        // 等等
                }
                return false;
            }
        });
        //-------------------第7个按钮，一共用了3中方法 1，在widget/MyButton 中定义 extend Button,重新复写方法，在manifest 里面定义自己的button，
        // ------2，在本页最下面重写 onTouchEvent, 3, 直接在button 上写listener--, 最终监听器 方法 3 是最早发生的-------------------------------------------------------------------------------
        mBtn_7.setOnTouchListener(new View.OnTouchListener() {              //监听优先于回调，优先于button activity
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        Log.d("Listener on Touch", "onTouchEvent: Button 7 ");
                        break;

                }
                return false; //return true 则功能不会向外传播，其他回调，会activity 会继续处理。见 Android 教学5.2
            }
        });

        mBtn_8=findViewById(R.id.btn_method_8);
        mBtn_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ButtonFunctionActivity.this, HandlerActivity.class );
                startActivity(intent);

            }
        });
    }


    @Override
    public void onClick(View v) {   //第三种方法，通过事件源类，即ButtonFunctionActivity extends AppCompatActivity implements View.OnClickListener----
        //也可以用 switch， case 方法
        switch(v.getId()) {
            case R.id.btn_method_3:
                ToastUtil.showMsg(ButtonFunctionActivity.this,"第三种方法通过所在事件源类实现");
                break;
        }
    }

    public class BtnFunction_1 implements View.OnClickListener{             //第一种方法，通过内部类，适合多个同样功能的button
        @Override
        public void onClick(View v) {
            switch(v.getId()) {
                case R.id.btn_method_1:
                    ToastUtil.showMsg(ButtonFunctionActivity.this,"通过内部类实现");
                    break;
            }
        }
    }

    public void shows(View v){                                       //在布局xml文件中，定义onClick=show 方法,这里方法名字可以被xml 访问
        //也可以用 switch， case 方法
        switch (v.getId()){
            case R.id.btn_method_5:
                ToastUtil.showMsg(getApplicationContext(),"第五种方法,布局文件中onClick");
            case R.id.btn_method_4:
                ToastUtil.showMsg(getApplicationContext(),"再一次种方法,布局文件中onClick");
                break;
        }

    }
    //-------------------第7个按钮,事件------------Button Activity--------------------
    @Override
    public boolean onTouchEvent(MotionEvent event) {            //回调myButton
         super.onTouchEvent(event);
         switch (event.getAction()){
             case MotionEvent.ACTION_DOWN:
                 Log.d("Activity ", "onTouchEvent: Action down Button 7");
                 break;
             case MotionEvent.ACTION_MOVE:
                 Log.d("Activity ", "onTouchEvent: Action move Button 7");
                 break;
             case MotionEvent.ACTION_UP:
                 Log.d("Activity ", "onTouchEvent: Action up Button 7");
         }
        return false;
    }



}
