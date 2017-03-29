package com.example.tom.chatdemo.login.RegisterAndRetieve;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.tom.chatdemo.R;
import com.example.tom.chatdemo.login.BaseActivity.BaseActivity;

/**
 * Created by tom on 2017/3/28.
 */

public class RegisterActivity extends BaseActivity {


    public  String phoneNum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_register);

        Intent intent = this.getIntent();

        phoneNum =(String)intent.getSerializableExtra("phoneNum");

        TextView text  = (TextView)findViewById(R.id.phoneNum_text);

        text.setText(phoneNum);

        mTitleTextView = (TextView) findViewById(R.id.text_title);

        setViewTitle("注册");

    }
    //获取验证码
    public void  getVerCodeClick(View view)
    {

    }
    //注册
    public void  register (View view)
    {

    }
    public void onbackClick(View view)
    {

        this.finish();
    }


}
