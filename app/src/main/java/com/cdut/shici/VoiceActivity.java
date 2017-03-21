package com.cdut.shici;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by 城 on 2017/3/15.
 */

public class VoiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voice);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.voice_imageView_adb, R.id.voice_imageView_add, R.id.voice_imageView_me})
    public void redirect(View v){
        switch(v.getId()){
            case R.id.voice_imageView_adb:
                Intent toMain = new Intent(VoiceActivity.this, MainActivity.class);
                startActivity(toMain);
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
                break;
            case R.id.voice_imageView_add:
                Intent toRank = new Intent(VoiceActivity.this, RankActivity.class);
                startActivity(toRank);
                break;
            case R.id.voice_imageView_me:
                Intent toMe = new Intent(VoiceActivity.this, MeActivity.class);
                startActivity(toMe);
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
