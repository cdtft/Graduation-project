package com.cdut.shici;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by 城 on 2017/3/15.
 */

public class RankActivity extends AppCompatActivity{
    @BindView(R.id.rank_imageView_adb)
    ImageView iv_adb;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_rank);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.rank_imageView_adb, R.id.rank_imageView_voice, R.id.rank_imageView_me})
    public void redirect(View view){
        switch(view.getId()){
            case R.id.rank_imageView_adb:
                Intent toMain = new Intent(RankActivity.this, MainActivity.class);
                RankActivity.this.startActivity(toMain);
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.fade_out);
                break;
            case R.id.rank_imageView_voice:
                Intent toVoice = new Intent(RankActivity.this, VoiceActivity.class);
                startActivity(toVoice);
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.fade_out);
                break;
            case R.id.rank_imageView_me:
                Intent toMe = new Intent(RankActivity.this, MeActivity.class);
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
