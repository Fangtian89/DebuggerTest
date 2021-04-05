package com.example.debuggertest;

import android.app.Activity;
import android.os.Bundle;
import android.view.accessibility.AccessibilityEvent;

import androidx.annotation.Nullable;

import com.example.debuggertest.recyclerview.LinearRecyclerViewActivity;
import com.example.debuggertest.recyclerview.RecyclerViewActivity;

public class test extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        return super.dispatchPopulateAccessibilityEvent(event);
    }

}


