package com.example.debuggertest;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;

public class ImageViewActivity extends Activity {
    private ImageView mIv4;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);

        mIv4=findViewById(R.id.iv_4);

        Glide.with(this).load("https://bilder.t-online.de/b/88/04/90/46/id_88049046/610/tid_da/grillen-einige-lebensmittel-koennen-durch-das-grillen-zur-gefahr-fuer-die-gesundheit-werden-symbolbild-.jpg").into(mIv4);
    }
}
