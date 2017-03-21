package com.cdut.shici;

import com.stephentuso.welcome.BasicPage;
import com.stephentuso.welcome.WelcomeActivity;
import com.stephentuso.welcome.WelcomeConfiguration;

/**
 * Created by 城 on 2017/3/18.
 */

public class WelcomePage extends WelcomeActivity {
    @Override
    protected WelcomeConfiguration configuration() {
        return new WelcomeConfiguration.Builder(this)
                .defaultBackgroundColor(R.color.blue_background)
                .page(new BasicPage(R.drawable.castle,
                        "还有诗和远方",
                        "生活不止眼前的苟且")
                )
                .page(new BasicPage(R.drawable.graduate,
                        "读万卷书",
                        "行万里路")
                )
                .page(new BasicPage(R.drawable.basketball_jersey,
                        "The future is your",
                        "")
                )
                .swipeToDismiss(true)
                .build();
    }
}
