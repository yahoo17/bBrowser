package com.example.myapplication;

import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
//WebViewFragment.getInstance().LoadURL()

public class WebViewFragment extends Fragment {

    private static WebSettings settings;
    private View view;
    public static WebView webview;


    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }


    public void init()
    {
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
        webview.loadUrl("http://www2.scut.edu.cn/gzic/");
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_webview, container,false);
        webview = view.findViewById(R.id.webViewOnly);
        init();
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



    }


    public void LoadURL(String url)
    {
        webview.loadUrl(url);
    }

    public void GoBack(){
        if (webview.canGoBack()) {
            webview.goBack();

        }
//        webview.goBack();
    }

    public  void GoAhead(){
        if(webview.canGoForward())
            webview.goForward();
    }

//    public static void LoadURL(String url)
//    {
//
//        if(instance.webview == null)
//        {
//            Log.d("","webview is empty");
//        }
//        else
//        WebViewFragment.getInstance().webview.loadUrl(url);
//    }
//
//    public static void GoBack(){
//        instance.webview.goBack();
//    }
//
//    public static void GoAhead(){
//        instance.webview.goForward();
//    }


}
