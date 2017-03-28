package com.example.tom.chatdemo.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.tom.chatdemo.R;

/**
 * Created by tom on 2017/3/22.
 */

public class CoatFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_coat, container, false);

        Button button = (Button )view.findViewById(R.id.button3);

        button.setOnClickListener(new View.OnClickListener(){
            //为找到的button设置监听
            @Override
            //重写onClick函数
            public void onClick(View v){


                Intent intent = new Intent();
                intent.setClass(getContext(), AskQuestionsActivity.class);
                getContext().startActivity(intent);
            }
        });


        return view;

    }




}
