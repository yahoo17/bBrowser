package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.myapplication.databinding.FragmentFirstBinding;

public class    FirstFragment extends Fragment {
   private ImageView baidu, weibo, google, csdn, zhihu, aiqiyi;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable  Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        baidu = getActivity().findViewById(R.id.baidu);
        weibo = getActivity().findViewById(R.id.weibo);
        google = getActivity().findViewById(R.id.google);
        csdn = getActivity().findViewById(R.id.csdn);
        zhihu = getActivity().findViewById(R.id.zhihu);
        aiqiyi = getActivity().findViewById(R.id.aiqiyi);
        baidu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = "https://www.baidu.com/";
                Intent intent = new Intent();
                intent.setClass(getActivity(),webView.class); //从前者跳到后者，特别注意的是，在fragment中，用getActivity()来获取当前的activity
                intent.putExtra("url", data);
                getActivity().startActivity(intent);

            }
        });
        weibo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = "https://weibo.com/";
                Intent intent = new Intent();
                intent.setClass(getActivity(),webView.class); //从前者跳到后者，特别注意的是，在fragment中，用getActivity()来获取当前的activity
                intent.putExtra("url", data);
                getActivity().startActivity(intent);

            }
        });
        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = "https://www.google.cn/";
                Intent intent = new Intent();
                intent.setClass(getActivity(),webView.class); //从前者跳到后者，特别注意的是，在fragment中，用getActivity()来获取当前的activity
                intent.putExtra("url", data);
                getActivity().startActivity(intent);

            }
        });
        csdn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = "https://www.csdn.net/";
                Intent intent = new Intent();
                intent.setClass(getActivity(),webView.class); //从前者跳到后者，特别注意的是，在fragment中，用getActivity()来获取当前的activity
                intent.putExtra("url", data);
                getActivity().startActivity(intent);

            }
        });
        zhihu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = "https://www.zhihu.com/";
                Intent intent = new Intent();
                intent.setClass(getActivity(),webView.class); //从前者跳到后者，特别注意的是，在fragment中，用getActivity()来获取当前的activity
                intent.putExtra("url", data);
                getActivity().startActivity(intent);

            }
        });
        aiqiyi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = "https://www.iqiyi.com/";
                Intent intent = new Intent();
                intent.setClass(getActivity(),webView.class); //从前者跳到后者，特别注意的是，在fragment中，用getActivity()来获取当前的activity
                intent.putExtra("url", data);
                getActivity().startActivity(intent);

            }
        });
    }


}