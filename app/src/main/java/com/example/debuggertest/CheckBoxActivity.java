package com.example.debuggertest;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class CheckBoxActivity extends AppCompatActivity {
    CheckBox ck1,ck2,ck3,ck4,sub_ck1,sub_ck2,sub_ck3,sub_ck4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);

        ck1=findViewById(R.id.ck_1);
        ck2=findViewById(R.id.ck_2);
        ck3= findViewById(R.id.ck_3);
        ck4= findViewById(R.id.ck_4);
        sub_ck1=findViewById(R.id.subck_1);
        sub_ck2=findViewById(R.id.subck_2);
        sub_ck3=findViewById(R.id.subck_3);
        sub_ck4=findViewById(R.id.subck_4);


        ck1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(CheckBoxActivity.this,isChecked?"mode 1 is chosen":"mode 1 not chosen",Toast.LENGTH_SHORT).show();
            }
        });

        ck2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(CheckBoxActivity.this,isChecked?"mode 2is chosen":"mode 2 not chosen",Toast.LENGTH_SHORT).show();
            }
        });

        ck3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(CheckBoxActivity.this,isChecked?"mode 3 is chosen":"mode 3 not chosen",Toast.LENGTH_SHORT).show();
            }
        });

        ck4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(CheckBoxActivity.this,isChecked?"mode 4 is chosen":"mode 4 not chosen",Toast.LENGTH_SHORT).show();
            }
        });

        sub_ck1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            }
        });
    }
}
