package com.example.tom.chatdemo.login;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tom.chatdemo.R;
import com.example.tom.chatdemo.login.RegisterAndRetieve.Register;

import Model.UserModel;

public class LoginActivity extends Activity {

    private View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);




        Window window = this.getWindow();

        //取消设置透明状态栏,使 ContentView 内容不再覆盖状态栏
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        //需要设置这个 flag 才能调用 setStatusBarColor 来设置状态栏颜色
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        //设置状态栏颜色
        window.setStatusBarColor(R.color.ColorClearColor);

        view = (View)findViewById(R.id.activity_main);

        view.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);


        //控制登录用户名图标大小
        EditText editText1 = (EditText) findViewById(R.id.userName);
        Drawable drawable1 = getResources().getDrawable(R.drawable.acconet);
        drawable1.setBounds(0, 0, 40, 40);//第一0是距左边距离，第二0是距上边距离，40分别是长宽
        editText1.setCompoundDrawables(drawable1, null, null, null);//只放左


        EditText editText2 = (EditText) findViewById(R.id.passWorld);
        Drawable drawable2 = getResources().getDrawable(R.drawable.password);
        drawable2.setBounds(0, 0, 40, 40);//第一0是距左边距离，第二0是距上边距离，40分别是长宽
        editText2.setCompoundDrawables(drawable2, null, null, null);//只放左


        // this.requestWindowFeature(Window.FEATURE_NO_TITLE);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void  loginClick(View view) {


        Intent intent = new Intent();
        intent.setClass(LoginActivity.this, MainActivity.class);
        LoginActivity.this.startActivity(intent);

//        new Thread() {
//            @Override
//            public void run() {
//
//                EditText userName = (EditText) findViewById(R.id.userName);
//                EditText passWorld = (EditText) findViewById(R.id.passWorld);
//
//                UserModel user = LoginProvider.login(userName.getText().toString(), passWorld.getText().toString());
//                Message message = new Message();
//                message.what = 0x0001;
//                message.obj = user;
//                handler.sendMessage(message);
//
//            }
//        }.start();


    }

    public void  registerClick (View view)
    {
        Intent intent = new Intent();
        intent.setClass(LoginActivity.this, Register.class);
        LoginActivity.this.startActivity(intent);
    }
    private Handler handler = new Handler()
    {
        @Override
        public void handleMessage(Message msg) {

            switch (msg.what)
            {
                case 0x001:

                    UserModel user = (UserModel)msg.obj;
                    if (user!=null)
                    {
                        UserModel.setInstance(user);
                        Intent intent = new Intent();
                        intent.setClass(LoginActivity.this, MainActivity.class);
                        LoginActivity.this.startActivity(intent);

                    }else
                    {


                        Toast.makeText(getApplicationContext(),"登录失败",Toast.LENGTH_SHORT).show();

                    }
                    break;


                default:
                    break;
            }
        }
    };








}
