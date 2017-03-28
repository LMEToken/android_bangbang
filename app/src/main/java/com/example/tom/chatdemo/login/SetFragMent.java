package com.example.tom.chatdemo.login;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tom.chatdemo.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tom on 2017/3/26.
 */

public class SetFragMent extends Fragment {

    private ListView listView;
  //  private String[] data = {"我的问题真是好累","我的问题真是好累","我的问题真是好累","我的问题真是好累"};

    private List<Map<String,String>> data;

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_set, container, false);

        listView = (ListView)view.findViewById(R.id.listview5);

        fillData();

//        SimpleAdapter adapter = new SimpleAdapter(
//                getContext(),
//                data,
//                R.layout.item_daniu,
//                new String[]{"title","detail"},
//                new int[]{R.id.textView3,R.id.detail}
//        );
//
//
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                if (i==data.size()-1)
                {
                    showDiaLog();
                }
                Toast.makeText(getContext(),"点击了"+i+"行",Toast.LENGTH_SHORT).show();
            }

        });



        BaseAdapter adapter1 = new BaseAdapter() {
            @Override
            public int getCount() {
                return data.size();
            }

            @Override
            public Object getItem(int position) {
                return position;
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {

                LayoutInflater inflater1 = LayoutInflater.from(getContext());

                View view ;
                if (position==1)
                {
                    view = inflater1.inflate(R.layout.item_head,null);


                    TextView textView = (TextView )view.findViewById(R.id.headName);

                    Map<String,String> map = data.get(position);

                    textView.setText(map.get("title"));



                }else if (position==2||position==data.size()-2||position==0)
                {

                    view = inflater1.inflate(R.layout.item_empty,null);
                }
                else
                {

                    view = inflater1.inflate(R.layout.item_titledetail,null);
                    TextView title = (TextView )view.findViewById(R.id.titledetail_title);
                    TextView detail = (TextView )view.findViewById(R.id.titledetail_detail);
                    Map<String,String> map = data.get(position);
                    title.setText(map.get("title"));
                    detail.setText(map.get("detail"));

                }

                return view;
            }
        };

        listView.setAdapter(adapter1);

        return view;
    }
    private void  fillData()
    {



        data = new ArrayList<Map<String, String>>();


        Map<String,String> kong0 = new HashMap<String, String>();
        kong0.put("title","");
        kong0.put("detail","");
        data.add(kong0);

        Map<String,String> user5 = new HashMap<String, String>();
        user5.put("title","tom");
        user5.put("detail","");
        data.add(user5);


        Map<String,String> kong1 = new HashMap<String, String>();
        kong1.put("title","");
        kong1.put("detail","");
        data.add(kong1);


        Map<String,String> user = new HashMap<String, String>();
        user.put("title","帮帮点");
        user.put("detail","");
        data.add(user);

        Map<String,String> user2 = new HashMap<String, String>();
        user2.put("title","我的回答");
        user2.put("detail","");
        data.add(user2);

        Map<String,String> user3 = new HashMap<String, String>();
        user3.put("title","我的问题");
        user3.put("detail","");
        data.add(user3);

        Map<String,String> user4 = new HashMap<String, String>();
        user4.put("title","认证大牛");
        user4.put("detail","");
        data.add(user4);

        Map<String,String> kong2 = new HashMap<String, String>();
        kong2.put("title","");
        kong2.put("detail","");
        data.add(kong2);


        Map<String,String> user6 = new HashMap<String, String>();
        user6.put("title","退出登录");
        user6.put("detail","");
        data.add(user6);
    }


    private void  showDiaLog()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
       // AlertDialog.Builder builder = new Builder(Main.this);
        builder.setMessage("确认退出吗？");
        builder.setTitle("提示");
        builder.setPositiveButton("确认", new DialogInterface.OnClickListener()
        {
            @Override public void onClick(DialogInterface dialog, int which) {

                Intent intent = new Intent();
                intent.setClass(getContext(), LoginActivity.class);
                getContext().startActivity(intent);
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener()
        {
            @Override public void onClick(DialogInterface dialog, int which) {

            }
        });

        builder.create().show();
    }
}
