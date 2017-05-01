package com.cdut.shici;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.Bmob;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Bmob.initialize(Register.this, "85de6ff456a4d4331d15542f8a3b4bf9");
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_register)
    public void register(){
        Intent intent = new Intent();
        setResult(RESULT_OK, intent);
        finish();
    }
}
