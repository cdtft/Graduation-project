package com.cdut.shici;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.cdut.shici.adapter.MyFragmentPagerAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 城 on 2017/3/23.
 */

public class FragmentActivity extends AppCompatActivity {
    private static final int FRAGMENT_GAME = 0;
    private static final int FRAGMENT_VOICE = 1;
    private static final int FRAGMENT_RANK = 2;
    private static final int FRAGMENT_HOME = 3;

    @BindView(R.id.tabLayout) TabLayout mTabLayout;
    @BindView(R.id.viewPager) ViewPager mViewPager;
    @BindView(R.id.toolbar) Toolbar toolbar;
    private MyFragmentPagerAdapter mFragmentPagerAdapter;

    private TabLayout.Tab game;
    private TabLayout.Tab voice;
    private TabLayout.Tab rank;
    private TabLayout.Tab home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        ButterKnife.bind(this);
        initView();
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.mipmap.ic_action_dehaze);
        toolbar.setOnMenuItemClickListener(new MyMenuItemClickListener());
    }

    public void initView() {
        mFragmentPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager());

        mViewPager.setAdapter(mFragmentPagerAdapter);
        mViewPager.setCurrentItem(0);
        mViewPager.setOffscreenPageLimit(0);
        mTabLayout.setupWithViewPager(mViewPager);
        game = mTabLayout.getTabAt(FRAGMENT_GAME);
        voice = mTabLayout.getTabAt(FRAGMENT_VOICE);
        rank = mTabLayout.getTabAt(FRAGMENT_RANK);
        home = mTabLayout.getTabAt(FRAGMENT_HOME);
        game.setIcon(R.mipmap.ic_shortcut_adb);
        voice.setIcon(R.mipmap.ic_shortcut_keyboard_voice);
        rank.setIcon(R.mipmap.ic_shortcut_add);
        home.setIcon(R.mipmap.ic_shortcut_account_box);
    }
    class MyMenuItemClickListener implements Toolbar.OnMenuItemClickListener {

        @Override
        public boolean onMenuItemClick(MenuItem item) {
            switch (item.getItemId()) {
                case R.id.item_first:
                    Toast.makeText(FragmentActivity.this, "first", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.item_second:
                    Toast.makeText(FragmentActivity.this, "second", Toast.LENGTH_SHORT).show();
                    break;
                default:
                    break;
            }
            return true;
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
}
