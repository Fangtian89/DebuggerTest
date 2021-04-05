package com.example.debuggertest.jump;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.example.debuggertest.R;
import androidx.appcompat.app.AppCompatActivity;

public class BActivity extends AppCompatActivity {
    private TextView textView;
    private Button mButton;
    private EditText mName;
    private EditText mPass;
    private Button mSubmit;
    private Button mCancel;
    private Button mBtnJumpB;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        textView=findViewById(R.id.tv_titlejump);


        Log.d("!!!BActivity","-----onCreate-----");
        Log.d("!!!BActivity", "taskid: "+getTaskId()+" ,hash: "+hashCode());
        logtaskName();
//------------------------------------------------------------------------------//接受数据
        Bundle bundle=getIntent().getExtras();
        String content_1=bundle.getString("number_1");
        int content_2=bundle.getInt("number_2");
        textView.setText(content_1+" "+content_2);
//------------------------------------------------------------------------------//返回数据1, "come back to A"
        mButton=findViewById(R.id.tv_buttonCB);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                Bundle bundle=new Bundle();
                bundle.putString("comeBack","I am back");           //放数据
                intent.putExtras(bundle);
                setResult(RESULT_OK,intent);
                finish();                                           //当前页面关闭
            }
        });
//------------------------------------------------------------------------------//返回数据2,"submit"
        mSubmit=findViewById(R.id.tv_buttonSubmit);
        mName=findViewById(R.id.tv_name);
        mPass=findViewById(R.id.tv_password);

        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                Bundle bundle=new Bundle();
                bundle.putString("Name",mName.getText().toString());
                bundle.putString("Pass",mPass.getText().toString());
                intent.putExtras(bundle);
                setResult(RESULT_OK,intent);
                finish();                                           //当前页面关闭
            }
        });

        mCancel=findViewById(R.id.tv_buttoncancel);
        mCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {                           //Cancel button
                Intent intent=new Intent();
                Bundle bundle=new Bundle();
                bundle.putInt("Name",0);
                bundle.putInt("Pass",0);
                intent.putExtras(bundle);
                setResult(RESULT_CANCELED,intent);
                finish();
            }
        });

        mBtnJumpB=findViewById(R.id.tv_jumpTBB);
        mBtnJumpB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(BActivity.this,BActivity.class);
                Bundle bundle=new Bundle();
                bundle.putString("number_1","hi");
                bundle.putInt("number_2",888);
                intent.putExtras(bundle);
                //startActivity(intent);
                startActivityForResult(intent,0);
            }
        });
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d("!!!BActivity","-----onNewIntent-----");
        Log.d("!!!BActivity", "taskid: "+getTaskId()+" ,hash: "+hashCode());
        logtaskName();
    }

    private void logtaskName() {
        try {
            ActivityInfo info=getPackageManager().getActivityInfo(getComponentName(), PackageManager.GET_META_DATA);
            Log.d("!!!BActivity",info.taskAffinity);                   //taskAffinity 任务栈名称
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

    }
}
