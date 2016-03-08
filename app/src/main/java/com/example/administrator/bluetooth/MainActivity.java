package com.example.administrator.bluetooth;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    //1.定义不同颜色的菜单项的标识:
    final private int RED = 110;
    final private int GREEN = 111;
    final private int BLUE = 112;
    final private int YELLOW = 113;
    final private int GRAY = 114;
    final private int CYAN = 115;
    final private int BLACK = 116;

    private TextView tv_test;
    private Context mContext;
    private GridView grid_photo;
    private BaseAdapter mAdapter = null;
    private ArrayList<Icon> mData = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_test = (TextView) findViewById(R.id.tv_test);

        mContext = MainActivity.this;
        grid_photo = (GridView) findViewById(R.id.grid_photo);
        mData = new ArrayList<Icon>();
        mData.add(new Icon(R.mipmap.iv_icon_1, "列表Listview"));
        mData.add(new Icon(R.mipmap.iv_icon_2, "可折叠列表"));
        mData.add(new Icon(R.mipmap.iv_icon_3, "交互"));
        mData.add(new Icon(R.mipmap.iv_icon_4, "图标4"));
        mData.add(new Icon(R.mipmap.iv_icon_5, "图标5"));
        mData.add(new Icon(R.mipmap.iv_icon_6, "图标6"));
        mData.add(new Icon(R.mipmap.iv_icon_7, "图标7"));
        mData.add(new Icon(R.mipmap.iv_icon_8, "图标8"));
        mData.add(new Icon(R.mipmap.iv_icon_9, "图标9"));

        mAdapter = new MyAdapter<Icon>(mData, R.layout.item_grid_icon) {
            @Override
            public void bindView(ViewHolder holder, Icon obj) {
                holder.setImageResource(R.id.img_icon, obj.getiId());
                holder.setText(R.id.txt_icon, obj.getiName());
            }
        };

        grid_photo.setAdapter(mAdapter);

        grid_photo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                /*Toast.makeText(mContext, "你点击了~" + position + "~项", Toast.LENGTH_SHORT).show();*/
                if (position==0){
                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, ListViewActivity.class);
                    startActivity(intent);
                }
                if (position==1){
                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, TestActivity.class);
                    startActivity(intent);
                }
                if (position==2){
                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, FragmentActivity.class);
                    startActivity(intent);
                }
                if (position==3){
                    Toast.makeText(mContext, "正在开发中", Toast.LENGTH_SHORT).show();
                }
                if (position==4){
                    Toast.makeText(mContext, "正在开发中", Toast.LENGTH_SHORT).show();
                }
                if (position==5){
                    Toast.makeText(mContext, "正在开发中", Toast.LENGTH_SHORT).show();
                }
                if (position==6){
                    Toast.makeText(mContext, "正在开发中", Toast.LENGTH_SHORT).show();
                }
                if (position==7){
                    Toast.makeText(mContext, "正在开发中", Toast.LENGTH_SHORT).show();
                }
                if (position==8){
                    Toast.makeText(mContext, "正在开发中", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        menu.add(1, RED, 4, "红色");
        menu.add(1, GREEN, 2, "绿色");
        menu.add(1, BLUE, 3, "蓝色");
        menu.add(1, YELLOW, 1, "黄色");
        menu.add(1, GRAY, 5, "灰色");
        menu.add(1, CYAN, 6, "蓝绿色");
        menu.add(1, BLACK, 7, "黑色");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (id) {
            case RED:
                tv_test.setTextColor(Color.RED);
                break;
            case GREEN:
                tv_test.setTextColor(Color.GREEN);
                break;
            case BLUE:
                tv_test.setTextColor(Color.BLUE);
                break;
            case YELLOW:
                tv_test.setTextColor(Color.YELLOW);
                break;
            case GRAY:
                tv_test.setTextColor(Color.GRAY);
                break;
            case CYAN:
                tv_test.setTextColor(Color.CYAN);
                break;
            case BLACK:
                tv_test.setTextColor(Color.BLACK);
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
            Intent intent = new Intent();
            intent.setClass(MainActivity.this, ListViewActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_gallery) {
            Toast.makeText(mContext, "正在开发中", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_slideshow) {
            Toast.makeText(mContext, "正在开发中", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_manage) {
            Toast.makeText(mContext, "正在开发中", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_share) {
            Intent intent = new Intent();
            intent.setClass(MainActivity.this, RegisterActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_send) {
            Intent intent = new Intent();
            intent.setClass(MainActivity.this, LoginActivity.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
