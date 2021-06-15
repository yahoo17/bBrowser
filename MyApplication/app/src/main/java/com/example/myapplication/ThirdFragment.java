package com.example.myapplication;

import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
//import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ThirdFragment extends Fragment {
    public WebView webview;
    private WebSettings settings;
//    private View view;
    public boolean flag=true;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_third, container,false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        webview = (WebView) view.findViewById(R.id.searchView);
        settings = webview.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setAppCacheEnabled(true);
        settings.setAllowFileAccess(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        //支持缩放
        settings.setUseWideViewPort(true);//设定支持viewport
        settings.setLoadWithOverviewMode(true);
        settings.setBuiltInZoomControls(true);
        settings.setSupportZoom(true);//设定支持缩放

        //解决无法打开https网页的问题
        // android 5.0以上默认不支持Mixed Content
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            settings.setMixedContentMode(
                    WebSettings.MIXED_CONTENT_COMPATIBILITY_MODE);
        }

        webview.setWebViewClient(new WebViewClient() {
            @Override
            public void onReceivedSslError(WebView view,
                                           SslErrorHandler handler, SslError error) {
                // TODO Auto-generated method stub
                // handler.cancel();// Android默认的处理方式
                handler.proceed();// 接受所有网站的证书
                // handleMessage(Message msg);// 进行其他处理
            }
        });
        //打开的网址
        webview.loadUrl("http://www.baidu.com");
//        else webview.loadUrl("www.baidu.com");
    }

//    @Nullable
//    @org.jetbrains.annotations.Nullable
//    @Override
//    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
//        Log.d(flag+"","status!!!");
//        if(enter&&!flag){
//            flag = true;
//        } else {
//            flag = false;
//        }
//        return super.onCreateAnimation(transit, enter, nextAnim);
//    }

//    @Override
//    public void onResume() {
//        Log.d(flag+"","status!!!");
//        flag = !flag;
//        if(flag) {
//            webview.loadUrl("http://enquiries-2gjb84chaea8dede-1301979031.tcloudbaseapp.com/#/");
////            flag = false;
//        }
//        else {
//            webview.loadUrl("https://www.baidu.com/");
////            flag = true;
//        }
//        super.onResume();
//    }

//    @Override
//    public void onStart() {
//        if(flag) flag = false;
//        else flag = true;
//        super.onStart();
//    }
}