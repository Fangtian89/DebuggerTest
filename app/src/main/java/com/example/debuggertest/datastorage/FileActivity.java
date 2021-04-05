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

    private void save(String content)  {                          //用来存储数据在 intern
        FileOutputStream fileOutputStream=null;                   //定义String 时，最好先赋值 null
        BufferedWriter writer=null;

        try {
            fileOutputStream=openFileOutput("text.txt",MODE_PRIVATE);//没有就建立新的, openFileOutput 是Context 提供的一个方法，2个参数不可以写路径
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

    private String read()  {                                      //用来读取数据 从intern
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

    //--------------------------Extern 存储;一般在SD 卡上--------------------------------------------------------------------------------------------------------------

    private void saveExtern(String content){                                             //存储到SD 卡， 可能用不了

        FileOutputStream fileOutputStream=null;
        File dir=new File(Environment.getExternalStorageDirectory(),"workspace");  //先要设定 directory, 在这里新建了一个文件夹
        BufferedWriter writer=null;

        if(!dir.exists()){
            dir.mkdir();
        }
        File file=new File(dir,"workbook_Kuang.txt"   );                            //再创建文件
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
