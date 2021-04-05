package com.example.debuggertest.Widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;

public class MyButton extends AppCompatButton {             //先被回调, MyButton 类，需要在 xml 文件中用它来定义 button

    public MyButton(@NonNull Context context) {
        super(context);
    } //constructor

    public MyButton(@NonNull Context context, @Nullable AttributeSet attrs) { //constructor
        super(context, attrs);
    }

    public MyButton(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) { //constructor
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {        //回调方法，最终 被 回调
      super.onTouchEvent(event);
      switch (event.getAction()){
//          case MotionEvent.ACTION_DOWN:
//              Log.d("Mybutton", "onTouchEvent: Action down Button 7 ");
//              break;
          case MotionEvent.ACTION_UP:
              Log.d("Mybutton ", "onTouchEvent: Action up Button 7");
              break;
      }

      return false;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.d("Mybutton", "dispatchTouchEvent: ");
        return super.dispatchTouchEvent(event);
    }
}
