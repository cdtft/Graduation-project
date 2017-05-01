package com.cdut.shici.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.cdut.shici.fragment.Game;
import com.cdut.shici.fragment.Home;
import com.cdut.shici.fragment.Rank;
import com.cdut.shici.fragment.Voice;


/**
 * Created by 城 on 2017/3/22.
 */

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    private static final int FRAGMENT_GAME = 0;
    private static final int FRAGMENT_VOICE = 1;
    private static final int FRAGMENT_RANK = 2;
    private static final int FRAGMENT_HOME = 3;
    private String[] mTitle = new String[]{"九宫格", "飞花令", "琅琊榜", "我"};


    public MyFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == FRAGMENT_GAME) {
            return new Game();
        } else if (position == FRAGMENT_RANK) {
            return new Rank();
        } else if (position == FRAGMENT_VOICE) {
            return new Voice();
        } else if (position == FRAGMENT_HOME) {
            return new Home();
        }
        return null;
    }

    @Override
    public int getCount() {
        return mTitle.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitle[position];
    }


}
