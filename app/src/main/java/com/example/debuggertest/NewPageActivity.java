package com.example.debuggertest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.debuggertest.fragment.ContainerActivity;
import com.example.debuggertest.jump.AActivity;
import com.example.debuggertest.listview.ListViewActivity;
import com.example.debuggertest.recyclerview.LinearRecyclerViewActivity;
import com.example.debuggertest.recyclerview.RecyclerViewActivity;

public class NewPageActivity extends AppCompatActivity {
    Button mBtnTextView,mBtnButton,mBtnEditText,mBtnRadioButton,mBtnCheckBox,
            mBtnImageView,mBtnListView,mBtnRecyclerView,mJump,mWebView,mBtnToast,mBtnProgress,mBtnPopWindow,mBtnFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_page);                                                 //打开布置文件

        mBtnTextView=(Button)findViewById(R.id.btn_textview);
        mBtnButton=(Button)findViewById(R.id.btn_button);
        mBtnEditText=(Button)findViewById(R.id.btn_edittext);
        mBtnRadioButton=(Button)findViewById(R.id.btn_radiobutton);
        mBtnCheckBox=(Button)findViewById(R.id.btn_checkbox);
        mBtnImageView=findViewById(R.id.btn_imageview);
        mBtnListView=findViewById(R.id.btn_listview);
        mBtnRecyclerView=findViewById(R.id.btn_btnrecyclerview);
        mJump=findViewById(R.id.btn_jump);
        mWebView=findViewById(R.id.btn_webview);
        mBtnToast=findViewById(R.id.btn_toast);
        mBtnProgress=findViewById(R.id.btn_progress);
        mBtnPopWindow=findViewById(R.id.btn_popup);
        mBtnFragment=findViewById(R.id.btn_fragment);


        Click click=new Click();

        mBtnTextView.setOnClickListener(click);
        Log.d( "onCreate: break it?","no");

        mBtnButton.setOnClickListener(click);
        Log.d( "onCreate: break it?","no");

        mBtnEditText.setOnClickListener(click);
        Log.d( "onCreate: break it?","no");

        mBtnRadioButton.setOnClickListener(click);
        Log.d( "onCreate: break it?","no");

        mBtnCheckBox.setOnClickListener(click);
        Log.d( "onCreate: break it?","no");

        mBtnImageView.setOnClickListener(click);
        Log.d( "onCreate: break it?","no");

        mBtnListView.setOnClickListener(click);
        Log.d( "onCreate: break it?","no");

        mBtnRecyclerView.setOnClickListener(click);
        Log.d( "onCreate: break it?","no");

        mJump.setOnClickListener(click);

        mWebView.setOnClickListener(click);

        mBtnToast.setOnClickListener(click);

        mBtnProgress.setOnClickListener(click);

        mBtnPopWindow.setOnClickListener(click);

        mBtnFragment.setOnClickListener(click);
    }

    private class Click implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Intent intent=null;
            switch(v.getId()){
                case R.id.btn_textview:
                    Toast.makeText(NewPageActivity.this,"Button 1 is on click",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btn_button:
                    Toast.makeText(NewPageActivity.this,"Button 2 is on click",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btn_edittext:
                    Toast.makeText(NewPageActivity.this,"Button 3 is on click",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btn_radiobutton:
                    intent=new Intent(NewPageActivity.this,RadioButtonActivity.class);
                    Toast.makeText(NewPageActivity.this,"Radio Button is on click",Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                    break;
                case R.id.btn_checkbox:
                    intent=new Intent(NewPageActivity.this,CheckBoxActivity.class);
                    startActivity(intent);
                    Toast.makeText(NewPageActivity.this,"please choose player mode",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btn_imageview:
                    intent=new Intent(NewPageActivity.this,ImageViewActivity.class);
                    startActivity(intent);
                    Toast.makeText(NewPageActivity.this,"ImageView Activity mode opening",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btn_listview:
                    intent=new Intent(NewPageActivity.this, ListViewActivity.class);
                    startActivity(intent);
                    Toast.makeText(NewPageActivity.this,"ListView Activity mode opening",Toast.LENGTH_SHORT).show();
                    break;

                case R.id.btn_btnrecyclerview:
                    intent=new Intent(NewPageActivity.this, RecyclerViewActivity.class);
                    startActivity(intent);
                    Toast.makeText(NewPageActivity.this,"LinearRecycleView Activity mode opening",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btn_jump:
                    intent=new Intent(NewPageActivity.this, AActivity.class);
                    startActivity(intent);
                    break;
                case R.id.btn_webview:
                    intent=new Intent(NewPageActivity.this, WebViewActivity.class);
                    startActivity(intent);
                    break;
                case R.id.btn_toast:
                    intent=new Intent(NewPageActivity.this, ToastActivity.class);
                    startActivity(intent);
                    break;
                case R.id.btn_progress:
                    intent=new Intent(NewPageActivity.this, ProgressActivity.class);
                    startActivity(intent);
                    break;
                case R.id.btn_popup:
                    intent=new Intent(NewPageActivity.this, PopupWindowActivity.class);
                    startActivity(intent);
                    break;
                case R.id.btn_fragment:
                    intent=new Intent(NewPageActivity.this, ContainerActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("news","onStart is running");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("news","onResume is running");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("news","onPause is running");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("news","onStop is running");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("news","onDestroy is running");
    }
}


