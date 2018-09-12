package com.example.user.lesson_android_development.main;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.example.user.lesson_android_development.R;

import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    ViewPager viewPager;
    int images[] = {R.drawable.image_1, R.drawable.image_2, R.drawable.image_3, R.drawable.image_2};
    ViewPagerAdapter myCustomPagerAdapter;
    TabLayout indicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_act);

        mToolbar = findViewById(R.id.toolbar);


        viewPager = (ViewPager) findViewById(R.id.viewPager);
        indicator=(TabLayout)findViewById(R.id.indicator);

        myCustomPagerAdapter = new ViewPagerAdapter(MainActivity.this, images);
        viewPager.setAdapter(myCustomPagerAdapter);
        indicator.setupWithViewPager(viewPager, true);

        /**
         * autorefresh
         */
//        Timer timer = new Timer();
//        timer.scheduleAtFixedRate(new SliderTimer(), 4000, 6000);
    }
//    private class SliderTimer extends TimerTask {
//
//        @Override
//        public void run() {
//            MainActivity.this.runOnUiThread(new Runnable() {
//                @Override
//                public void run() {
//                    if (viewPager.getCurrentItem() < images.length - 1) {
//                        viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
//                    } else {
//                        viewPager.setCurrentItem(0);
//                    }
//                }
//            });
//        }
//    }
    /**
     * Setting up the toolbar, toolbar actions & title
     */
    private void setupToolbar() {
        //toolbar setup
        setSupportActionBar(mToolbar);
        //setting the toolbar title
        getSupportActionBar().setTitle("Shop");
        //  getSupportActionBar().setHomeAsUpIndicator(R.drawable.clear_white);
        //setting up the back button on the toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    /**
     * OnClickListener for the toolbar back button
     */
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}


