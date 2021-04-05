package com.example.debuggertest.datastorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.debuggertest.R;

public class DataStorageActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnSharedPreferences,mBtnFile;
    private Intent intent=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_storage);
        mBtnSharedPreferences=findViewById(R.id.btn_sharedpreferences);
        mBtnFile=findViewById(R.id.btn_file);
        mBtnSharedPreferences.setOnClickListener(this);
        mBtnFile.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
switch (v.getId()){
    case R.id.btn_sharedpreferences:
        intent=new Intent(DataStorageActivity.this,SharedPreferencesActivity.class);
        startActivity(intent);
        break;
    case R.id.btn_file:
        intent=new Intent(DataStorageActivity.this,FileActivity.class);
        startActivity(intent);
        break;
}
    }
}
