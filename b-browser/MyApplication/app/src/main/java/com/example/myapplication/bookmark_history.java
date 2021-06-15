package com.example.myapplication;
import android.os.Bundle;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.app.TabActivity;
import android.view.LayoutInflater;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.Toast;
import  android.content.Context;
import  android.graphics.Canvas;
import  android.util.AttributeSet;
import  android.widget.TextView;
import android.graphics.Typeface;

public class bookmark_history extends TabActivity{
    @Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setTitle("TabDemoActivity");
    TabHost tabHost = getTabHost();
    LayoutInflater.from(this).inflate(R.layout.bookmark_history,
            tabHost.getTabContentView(), true);
    tabHost.addTab(tabHost.newTabSpec("书签收藏").setIndicator("书签收藏")
            .setContent(R.id.view1));
    tabHost.addTab(tabHost.newTabSpec("历史记录").setIndicator("历史记录")
            .setContent(R.id.view2));


    //标签切换事件处理，setOnTabChangedListener
    tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener(){
        @Override
        public void onTabChanged(String tabId) {
            if (tabId.equals("tab1")) {   //第一个标签
            }
            if (tabId.equals("tab2")) {   //第二个标签
            }

        }
    });
}
}




