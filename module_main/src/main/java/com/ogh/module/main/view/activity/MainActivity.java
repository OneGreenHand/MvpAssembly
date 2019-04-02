package com.ogh.module.main.view.activity;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.widget.Toast;

import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.AppUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.ogh.module.common.base.activity.BaseActivity;
import com.ogh.module.main.R;
import com.ogh.module.main.R2;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R2.id.view_pager)
    ViewPager mPager;
    @BindView(R2.id.navigation_view)
    BottomNavigationView navigationView;
    private List<Fragment> mFragments = new ArrayList<>();
    //记录用户首次点击返回键的时间
    private long firstTime = 0;
    private MenuItem menuItem;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            menuItem = item;
            int i = item.getItemId();
            if (i == R.id.home) {
                mPager.setCurrentItem(0);
            } else if (i == R.id.game) {
                mPager.setCurrentItem(1);
            } else if (i == R.id.core) {
                return false;
            } else if (i == R.id.online) {
                mPager.setCurrentItem(2);
            } else if (i == R.id.mine) {
                mPager.setCurrentItem(3);
            }
            return true;
        }

    };


    @Override
    protected void init(Bundle savedInstanceState) {

    }

    @Override
    protected void initData() {
        initViewPager();
        initViewPagerChangeListener();
        navigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private void initViewPager() {
        Fragment homefragme = (Fragment) ARouter.getInstance().build("/homemoudle/homefragment").navigation();
        Fragment gamefragment = (Fragment) ARouter.getInstance().build("/gamemoudle/gamefragment").navigation();
        Fragment onlinefragment = (Fragment) ARouter.getInstance().build("/onlinemoudle/onlinefragment").navigation();
        Fragment minefragment = (Fragment) ARouter.getInstance().build("/minemoudle/minefragment").navigation();
        mFragments.add(homefragme);
        mFragments.add(gamefragment);
        mFragments.add(onlinefragment);
        mFragments.add(minefragment);
        initAdapter();
    }

    private void initAdapter() {
        FragmentPagerAdapter adapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public int getCount() {
                return mFragments.size();
            }

            @Override
            public Fragment getItem(int arg0) {
                return mFragments.get(arg0);
            }
        };
        mPager.setAdapter(adapter);
    }

    private void initViewPagerChangeListener() {
        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                //TODO 这里使用的是viewpage+framge方式，暂未实现沉浸式状态栏，如需实现，只需在此方法中实现即可，具体可参考 https://github.com/gyf-dev/ImmersionBar/blob/master/sample/src/main/java/com/gyf/immersionbar/activity/FragmentThreeActivity.java
                if (position >= 2)//第三个为悬浮按钮
                    position++;
                if (menuItem != null) {
                    menuItem.setChecked(false);
                } else {
                    navigationView.getMenu().getItem(0).setChecked(false);
                }
                menuItem = navigationView.getMenu().getItem(position);
                menuItem.setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            long secondTime = System.currentTimeMillis();
            if (secondTime - firstTime > 2000) {
                Toast.makeText(MainActivity.this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                firstTime = secondTime;
                return true;
            } else {
                AppUtils.exitApp();
                finish();
            }
        }
        return super.onKeyDown(keyCode, event);
    }


    @OnClick(R2.id.floating_action)
    public void onViewClicked() {
        ToastUtils.showShort("MvpFrame");
    }
}
