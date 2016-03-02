package com.example.administrator.bluetooth;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.bluetooth.other.ListViews;
import com.example.administrator.bluetooth.other.ListViewAdapter;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2016/2/23.
 */
public class ListViewActivity extends Activity {

    private List<ListViews> mData = null;
    private Context mContext;
    private ListViewAdapter mAdapter = null;
    private ListView list_view;
    private TextView txt_title;
    private ImageView show_menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        mContext = ListViewActivity.this;
        list_view = (ListView) findViewById(R.id.list_view);
        show_menu = (ImageView) findViewById(R.id.show_menu);
        txt_title = (TextView) findViewById(R.id.txt_title);
        txt_title.setText("列表展示");
        mData = new LinkedList<ListViews>();
        mData.add(new ListViews("小明", "你是小明么?", "16:00", R.mipmap.iv_icon_1));
        mData.add(new ListViews("小黑", "你是小黑么?", "16:10", R.mipmap.iv_icon_2));
        mData.add(new ListViews("小红", "你是小红么?", "16:20", R.mipmap.iv_icon_3));
        mData.add(new ListViews("小黄", "你是小黄么?", "16:30", R.mipmap.iv_icon_4));
        mData.add(new ListViews("小绿", "你是小绿么?", "16:40", R.mipmap.iv_icon_5));
        mAdapter = new ListViewAdapter((LinkedList<ListViews>) mData, mContext);
        list_view.setAdapter(mAdapter);

        show_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(ListViewActivity.this, show_menu);
                popup.getMenuInflater().inflate(R.menu.menu_pop, popup.getMenu());
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.lpig:
                                Toast.makeText(ListViewActivity.this, "你点了小明~", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.bpig:
                                Toast.makeText(ListViewActivity.this, "你点了小红~", Toast.LENGTH_SHORT).show();
                                break;
                        }
                        return true;
                    }
                });
                popup.show();
            }
        });
    }

    public void login_back(View v) {
        this.finish();
    }
}
