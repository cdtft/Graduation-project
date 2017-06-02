package com.cdut.shici;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.*;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.cdut.shici.javabean.Poetry;
import com.cdut.shici.javabean.User;
import com.stephentuso.welcome.WelcomeHelper;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.datatype.BmobQueryResult;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.LogInListener;
import cn.bmob.v3.listener.SQLQueryListener;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by 城 on 2017/3/18.
 */

public class Login extends AppCompatActivity {

    private User user;
    private String username;
    private String password;
    @BindView(R.id.btn_login)
    Button bnt_redirect;
    WelcomeHelper welcomeHelper;

    @BindView(R.id.input_username)
    EditText inputUsername;

    @BindView(R.id.input_password)
    EditText inputPassword;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        welcomeHelper = new WelcomeHelper(this, WelcomePage.class);
        Bmob.initialize(Login.this, "85de6ff456a4d4331d15542f8a3b4bf9");
        welcomeHelper.forceShow();
        ButterKnife.bind(this);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        welcomeHelper.onSaveInstanceState(outState);
    }

    @OnClick(R.id.btn_login)
    public void redirect() {
        username = inputUsername.getText().toString();
        password = inputPassword.getText().toString();
        BmobUser.loginByAccount(username, password, new LogInListener<User>() {
            @Override
            public void done(User user, BmobException e) {
                if(user != null){
                    Intent intent = new Intent();
                    intent.setClass(Login.this, com.cdut.shici.FragmentActivity.class);
                    Login.this.startActivity(intent);
                }else {
                    Toast.makeText(Login.this, "登录失败", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @OnClick(R.id.link_signup)
    public void toRegister() {
        Intent intent = new Intent(Login.this, Register.class);
        startActivity(intent);
    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }
}
