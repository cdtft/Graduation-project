package com.cdut.shici;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.stephentuso.welcome.WelcomeHelper;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by 城 on 2017/3/15.
 */

public class MeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.me_imageView_adb, R.id.me_imageView_add, R.id.me_imageView_voice})
    public void redirect(View v){
        switch(v.getId()){
            case R.id.me_imageView_adb:
                Intent toMain = new Intent(MeActivity.this, MainActivity.class);
                startActivity(toMain);
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.fade_out);
                break;
            case R.id.me_imageView_voice:
                Intent toVice = new Intent(MeActivity.this, VoiceActivity.class);
                startActivity(toVice);
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.fade_out);
                break;
            case R.id.me_imageView_add:
                Intent toRank = new Intent(MeActivity.this, RankActivity.class);
                startActivity(toRank);
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.fade_out);
                break;
            default:
                break;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }

}
