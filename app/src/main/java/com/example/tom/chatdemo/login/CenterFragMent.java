package com.example.tom.chatdemo.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.tom.chatdemo.R;

/**
 * Created by tom on 2017/3/22.
 */

public class CenterFragMent extends Fragment {


    private ListView listView;

    private String[] data = {"上海asdas","北京asdasd","广州sadasd","深圳"};
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_cent, container, false);

        listView = (ListView)view.findViewById(R.id.listview2);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(getContext(),"点击了"+data[i],Toast.LENGTH_LONG).show();
            }

        });
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getContext(),
                R.layout.list_view,
                R.id.textView,
                data

        );

        listView.setAdapter(adapter);


        return view;
    }
}
