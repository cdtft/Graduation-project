package com.cdut.shici;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.cdut.shici.javabean.Poetry;
import com.cdut.shici.javabean.User;
import com.dd.CircularProgressButton;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.datatype.BmobQueryResult;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SQLQueryListener;
import cn.bmob.v3.listener.SaveListener;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private CircularProgressButton btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9;
    private Button submit, reset;
    private TextView tv_poetry;
    private StringBuilder poetry;//拼接用户填入的字符便于进行验证
    private Integer number = 1;//当前关数
    private Poetry poetryBean;
    private String word9;//取出的9字诗词
    private TextView tv_number;
    private static final int BUTTON_STATUS_BEFORE = 0;
    private static final int BUTTON_STATUS_AFTER = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        Bmob.initialize(MainActivity.this, "85de6ff456a4d4331d15542f8a3b4bf9");
        poetry = new StringBuilder();
        initView();
        queryPoetry(number);
        setButtonOnClickListener();
    }

    //初始化控件
    private void initView() {
        btn_1 = (CircularProgressButton) findViewById(R.id.button_1);
        btn_2 = (CircularProgressButton) findViewById(R.id.button_2);
        btn_3 = (CircularProgressButton) findViewById(R.id.button_3);
        btn_4 = (CircularProgressButton) findViewById(R.id.button_4);
        btn_5 = (CircularProgressButton) findViewById(R.id.button_5);
        btn_6 = (CircularProgressButton) findViewById(R.id.button_6);
        btn_7 = (CircularProgressButton) findViewById(R.id.button_7);
        btn_8 = (CircularProgressButton) findViewById(R.id.button_8);
        btn_9 = (CircularProgressButton) findViewById(R.id.button_9);
        tv_poetry = (TextView) findViewById(R.id.textview_poetry);
        submit = (Button) findViewById(R.id.button_submit);
        reset = (Button) findViewById(R.id.button_reset);
        tv_number = (TextView) findViewById(R.id.textview_number);
    }

    //对button绑定点击事件
    private void setButtonOnClickListener() {
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
        btn_6.setOnClickListener(this);
        btn_7.setOnClickListener(this);
        btn_8.setOnClickListener(this);
        btn_9.setOnClickListener(this);
        submit.setOnClickListener(this);
        reset.setOnClickListener(this);
    }

    //查询诗词
    private void queryPoetry(Integer n) {
        String bql = "select * from Poetry where number = ?";
        new BmobQuery<Poetry>().doSQLQuery(bql, new SQLQueryListener<Poetry>() {
            @Override
            public void done(BmobQueryResult<Poetry> bmobQueryResult, BmobException e) {
                if (e == null) {
                    List<Poetry> list = bmobQueryResult.getResults();
                    poetryBean = list.get(0);
                    initData(poetryBean);
                }
            }
        }, n);
        number = number + 1;
    }

    //随机回显对应的数据
    private void initData(Poetry poetryBean) {
        word9 = poetryBean.getPoetryWord();
        Integer n = poetryBean.getNumber();
        ArrayList<Character> list = new ArrayList<>();
        ArrayList<Character> afterList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 9; i++) {
            list.add(i, word9.charAt(i));
        }
        //打乱链表中数据存放的位置
        while (list.size() > 0) {
            int index = random.nextInt(list.size());
            afterList.add(list.get(index));
            list.remove(index);
        }
        btn_1.setIdleText(afterList.get(0).toString());
        btn_1.setText(afterList.get(0).toString());
        btn_2.setIdleText(afterList.get(1).toString());
        btn_2.setText(afterList.get(1).toString());
        btn_3.setIdleText(afterList.get(2).toString());
        btn_3.setText(afterList.get(2).toString());
        btn_4.setIdleText(afterList.get(3).toString());
        btn_4.setText(afterList.get(3).toString());
        btn_5.setIdleText(afterList.get(4).toString());
        btn_5.setText(afterList.get(4).toString());
        btn_6.setIdleText(afterList.get(5).toString());
        btn_6.setText(afterList.get(5).toString());
        btn_7.setIdleText(afterList.get(6).toString());
        btn_7.setText(afterList.get(6).toString());
        btn_8.setIdleText(afterList.get(7).toString());
        btn_8.setText(afterList.get(7).toString());
        btn_9.setIdleText(afterList.get(8).toString());
        btn_9.setText(afterList.get(8).toString());
        tv_number.setText(n.toString());
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.button_1:
                String str1 = btn_1.getIdleText();
                if (btn_1.getProgress() == BUTTON_STATUS_BEFORE) {
                    btn_1.setProgress(BUTTON_STATUS_AFTER);
                    poetry.append(str1);
                    tv_poetry.setText(poetry);
                }
                break;
            case R.id.button_2:
                String str2 = btn_2.getText().toString();
                if (btn_2.getProgress() == BUTTON_STATUS_BEFORE) {
                    btn_2.setProgress(BUTTON_STATUS_AFTER);
                    poetry.append(str2);
                    tv_poetry.setText(poetry);
                }
                break;
            case R.id.button_3:
                String str3 = btn_3.getText().toString();
                if (btn_3.getProgress() == BUTTON_STATUS_BEFORE) {
                    btn_3.setProgress(BUTTON_STATUS_AFTER);
                    poetry.append(str3);
                    tv_poetry.setText(poetry);
                }
                break;
            case R.id.button_4:
                String str4 = btn_4.getText().toString();
                if (btn_4.getProgress() == BUTTON_STATUS_BEFORE){
                    btn_4.setProgress(BUTTON_STATUS_AFTER);
                    poetry.append(str4);
                    tv_poetry.setText(poetry);
                }
                break;
            case R.id.button_5:
                String str5 = btn_5.getText().toString();
                if(btn_5.getProgress() == BUTTON_STATUS_BEFORE){
                    btn_5.setProgress(BUTTON_STATUS_AFTER);
                    poetry.append(str5);
                    tv_poetry.setText(poetry);
                }
                break;
            case R.id.button_6:
                String str6 = btn_6.getText().toString();
                if (btn_6.getProgress() == BUTTON_STATUS_BEFORE){
                    btn_6.setProgress(BUTTON_STATUS_AFTER);
                    poetry.append(str6);
                    tv_poetry.setText(poetry);
                }
                break;
            case R.id.button_7:
                String str7 = btn_7.getText().toString();
                if(btn_7.getProgress() == BUTTON_STATUS_BEFORE){
                    btn_7.setProgress(BUTTON_STATUS_AFTER);
                    poetry.append(str7);
                    tv_poetry.setText(poetry);
                }
                break;
            case R.id.button_8:
                String str8 = btn_8.getText().toString();
                if(btn_8.getProgress() == BUTTON_STATUS_BEFORE){
                    btn_8.setProgress(BUTTON_STATUS_AFTER);
                    poetry.append(str8);
                    tv_poetry.setText(poetry);
                }
                break;
            case R.id.button_9:
                String str9 = btn_9.getText().toString();
                if(btn_9.getProgress() == BUTTON_STATUS_BEFORE){
                    btn_9.setProgress(BUTTON_STATUS_AFTER);
                    poetry.append(str9);
                    tv_poetry.setText(poetry);
                }
                break;
            case R.id.button_submit:
                boolean isRight = checkData();
                if (isRight) {
                    queryPoetry(number);
                    tv_poetry.setText("");
                    poetry.delete(0, poetry.length());
                    //TODO 重新初始化按钮状态
                    initButtonStatus();
                    initData(poetryBean);
                } else {
                    tv_poetry.setText("");
                    initButtonStatus();
                    initData(poetryBean);
                    poetry.delete(0, poetry.length());
                    Toast.makeText(this, "填写错误", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.button_reset:
                //TODO 重新初始化按钮的状态
                initButtonStatus();
                initData(poetryBean);
                poetry.delete(0, poetry.length());
                tv_poetry.setText(poetry);
                break;
            default:
                break;
        }
    }

    //校验答案
    private boolean checkData() {
        String select = tv_poetry.getText().toString();
        String key = poetryBean.getKey();
        if (select.equals(key)) {
            return true;
        } else {
            return false;
        }
    }

    //初始化按钮的状态
    private void initButtonStatus() {
        btn_1.setProgress(0);
        btn_2.setProgress(0);
        btn_3.setProgress(0);
        btn_4.setProgress(0);
        btn_5.setProgress(0);
        btn_6.setProgress(0);
        btn_7.setProgress(0);
        btn_8.setProgress(0);
        btn_9.setProgress(0);
    }
}
