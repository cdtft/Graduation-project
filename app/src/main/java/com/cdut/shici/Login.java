package com.cdut.shici;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.stephentuso.welcome.WelcomeHelper;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by 城 on 2017/3/18.
 */

public class Login extends AppCompatActivity{
    @BindView(R.id.btn_login) Button bnt_redirect;
    WelcomeHelper welcomeHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        welcomeHelper = new WelcomeHelper(this, WelcomePage.class);
        welcomeHelper.forceShow();
        ButterKnife.bind(this);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        welcomeHelper.onSaveInstanceState(outState);
    }

    @OnClick(R.id.btn_login)
    public void redirect(){
        Intent toMe = new Intent(Login.this, MeActivity.class);
        Login.this.startActivity(toMe);
    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }
}
