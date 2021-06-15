package com.example.myapplication;

import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.webkit.WebView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import java.util.logging.Handler;

import static android.widget.Toast.LENGTH_SHORT;

public class fragmentFactory extends AppCompatActivity{
    private static FirstFragment firstFragment=new FirstFragment();
    private static ThirdFragment thirdFragment=new ThirdFragment();
    private static WebViewFragment webViewFragment = new WebViewFragment();

    private static FifthFragment fifthFragment = null;
    private static ForthFragment forthFragment = null;

    private static void getMenu(){

    }

    public static Fragment getFragment(int position){
        return showFragment(position);
    }

    public static Fragment showFragment(int p){
        Log.d("now showFragment:",""+p);
        switch (p)
        {
            case 0:
            {
                webViewFragment.GoBack();
                return webViewFragment;
            }
            case 1:
            {
                webViewFragment.GoAhead();
                return webViewFragment;
            }
            case 2:
            {
//
                webViewFragment.LoadURL("http://www2.scut.edu.cn/gzic/");
                return webViewFragment;
//                if(webViewFragment==null) {
//                    webViewFragment = new WebViewFragment();
//                    Log.d("true","nothing");
//                }
//                webViewFragment.LoadURL("http://www2.scut.edu.cn/gzic/");
//                return webViewFragment;
////                WebViewFragment.getInstance().LoadURL("http://www2.scut.edu.cn/gzic/");
//////                webViewFragment.LoadURL("https://www.scut.edu.cn/new/");
////                return webViewFragment;
//                if (thirdFragment==null){
//                    thirdFragment=new ThirdFragment();
//                }
//                return thirdFragment;
            }
            case 3:
            {

                webViewFragment.LoadURL("https://www.scut.edu.cn/new/");
                return webViewFragment;
////                webViewFragment.LoadURL("http://www2.scut.edu.cn/gzic/");
////                webViewFragment.LoadURL("https://fanyi.baidu.com/?aldtype=85#en/zh/window");
//                return webViewFragment;
//                if (forthFragment==null){
//                    forthFragment=new ForthFragment();
//                }
//                return forthFragment;
            }
            case 4:
            {
                if (fifthFragment==null){
                    fifthFragment=new FifthFragment();
                }
                return fifthFragment;
            }

        };
        Log.e("no fragement!!!","no fragement");
        return fifthFragment;
    }
}
