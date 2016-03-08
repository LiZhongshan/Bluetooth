package com.example.administrator.bluetooth;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.bluetooth.other.Data;
import com.example.administrator.bluetooth.other.NewListFragment;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/3/7.
 */
public class FragmentActivity extends Activity {
    private TextView txt_title;
    private FrameLayout fl_content;
    private Context mContext;
    private ArrayList<Data> datas = null;
    private FragmentManager fManager = null;
    private long exitTime = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        mContext = FragmentActivity.this;
        fManager = getFragmentManager();
        bindViews();

        datas = new ArrayList<Data>();
        for (int i = 1; i <= 20; i++) {
            Data data = new Data("新闻标题" + i, i + "~新闻内容");
            datas.add(data);
        }
        NewListFragment nlFragment = new NewListFragment(fManager, datas);
        FragmentTransaction ft = fManager.beginTransaction();
        ft.replace(R.id.fl_content, nlFragment);
        ft.commit();
    }


    private void bindViews() {
        txt_title = (TextView) findViewById(R.id.txt_title);
        fl_content = (FrameLayout) findViewById(R.id.fl_content);
    }


    //点击回退键的处理：判断Fragment栈中是否有Fragment
    //没，双击退出程序，否则像是Toast提示
    //有，popbackstack弹出栈
    @Override
    public void onBackPressed() {
        if (fManager.getBackStackEntryCount() == 0) {
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                Toast.makeText(getApplicationContext(), "再按一次退出程序",
                        Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                super.onBackPressed();
            }
        } else {
            fManager.popBackStack();
            txt_title.setText("新闻列表");
        }
    }
    public void login_back(View v) {
        this.finish();
    }
}
