package com.example.myapplication;
import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.content.ComponentName;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import android.view.View.OnClickListener;
import android.widget.TextView;
//import com.example.myapplication.databinding.FragmentFirstBinding;

public class FifthFragment extends Fragment {
    private Button buttonBack;
    private Button buttonSetting;
    private TextView label;
    private TextView record;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fifth, container, false);
        buttonSetting = view.findViewById(R.id.setting);
        buttonSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //点击设置按钮，跳转至登录登出界面
            }
        });
        label =(TextView) view.findViewById(R.id.label);
        label.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent();
                i.setClass(getActivity(),bookmark_history.class);
                startActivity(i);
            }
        });
        record = view.findViewById(R.id.record);
        record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j=new Intent();
                j.setClass(getActivity(),bookmark_history.class);
                startActivity(j);
            }
        });
        return view;
    }
}
