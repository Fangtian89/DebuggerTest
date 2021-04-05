package com.example.debuggertest.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.debuggertest.R;

public class AFragment extends Fragment {
    private TextView mTvTitle;
    private Button mBtnChangeTB, mBtnChangeTxt,getmBtnChangeActTB;
    private BFragment aFragment,bFragment;
    final Bundle bundle=new Bundle();
    private IOnMessageClick iOnMessageClick;

public static AFragment newInstanz(String title){            //用Fragment来传递参数，不能用带参数的Constructor, 这里要做一个Static 方法,返回一个AFragment
    AFragment fragment=new AFragment();
                                                                //相当于一个带参数的constuctor 来用
    Bundle bundle=new Bundle();
    bundle.putString("title",title);
    fragment.setArguments(bundle);
    return fragment;
}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) { //返回一个视图文件，告诉View 返回什么fragment
        View view=inflater.inflate(R.layout.fragment_a,container,false);                                                 //产生view
        getActivity();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {           //放入布局文件
        mBtnChangeTB=view.findViewById(R.id.fl_changeTB);
        mBtnChangeTxt=view.findViewById(R.id.fl_changeTxt);
        getmBtnChangeActTB=view.findViewById(R.id.fl_changeActTxt);

        mBtnChangeTB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bFragment==null){
                    bFragment=new BFragment();
                }
                Fragment fragment=getFragmentManager().findFragmentByTag("a");

                if(fragment!=null){
                    getFragmentManager().beginTransaction().hide(fragment).add(R.id.fl_container,bFragment).addToBackStack(null).commitAllowingStateLoss();
                }else{
                    getFragmentManager().beginTransaction().replace(R.id.fl_container,bFragment).addToBackStack(null).commitAllowingStateLoss();
                }

//                FragmentManager fragmentManager= getActivity().getSupportFragmentManager();                     //
//                final FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
//                fragmentTransaction.replace(R.id.fl_container,bFragment);                                       //replace 是先remove，再   add
//                fragmentTransaction.addToBackStack(null);                                                       //！！！把aFragment 放入栈里，replace 时，会把被替换的fragment 回收
//                fragmentTransaction.commitAllowingStateLoss();
            }
        });

        //----------------------------------------------------------------------------------------
        mBtnChangeTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTvTitle.setText("this is a new text for B");
//                bundle.putString("data","this is a new text for B");
            }
        });
        //---------------------------------------回调接口-------------------------------------------------

        getmBtnChangeActTB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iOnMessageClick.onClick("already changed!");                                    //实现的类，当他被赋予一个实现类的对象之后，就可以调用在这个实现类里的方法了。
            }
        });

        if(getActivity()!=null){                                                                   //最好判断一下这个fragment的activity
            mTvTitle=view.findViewById(R.id.tv_title);
            super.onViewCreated(view, savedInstanceState);
            if(getArguments()!=null){
                mTvTitle.setText(getArguments().getString("title"));
            }
        }



//        if(savedInstanceState!=null){
//            Log.d("Tag", "onViewCreated: Saved InstanzState");
//            mTvTitle.setText(savedInstanceState.getString("data"));
//        }
    }
    @Override
    public void onAttach(@NonNull Context context) {                            //载入aFragment时
        Log.d("Tag", "onAttach: A");
        super.onAttach(context);
        iOnMessageClick=(ContainerActivity)context;                             //回调的接口 赋予一个实现的类 的对象 :)，之后就可以访问在类里被实现的方法了
    }
    @Override
    public void onDetach() {                                                     //离开aFragment, 载入bFragment，时，replace...
        Log.d("Tag", "onDetach: A");
        Log.d("Tag", getActivity().toString());
        super.onDetach();
    }
    @Override
    public void onPause() {
        Log.d("Tag", "onPause: A");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.d("Tag", "onStop: A");
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        Log.d("Tag", "onDestroyView: A");
//        this.onSaveInstanceState( bundle);
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.d("Tag", "onDestroy: A");
        super.onDestroy();
    }

//    @Override
//    public void onSaveInstanceState(@NonNull Bundle outState) {
//        Log.d("Tag", "onSaveInstanceState: A");
//        super.onSaveInstanceState(outState);
//    }


   public interface IOnMessageClick{
    void onClick(String text);
    }

}
