
package com.example.debuggertest.jump;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.debuggertest.R;

public class AActivity extends AppCompatActivity {
    Button mBtnJump;
    Button mBtnJumpA;
    private TextView mName;
    private TextView mPass;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        mName=findViewById(R.id.textName);
        mPass=findViewById(R.id.textPass);
        mBtnJump=findViewById(R.id.jumpTb);
        mBtnJumpA=findViewById(R.id.jumpTA);
        Log.d("!!!AActivity","-----onCreate-----");
        Log.d("!!!AActivity", "taskid: "+getTaskId()+" ,hash: "+hashCode());
        logtaskName();
//-----------------------------------------------------------------------------------------
        mBtnJump.setOnClickListener(new View.OnClickListener() {                //显示显示方法 1
            @Override
            public void onClick(View v) {                                       //传递方法 1
                Intent intent=new Intent(AActivity.this,BActivity.class);//定义从哪到哪,给B
                Bundle bundle=new Bundle();
                bundle.putString("number_1","hallo");                           //把数据放入bundle里
                bundle.putInt("number_2",88);
                intent.putExtras(bundle);                                       //把bundle 放入intent 里，传给B的intent 里面包含这个bundle包。
//                startActivity(intent);                                        //start,直往b 传

                startActivityForResult(intent,0);                   //往b 传数据，再从b 传回数据, 就不用 startActivity 方法了
              Uri uri = intent.getData();
                //  startActivityForResult(intent,1);

//-----------------------------------------------------------------------------------------                                                                                //显示方法 2
//                Intent intent =new Intent();                                    //显示显示方法，传递方法 2
//                intent.setClass(AActivity.this, BActivity.class);
//                startActivity(intent);
//-----------------------------------------------------------------------------------------                                                                                //显示方法 2
//                Intent intent =new Intent();                                    //显示显示方法，传递方法 3
//                intent.setClassName(AActivity.this,"com.example.debuggertest.jump.BActivity");
//                startActivity(intent);
//-----------------------------------------------------------------------------------------                                                                                //显示方法 2
//                Intent intent =new Intent();                                    //显示显示方法，传递方法 4
//                intent.setComponent(new ComponentName(AActivity.this,"com.example.debuggertest.jump.BActivity"));
//                startActivity(intent);
//                startActivity(intent);
//-----------------------------------------------------------------------------------------
//                Intent intent=new Intent();                                         //隐形显示方法，要在action manifest 里改动
//                intent.setAction("xxxxxx");
//                startActivity(intent);
                                                                                    //                <intent-filter>
                                                                                    //                <action android:name="xxx" />
                                                                                    //
                                                                                    //                <category android:name="android.intent.category.DEFAULT" />
                                                                                    //            </intent-filter>
            }
        });

        mBtnJumpA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AActivity.this,AActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {             //用来接受返回数据
        super.onActivityResult(requestCode, resultCode, data);
        Toast.makeText(AActivity.this,data.getExtras().getString(requestCode+" "+resultCode),Toast.LENGTH_SHORT).show();
        Uri uri=data.getData();
        data.hasExtra("data");
        if (resultCode==RESULT_OK){

            mName.setText(data.getExtras().getString("Name"));
            mPass.setText(data.getExtras().getString("Pass"));
        }
        if(resultCode==RESULT_CANCELED){
            mName.setText(Integer.toString(data.getExtras().getInt("Name")));
            mPass.setText(String.valueOf(data.getExtras().getInt("Pass")));
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d("!!!AActivity","-----onNewIntent-----");
        Log.d("!!!AActivity", "taskid: "+getTaskId()+" ,hash: "+hashCode());
        logtaskName();

    }

    private void logtaskName() {
    try {
        ActivityInfo info=getPackageManager().getActivityInfo(getComponentName(), PackageManager.GET_META_DATA);
        Log.d("!!!AActivity",info.taskAffinity);                   //taskAffinity 任务栈名称
    } catch (PackageManager.NameNotFoundException e) {
        e.printStackTrace();
    }
}

}
