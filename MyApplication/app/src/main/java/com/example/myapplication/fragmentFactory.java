package com.example.myapplication;

import android.os.Looper;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import java.util.logging.Handler;

import static android.widget.Toast.LENGTH_SHORT;

public class fragmentFactory extends AppCompatActivity{
    private static FirstFragment firstFragment=null;
    private static SecondFragment secondFragment=null;
    private static ThirdFragment thirdFragment=null;
    private static ForthFragment forthFragment=null;
    private static FifthFragment fifthFragment=null;
    private static void getMenu(){

    }

    public static Fragment getFragment(int postin){
        switch (postin){
            case 0:
                if (firstFragment==null){
                    firstFragment=new FirstFragment();
                }
                return firstFragment;
            case 1:
                if (secondFragment==null){
                    secondFragment=new SecondFragment();
                }
                return secondFragment;
            case 2:
                if (thirdFragment==null){
                    thirdFragment=new ThirdFragment();
                }
                return thirdFragment;
            case 3:
                if (forthFragment==null){
                    forthFragment=new ForthFragment();
                }
                return forthFragment;
            case 4:
                if (fifthFragment==null){
                    fifthFragment=new FifthFragment();
                }
                return fifthFragment;
        }
        return firstFragment;
    }
}
