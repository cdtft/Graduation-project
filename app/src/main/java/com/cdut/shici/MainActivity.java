package com.cdut.shici;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cdut.shici.javabean.Poetry;
import com.dd.CircularProgressButton;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.datatype.BmobQueryResult;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SQLQueryListener;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private CircularProgressButton btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9;
    private CircularProgressButton submit, reset;
    private TextView tv_poetry;
    private ImageView iv_adb, iv_add, iv_rank, iv_me;
    private StringBuilder poetry;//拼接用户填入的字符便于进行验证
    private Integer number = 1;//当前关数
    private Poetry poetryBean;
    private String word9;//取出的9字诗词
    private TextView tv_number;
    private static final int BUTTON_STATUS_BEFORE = 0;
    private static final int BUTTON_STATUS_AFTER = 100;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        Bmob.initialize(MainActivity.this, "85de6ff456a4d4331d15542f8a3b4bf9");
        poetry = new StringBuilder();
        initView();
        initButtonStatus();
        queryPoetry(number);//查询并设置回显
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.mipmap.ic_action_dehaze);
        toolbar.setOnMenuItemClickListener(new MyMenuItemClickListener());
        setButtonOnClickListener();
    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
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
        submit = (CircularProgressButton) findViewById(R.id.button_submit);
        reset = (CircularProgressButton) findViewById(R.id.button_reset);
        tv_number = (TextView) findViewById(R.id.textview_number);
        iv_adb = (ImageView) findViewById(R.id.main_imageView_adb);
        iv_add = (ImageView) findViewById(R.id.main_imageView_voice);
        iv_rank = (ImageView) findViewById(R.id.main_imageView_add);
        iv_me = (ImageView) findViewById(R.id.main_imageView_me);
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
        iv_adb.setOnClickListener(this);
        iv_add.setOnClickListener(this);
        iv_rank.setOnClickListener(this);
        iv_me.setOnClickListener(this);
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
                if (btn_4.getProgress() == BUTTON_STATUS_BEFORE) {
                    btn_4.setProgress(BUTTON_STATUS_AFTER);
                    poetry.append(str4);
                    tv_poetry.setText(poetry);
                }
                break;
            case R.id.button_5:
                String str5 = btn_5.getText().toString();
                if (btn_5.getProgress() == BUTTON_STATUS_BEFORE) {
                    btn_5.setProgress(BUTTON_STATUS_AFTER);
                    poetry.append(str5);
                    tv_poetry.setText(poetry);
                }
                break;
            case R.id.button_6:
                String str6 = btn_6.getText().toString();
                if (btn_6.getProgress() == BUTTON_STATUS_BEFORE) {
                    btn_6.setProgress(BUTTON_STATUS_AFTER);
                    poetry.append(str6);
                    tv_poetry.setText(poetry);
                }
                break;
            case R.id.button_7:
                String str7 = btn_7.getText().toString();
                if (btn_7.getProgress() == BUTTON_STATUS_BEFORE) {
                    btn_7.setProgress(BUTTON_STATUS_AFTER);
                    poetry.append(str7);
                    tv_poetry.setText(poetry);
                }
                break;
            case R.id.button_8:
                String str8 = btn_8.getText().toString();
                if (btn_8.getProgress() == BUTTON_STATUS_BEFORE) {
                    btn_8.setProgress(BUTTON_STATUS_AFTER);
                    poetry.append(str8);
                    tv_poetry.setText(poetry);
                }
                break;
            case R.id.button_9:
                String str9 = btn_9.getText().toString();
                if (btn_9.getProgress() == BUTTON_STATUS_BEFORE) {
                    btn_9.setProgress(BUTTON_STATUS_AFTER);
                    poetry.append(str9);
                    tv_poetry.setText(poetry);
                }
                break;
            case R.id.button_submit:
                boolean isRight = checkData();
                if (isRight) {
                    submit.setProgress(100);
                    queryPoetry(number);
                    tv_poetry.setText("");
                    poetry.delete(0, poetry.length());
                    //TODO 重新初始化按钮状态
                    initButtonStatus();
                    initData(poetryBean);
                } else {
                    submit.setProgress(-1);
                    tv_poetry.setText("");
                    initButtonStatus();
                    initData(poetryBean);
                    poetry.delete(0, poetry.length());
                    Toast.makeText(this, "填写错误", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.button_reset:
                //TODO 重新初始化按钮的状态
                reset.setProgress(100);
                initButtonStatus();
                initData(poetryBean);
                poetry.delete(0, poetry.length());
                tv_poetry.setText(poetry);
                break;
            case R.id.main_imageView_voice:
                Intent toVoice = new Intent(MainActivity.this, VoiceActivity.class);
                startActivity(toVoice);
                break;
            case R.id.main_imageView_add:
                Intent toRank = new Intent(MainActivity.this, RankActivity.class);
                MainActivity.this.startActivity(toRank);
                break;
            case R.id.main_imageView_me:
                Intent toMe = new Intent(MainActivity.this, MeActivity.class);
                startActivity(toMe);
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
        reset.setProgress(0);
        submit.setProgress(0);
    }

    class MyMenuItemClickListener implements Toolbar.OnMenuItemClickListener {

        @Override
        public boolean onMenuItemClick(MenuItem item) {
            switch (item.getItemId()) {
                case R.id.item_first:
                    Toast.makeText(MainActivity.this, "first", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.item_second:
                    Toast.makeText(MainActivity.this, "second", Toast.LENGTH_SHORT).show();
                    break;
                default:
                    break;
            }
            return true;
        }
    }
}
