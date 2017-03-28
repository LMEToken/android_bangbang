package com.example.tom.chatdemo.login;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Display;
import android.view.KeyEvent;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;

import com.example.tom.chatdemo.R;
import com.example.tom.chatdemo.login.NavigationView.OnItemClickListener;


public class MainActivity extends FragmentActivity implements OnItemClickListener {


    private NavigationView nv;
    private Fragment coatFragment;
    private Fragment trousersFragment;
    private Fragment shoeFragment;
    private String[] titles = { "外套", "裤子", "鞋子" };
    private int[] selectedImage = { R.drawable.icon_loose_coat_two,R.drawable.icon_loose_coat_two,
            R.drawable.icon_loose_coat_two };
    private int[] unSelectedImage = { R.drawable.icon_loose_coat_two, R.drawable.icon_loose_coat_two,
            R.drawable.icon_loose_coat_two };
    private int mHeight;
    private boolean isGetHeight = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    //屏蔽后退键盘
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN
                && event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
            return true;//消费掉后退键
        }
        return super.onKeyDown(keyCode, event);
    }
    private void initView() {
// 获取屏幕宽度
        Display dm = getWindowManager().getDefaultDisplay();
        final int screenWidth = dm.getWidth();
        nv = (NavigationView) findViewById(R.id.nv);
// 初始化获取底部导航自身高度
        final ViewTreeObserver vt = nv.getViewTreeObserver();
        vt.addOnPreDrawListener(new OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                if (isGetHeight) {
                    mHeight = nv.getMeasuredHeight()+20;
                    nv.setLayout(titles, selectedImage, unSelectedImage, screenWidth, mHeight, MainActivity.this);
                    nv.setColorLing(0);
                    nv.setOnItemClickListener(MainActivity.this);
                    isGetHeight = false;
                }
                return true;
            }
        });
        showFragment(0);
    }

    @Override
    public void onItemClick(int position) {
       showFragment(position);

        System.out.println("点击了 按钮"+position);
    }

    /**
     * 动态添加和显示fragment
     *
     * @param position
     */
    private void showFragment(int position) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        hideFragment(transaction);
        switch (position) {
            case 0:
                if (coatFragment == null) {
                    coatFragment = new CoatFragment();
                    transaction.add(R.id.fragment_content, coatFragment);
                } else {
                    transaction.show(coatFragment);
                }
                break;
            case 1:
                if (trousersFragment == null) {
                    trousersFragment = new CenterFragMent();
                    transaction.add(R.id.fragment_content, trousersFragment);
                } else {
                    transaction.show(trousersFragment);
                }
                break;

            case 2:
                if (shoeFragment == null) {
                    shoeFragment = new SetFragMent();
                    transaction.add(R.id.fragment_content, shoeFragment);
                } else {
                    transaction.show(shoeFragment);
                }
                break;
        }
        transaction.commit();
    }


    /**
     * 隐藏所有fragment
     *
     * @param transaction
     */
    private void hideFragment(FragmentTransaction transaction) {
        if (coatFragment != null) {
            transaction.hide(coatFragment);
        }


        if (trousersFragment != null) {
            transaction.hide(trousersFragment);
        }


        if (shoeFragment != null) {
            transaction.hide(shoeFragment);
        }
    }

}