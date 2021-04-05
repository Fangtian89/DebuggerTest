package com.example.debuggertest;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class RadioButtonActivity extends AppCompatActivity {
    private RadioGroup mRg1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button);

        mRg1=findViewById(R.id.rg_1);
        mRg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {                         //是用radio group 来察觉 radio button 是否被点击，而不是直接用radio button
                RadioButton radioButton=(RadioButton) group.findViewById(checkedId);                //找到group 里， 哪一个被点击了
                Toast.makeText(RadioButtonActivity.this,radioButton.getText().toString(),Toast.LENGTH_SHORT).show();

            }
        });




    }
}
