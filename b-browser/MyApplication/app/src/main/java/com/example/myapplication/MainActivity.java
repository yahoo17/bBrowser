package com.example.myapplication;

import android.os.Bundle;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Fragment mFragment;
    private BottomNavigationBar bottom_navigation_bar_container;
    //点击菜单键弹出菜单窗口
    private BottomNavigationItem menu;

    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottom_navigation_bar_container = findViewById(R.id.buttomNavigationBar);
        initBottomBar();
        initFirstFragment();
    }
    //初始化底部导航栏
    private void initBottomBar(){
        bottom_navigation_bar_container.setMode(BottomNavigationBar.MODE_FIXED);
        bottom_navigation_bar_container.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        bottom_navigation_bar_container.setBarBackgroundColor(R.color.gray);
        menu = new BottomNavigationItem(R.drawable.user,"");
        bottom_navigation_bar_container
                .addItem(new BottomNavigationItem(R.drawable.back,"")).setActiveColor(R.color.black).setInActiveColor(R.color.black)
                .addItem(new BottomNavigationItem(R.drawable.next,"")).setActiveColor(R.color.purple_200).setInActiveColor(R.color.black)
                .addItem(new BottomNavigationItem(R.drawable.search,"")).setActiveColor(R.color.purple_200).setInActiveColor(R.color.black)
                .addItem(new BottomNavigationItem(R.drawable.home,"")).setActiveColor(R.color.purple_200).setInActiveColor(R.color.black)
                .addItem(menu).setActiveColor(R.color.purple_200).setInActiveColor(R.color.black)
                .initialise();
        bottom_navigation_bar_container.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener(){
            //当点击进入这个fragment
            @Override
            public void onTabSelected(int position) {
                if(position==0){
                    Toast.makeText(MainActivity.this,"返回上一级",Toast.LENGTH_SHORT).show();
                }
                else if(position==1){
                    Toast.makeText(MainActivity.this,"去往上次页面",Toast.LENGTH_SHORT).show();
                }
                else {
                    //获取fragment对象
                    Fragment fragment= fragmentFactory.getFragment(position);
                    //创建fragment管理器
                    FragmentManager fm=getSupportFragmentManager();
                    //获取fragment事务
                    FragmentTransaction transaction=fm.beginTransaction();
                    //判断fragment是否添加
                    if (!fragment.isAdded()){ //如果没有添加,进行添加到activity
                        if(position==0){}
                        if(position==1){}
                        else transaction.add(R.id.fragment_content,fragment);
                    }else {   //添加了，就进行显示
                        transaction.show(fragment);
                    }
//                    transaction.show(fragment);
                    //保存并提交
                    transaction.commit();
                }
            }
            //从这个fragment离开
            @Override
            public void onTabUnselected(int position) {
                Fragment fragment=fragmentFactory.getFragment(position);
                FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
                //离开tab.进行隐藏
                transaction.hide(fragment);
                transaction.commit();
            }

            @Override
            public void onTabReselected(int position) {

            }
        });
    }

    //初始化fragment
    private void initFirstFragment() {
        //使用fragmentTransaction.hide和show可能会导致重影
        FragmentManager fragmentManager=getSupportFragmentManager(); //v4包里的类
        List<Fragment> fragments=fragmentManager.getFragments();//获取有多少个fragment,并且添加到list集合里面
        if (fragments!=null&&fragments.size()>0){ //当list集合里面的fragment对象不为空，且fragment对象个数大于0时，执行
            for (Fragment fragment:fragments){  // 容器中元素类型   临时变量 ：容器变量  foreach循环会自动遍历容器中每个元素
                FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
                //移除残留的fragment
                fragmentTransaction.remove(fragment);
                //提交并保存
                fragmentTransaction.commit();
            }
        }
        //进入时默认显示第一个fragment界面
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        Fragment fragment=fragmentFactory.getFragment(3);
        fragmentTransaction.add(R.id.fragment_content,fragment);
        fragmentTransaction.commit();

    }
}