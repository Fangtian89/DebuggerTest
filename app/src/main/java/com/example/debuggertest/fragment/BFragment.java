package com.example.debuggertest.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.debuggertest.R;

public class BFragment extends Fragment {
    private TextView mTvTitle;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) { //返回一个视图文件， 即设计布局文件
        View view=inflater.inflate(R.layout.fragment_b,container,false);
        Log.d("TAG", "onCreateView: B");
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {           //放入布局文件
//        if(getActivity()!=null){
//            mTvTitle=view.findViewById(R.id.tv_title);
        Log.d("TAG", "onViewCreated: B");
            super.onViewCreated(view, savedInstanceState);
        //}

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.d("TAG", "onActivityCreated: B");
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        Log.d("Tag", "onAttach: B");
        Log.d("Tag B", getActivity().toString());
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        Log.d("Tag", "onDetach: B");
        Log.d("Tag-B", getActivity().toString());
        super.onDetach();
    }

    @Override
    public void onPause() {
        Log.d("Tag", "onPause: B");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.d("Tag", "onStop: B");
        super.onStop();
    }

    @Override
    public void onDestroy() {
        Log.d("Tag", "onDestroy: B");
        super.onDestroy();
    }


}
