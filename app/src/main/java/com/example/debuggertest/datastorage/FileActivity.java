package com.example.debuggertest.datastorage;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.debuggertest.R;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class FileActivity extends AppCompatActivity {
private Button mBtnSave,mBtnShow,mBtnSaveExt,mBtnShowExt;
private EditText mEtName,mEtNameExt;
private TextView mTvContent,mTvContentExt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);

        mBtnSave=findViewById(R.id.btn_save);
        mBtnShow=findViewById(R.id.btn_show);
        mEtName=findViewById(R.id.et_name);
        mTvContent=findViewById(R.id.tv_content);

        mBtnSaveExt = findViewById(R.id.btn_saveex);
        mBtnShowExt = findViewById(R.id.btn_showex);
        mEtNameExt = findViewById(R.id.et_nameex);
        mTvContentExt = findViewById(R.id.tv_contentex);

        mBtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save(mEtName.getText().toString());
            }
        });

        mBtnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTvContent.setText(read());
            }
        });

        mBtnSaveExt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveExtern(mEtNameExt.getText().toString());
            }
        });

        mBtnShowExt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTvContentExt.setText(readExtern());
            }
        });
    }

    private void save(String content)  {                          //????????????????????? intern
        FileOutputStream fileOutputStream=null;                   //??????String ????????????????????? null
        BufferedWriter writer=null;

        try {
            fileOutputStream=openFileOutput("text.txt",MODE_PRIVATE);//?????????????????????, openFileOutput ???Context ????????????????????????2???????????????????????????
            writer=new BufferedWriter(new OutputStreamWriter(fileOutputStream));
            writer.write(content);
        }  catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(writer!=null){
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private String read()  {                                      //?????????????????? ???intern
        FileInputStream fileInputStream = null;
        BufferedReader reader=null;
        StringBuilder content=new StringBuilder();

        try {
            fileInputStream = openFileInput("text.txt");
            reader=new BufferedReader(new InputStreamReader(fileInputStream));
            String temp=reader.readLine();
            String temp2=reader.readLine();
            return temp;
        }  catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(reader!=null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    //--------------------------Extern ??????;?????????SD ??????--------------------------------------------------------------------------------------------------------------

    private void saveExtern(String content){                                             //?????????SD ?????? ???????????????

        FileOutputStream fileOutputStream=null;
        File dir=new File(Environment.getExternalStorageDirectory(),"workspace");  //???????????? directory, ?????????????????????????????????
        BufferedWriter writer=null;

        if(!dir.exists()){
            dir.mkdir();
        }
        File file=new File(dir,"workbook_Kuang.txt"   );                            //???????????????
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                Log.e("Error", e.getMessage() );
            }
        }
        try {
            fileOutputStream=openFileOutput("workbook_Kuang.txt",MODE_PRIVATE);
            writer=new BufferedWriter(new OutputStreamWriter(fileOutputStream));
            writer.write(content);
                    }  catch (IOException e) {
                        e.printStackTrace();
                    }finally {
            if(writer!=null){
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private String readExtern() {
        FileInputStream fileInputStream=null;
        BufferedReader reader=null;
        File file=new File(Environment.getExternalStorageDirectory().getAbsolutePath()+File.separator+"workspace","workbook_Kuang.txt");
        try {
            fileInputStream=new FileInputStream(file);
            reader=new BufferedReader(new InputStreamReader(fileInputStream));
            if(reader.readLine()!=null){
                return reader.readLine();
            }
        }  catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(reader!=null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }}
        return null;
    }

}
