package com.example.debuggertest;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.debuggertest.R;
import com.example.debuggertest.until.ToastUtil;

public class DialogActivity extends AppCompatActivity {
    Button mBtnDialog1,mBtnDialog2,mBtnDialog3,mBtnDialog4,mBtnDialog5,mBtnDialog6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        OnClick onClick=new OnClick();
        mBtnDialog1=findViewById(R.id.btn_dialog1);
        mBtnDialog2=findViewById(R.id.btn_dialog2);
        mBtnDialog3=findViewById(R.id.btn_dialog3);
        mBtnDialog4=findViewById(R.id.btn_dialog4);
        mBtnDialog5=findViewById(R.id.btn_dialog5);
        mBtnDialog6=findViewById(R.id.btn_dialog6);

        mBtnDialog1.setOnClickListener(onClick);
        mBtnDialog2.setOnClickListener(onClick);
        mBtnDialog3.setOnClickListener(onClick);
        mBtnDialog4.setOnClickListener(onClick);
        mBtnDialog5.setOnClickListener(onClick);
        mBtnDialog6.setOnClickListener(onClick);
    }

    class OnClick implements View.OnClickListener{
        Intent intent=null;
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_dialog1:
                    AlertDialog.Builder builder=new AlertDialog.Builder((DialogActivity.this));                 //要用activity context,怎么样做 Alert
//                    builder.setTitle("please answer");
//                    builder.setMessage("was denkst du");
                    builder.setTitle("please answer").setMessage("was denkst du")                               //功能键
                            .setPositiveButton("sehr gut", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    ToastUtil.showMsg(DialogActivity.this,"you are good");
                                }
                            }).setNeutralButton("es geht", new DialogInterface.OnClickListener() {          //可以连起来写，因为返回值都是builder
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    ToastUtil.showMsg(getApplicationContext(),"bitte noch mal anschauen");
                                }
                            }).setNegativeButton("nicht gut", new DialogInterface.OnClickListener() {   //可以连起来写，因为返回值都是builder
                                @Override
                                public void onClick(DialogInterface dialog, int which) {                        //功能键
                                    ToastUtil.showMsg(getApplicationContext(),"bull shit");
                                }
                            }).setIcon(R.drawable.sharp_directions_car_black_18dp).show();                      //也可以加图标，可以连起来写，因为返回值都是builder
                            break;
                case R.id.btn_dialog2:                                                                          //无button 单选
                    final String[] array2=new String[]{"Männlich","Weiblich","keine Angabe"};
                    AlertDialog.Builder builder1=new AlertDialog.Builder(DialogActivity.this);          //要用activity context,
                        builder1.setTitle("Geschlecht auswählen").setItems(array2, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                ToastUtil.showMsg(DialogActivity.this,array2[which]);
                            }
                        }).show();
                    break;
                case R.id.btn_dialog3:                                                                  //有button单选
                    final String[] array3= new String[]{"Männlich","Weiblich","keine Angabe"};
                    AlertDialog.Builder builder3=new AlertDialog.Builder(DialogActivity.this);
                    builder3.setTitle("Geschlecht auswählen").setSingleChoiceItems(array3,0, new DialogInterface.OnClickListener() {    //单选
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ToastUtil.showMsg(getApplicationContext(),array3[which]);
                            dialog.dismiss();                                                           //取消对话框
                        }
                    }).setCancelable(false).show();                                                     //不选择无法取消
                    break;
                case R.id.btn_dialog4:                                                                  //多选,并加上confirm, quit 等功能键
                    final String[] array4= new String[]{"Singen","Tanzen","Coden","andere"};
                    boolean[] isSelected =new boolean[]{false,false,false,false};
                    AlertDialog.Builder builder4=new AlertDialog.Builder(DialogActivity.this);
                    builder4.setTitle("einen Hobby auswählen").setMultiChoiceItems(array4, isSelected, new DialogInterface.OnMultiChoiceClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                            ToastUtil.showMsg(getApplicationContext(),array4[which]+" : "+ isChecked);
                        }
                    }).setPositiveButton("Confirm", new DialogInterface.OnClickListener() {     //确定，可以连起来写，因为返回值都是builder
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //do sth
                        }
                    }).setNegativeButton("Quit", new DialogInterface.OnClickListener() {        //取消，可以连起来写，因为返回值都是builder
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //do sth
                        }
                    }).show();
                    break;
                case R.id.btn_dialog5:                                                                                      //自定义dialog 内容，
                    AlertDialog.Builder builder5=new AlertDialog.Builder(DialogActivity.this);
                    View view=LayoutInflater.from(DialogActivity.this).inflate(R.layout.layout_dialog,null);            //加载layout
                    EditText etUserName=view.findViewById(R.id.et_username);
                    EditText etPassword=view.findViewById(R.id.et_password);
                    Button btnLogin=view.findViewById(R.id.btn_login);
                    Button btnquit=view.findViewById(R.id.btn_quit);
                    btnLogin.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(android.view.View v) {
                            //
                        }
                    });

                    btnquit.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                        }
                    });

                    builder5.setTitle("Please first login").setView(view).show();
                    break;

                case R.id.btn_dialog6:                                                                                      //自定义dialog 对话框
                    Intent intent=new Intent(DialogActivity.this,CustomDialogActivity.class);
                    startActivity(intent);
                    break;

            }
        }
    }
}
