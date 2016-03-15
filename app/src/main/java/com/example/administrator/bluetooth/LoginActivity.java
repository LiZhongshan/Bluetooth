package com.example.administrator.bluetooth;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/3/2.
 */
public class LoginActivity extends Activity {
    //用所操作内容的标签命名
    private EditText mUser;
    private EditText mPassword;
    private TextView txt_title;
    private ImageView show_menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        //通过findViewById找到对应内容并赋值给命名标签
        mUser = (EditText)findViewById(R.id.login_uesr_edit);
        mPassword = (EditText)findViewById(R.id.login_passwd_edit);
        txt_title = (TextView) findViewById(R.id.txt_title);
        txt_title.setText("登陆");
        show_menu = (ImageView) findViewById(R.id.show_menu);
        show_menu.setVisibility(View.GONE);
    }
    //默认账号和密码都为1时通过验证
    public void login_mainfriend(View v) {
        if("1".equals(mUser.getText().toString()) && "1".equals(mPassword.getText().toString())){
            Intent intent = new Intent();
            intent.setClass(LoginActivity.this,MainActivity.class);
            startActivity(intent);
        }
        //错误提示
        else if("".equals(mUser.getText().toString()) || "".equals(mPassword.getText().toString())){
            new AlertDialog.Builder(LoginActivity.this)
                    .setIcon(getResources().getDrawable(R.drawable.login_error_icon))
                    .setTitle("登陆错误")
                    .setMessage("账号或密码不能为空，请重新输入")
                    .create().show();
        }
        else {
            new AlertDialog.Builder(LoginActivity.this)
                    .setIcon(getResources().getDrawable(R.drawable.login_error_icon))
                    .setTitle("登陆错误")
                    .setMessage("账号或密码输入错误，请重新输入")
                    .create().show();
        }
    }
    //返回事件（返回上一页）
    public void login_back(View v) {
        this.finish();
    }
    //页面跳转，跳转到注册页面
    public void register(View v) {
        Intent intent = new Intent (LoginActivity.this,RegisterActivity.class);
        startActivity(intent);
    }
}
