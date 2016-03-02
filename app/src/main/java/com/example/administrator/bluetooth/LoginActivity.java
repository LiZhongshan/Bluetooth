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
    private EditText mUser;
    private EditText mPassword;
    private TextView txt_title;
    private ImageView img_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        mUser = (EditText)findViewById(R.id.login_uesr_edit);
        mPassword = (EditText)findViewById(R.id.login_passwd_edit);
        txt_title = (TextView) findViewById(R.id.txt_title);
        txt_title.setText("登陆");
        img_back = (ImageView) findViewById(R.id.img_back);
        img_back.setVisibility(View.VISIBLE);
    }

    public void login_mainfriend(View v) {
        if("1".equals(mUser.getText().toString()) && "1".equals(mPassword.getText().toString())){
            Intent intent = new Intent();
            intent.setClass(LoginActivity.this,MainActivity.class);
            startActivity(intent);
        }
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
    public void login_back(View v) {
        this.finish();
    }
    public void register(View v) {
        Intent intent = new Intent (LoginActivity.this,RegisterActivity.class);
        startActivity(intent);
    }
}
