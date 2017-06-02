package com.cdut.shici;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.cdut.shici.javabean.User;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.datatype.BmobQueryResult;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SQLQueryListener;
import cn.bmob.v3.listener.SaveListener;

public class Register extends AppCompatActivity {

    @BindView(R.id.input_username_register)
    EditText register_username;
    @BindView(R.id.input_password_register)
    EditText register_password;
    @BindView(R.id.input_password_register_repeat)
    EditText register_repeat_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Bmob.initialize(Register.this, "85de6ff456a4d4331d15542f8a3b4bf9");
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_register)
    public void register(){
        String username = register_username.getText().toString();
        String password = register_password.getText().toString();
        String password_repeat = register_repeat_password.getText().toString();
        if(password.equals(password_repeat)){
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setCurrent(1);
            user.signUp(new SaveListener<User>() {
                @Override
                public void done(User user, BmobException e) {
                    if(e == null){
                        Intent intent = new Intent(Register.this, FragmentActivity.class);
                        startActivity(intent);
                    }else {
                        Toast.makeText(Register.this, "用户名重复", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }else {
            Toast.makeText(this, "两次密码不一致", Toast.LENGTH_SHORT).show();
        }
    }
}
