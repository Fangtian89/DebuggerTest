package com.example.debuggertest;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.example.debuggertest.R;
public class WebViewActivity extends AppCompatActivity {
    private WebView mwebviewMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        mwebviewMain=findViewById(R.id.wv);

//      mwebviewMain.loadUrl("file:///android_asset/htmltest.html");          //加载本地地址
//---------------------------------------------------------------------------------------------------
        mwebviewMain.getSettings().setJavaScriptEnabled(true);                  //打开js
        mwebviewMain.setWebViewClient(new MyWebViewClient());                   //保持一致在app 里打开网页,不会被询问是否使用chrome
        mwebviewMain.setWebChromeClient(new MyWebChromeClient());               //加载条，或对于网页加载的各种方法
        mwebviewMain.loadUrl("http://m.baidu.com");                             //加载网络地址，有个 m 在前边

    }
//---------------------------------------------------------------------------------------------------------------------
    class MyWebViewClient extends WebViewClient{                                //保持一致在app,不会被询问是否使用chrome, 里打开网页的类
        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            view.loadUrl(request.getUrl().toString());
            return true;
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {   //网页刚加载做点什么
            super.onPageStarted(view, url, favicon);
            Toast.makeText(WebViewActivity.this, "onPageStartet", Toast.LENGTH_SHORT).show();
        }

        @TargetApi(19)
        @Override
        public void onPageFinished(WebView view, String url) {                  //网页加载完毕做点什么
            super.onPageFinished(view, url);
            Toast.makeText(WebViewActivity.this, "onPageFinished", Toast.LENGTH_SHORT).show();

//            mwebviewMain.loadUrl("javascript:alert('运用js加载一个alert')");      //native 调用 js 方法 或
            mwebviewMain.evaluateJavascript("javascript:alert('运用js加载一个alert，另一种方法')",null);

//            mwebviewMain.addJavascriptInterface();                              //此方法可以让js 调用native 方法

        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {         //废弃掉了
            return super.shouldOverrideUrlLoading(view, url);
        }
    }
    //---------------------------------------------------------------------------------------------------------------------
    class MyWebChromeClient extends WebChromeClient{
        @Override
        public void onReceivedTitle(WebView view, String title) {                   //把加载网页的Title 加载到app 上，（仅限加载时）
            super.onReceivedTitle(view, title);
            setTitle(title);
        }

        @Override
        public void onProgressChanged(WebView view, int newProgress) {              //可以实现监听进度
            super.onProgressChanged(view, newProgress);
        }
    }



    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {                         //返回键 能返回刚才页面
        if(keyCode==KeyEvent.KEYCODE_BACK && mwebviewMain.canGoBack()){
            mwebviewMain.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
