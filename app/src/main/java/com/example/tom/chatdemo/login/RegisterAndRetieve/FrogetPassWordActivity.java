package com.example.tom.chatdemo.login.RegisterAndRetieve;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.tom.chatdemo.R;
import com.example.tom.chatdemo.login.BaseActivity.BaseActivity;

/**
 * Created by tom on 2017/3/29.
 */

public class FrogetPassWordActivity extends BaseActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_register);

        mTitleTextView = (TextView) findViewById(R.id.text_title);

        setViewTitle("忘记密码");

        Button button = (Button )findViewById(R.id.button_register);

        button.setText("修改密码");
    }
    //获取验证码
    public void  getVerCodeClick(View view)
    {

    }
    //修改密码
    public void  register (View view)
    {

    }
    public void onbackClick(View view)
    {

        this.finish();
    }
}
