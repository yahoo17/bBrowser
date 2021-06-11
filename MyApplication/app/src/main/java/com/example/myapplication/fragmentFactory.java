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
    private static SecondFragment secondFragment=null;
    private static ThirdFragment thirdFragment=new ThirdFragment();
    private static ForthFragment forthFragment=null;
    private static FifthFragment fifthFragment=new FifthFragment();
    private WebView webView = null;
    private static void getMenu(){

    }

    public static Fragment getFragment(int postin,int cur){
        if(postin>1) return showFragment(postin);
//       Log.d("current_page+ beeeeeeeee",""+cur);
        //获取当前fragment

        return showFragment(cur);
    }

    public static Fragment showFragment(int p){
        Log.d("now showFragment:",""+p);
        switch (p){
            case 2:
                if (thirdFragment==null){
//                    thirdFragment=new ThirdFragment();
                }
                return thirdFragment;
            case 3:
                if (firstFragment==null){
//                    firstFragment=new FirstFragment();
                }
                return firstFragment;
            case 4:
                if (fifthFragment==null){
//                    fifthFragment=new FifthFragment();
                }
                return fifthFragment;
        }
        return firstFragment;
    }
}
