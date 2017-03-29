package com.example.tom.chatdemo.login.BaseActivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by tom on 2017/3/29.
 */

public class BaseActivity extends Activity {


     public TextView mTitleTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    public void setViewTitle (String title)
    {
        if (mTitleTextView!=null)
        {
            mTitleTextView.setText(title);
        }

    }
}
