package com.example.debuggertest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.debuggertest.button.ButtonFunctionActivity;
import com.example.debuggertest.datastorage.DataStorageActivity;

public class MainActivity extends AppCompatActivity {
    EditText pas, usr;

    Button button_submit,new_page,dialog, mBtnFunction,mBtnData;
    public Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);                                                     //打开布置文件，用地址

        usr = (EditText) findViewById(R.id.editText2);
        pas = (EditText) findViewById(R.id.editText);

        button_submit = (Button)findViewById(R.id.button);
        new_page=(Button)findViewById(R.id.new_page);
        dialog=findViewById(R.id.new_dialog);

        button_submit.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                         String user = usr.getText().toString();
                         String pass = pas.getText().toString();

                         Background background = new Background(getApplicationContext());
                         background.execute(user, pass);
                     }
        });

        new_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,NewPageActivity.class);   //jump to new activity
                startActivity(intent);
                Toast.makeText(getApplicationContext(),"You are opening a new page",Toast.LENGTH_SHORT).show();
            }
        });

        dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),DialogActivity.class);   //jump to new activity
                startActivity(intent);
                Toast.makeText(MainActivity.this,"You are opening a dialogActi",Toast.LENGTH_SHORT).show();
            }
        });

        mBtnFunction=findViewById(R.id.new_button);
        mBtnFunction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, ButtonFunctionActivity.class);
                startActivity(intent);
            }
        });

        mBtnData=findViewById(R.id.btn_data);
        mBtnData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, DataStorageActivity.class);
                startActivity(intent);
            }
        });

    }







    //    public void loginBtn(View view) {
//        String user = usr.getText().toString();
//        String pass = pas.getText().toString();
//
//        Background background = new Background(this);
//        background.execute(user, pass);
//
//    }
}