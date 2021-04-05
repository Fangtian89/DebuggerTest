package com.example.debuggertest.datastorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.debuggertest.R;

public class SharedPreferencesActivity extends AppCompatActivity {
private Button mBtnSave,mBtnShow;
private EditText mEtName;
private TextView mTvContent;

private SharedPreferences mSharedPreferences;               //用来存储
private SharedPreferences.Editor mEditor;                   //用来编写
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);

        mBtnSave=findViewById(R.id.btn_save);
        mBtnShow=findViewById(R.id.btn_show);
        mEtName=findViewById(R.id.et_name);
        mTvContent=findViewById(R.id.tv_content);

        mSharedPreferences=getSharedPreferences("mydata",MODE_PRIVATE);     //, getSharedpreference() 获得当前activity 的 preference. private 意思只有当前本应用可以读写
        mEditor=mSharedPreferences.edit();

        mBtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditor.putString("name",mEtName.getText().toString());           //放入数据
                //mEditor.commit();                                                 //提交，同步提交，也可以用apply(),内存上都是同时生效，磁盘上是异步，即在后台进行
                mEditor.apply();
            }
        });

        mBtnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTvContent.setText(mSharedPreferences.getString("name",""));
            }
        });


    }
}
