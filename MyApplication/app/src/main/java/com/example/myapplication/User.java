package com.example.myapplication;

import android.content.DialogInterface;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class User extends AppCompatActivity{
    private Button buttonBack;
    private Button buttonSetting;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user);

        buttonSetting = (Button) findViewById(R.id.setting);
        buttonSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //点击设置按钮，跳转至登录登出界面
            }
        });
    }
}
