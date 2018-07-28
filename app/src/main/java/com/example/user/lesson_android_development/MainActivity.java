package com.example.user.lesson_android_development;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.user.lesson_android_development.util.ActivityUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_atv);

        //find view

        //setup
        setupToolbar();

    }
    /**
     * toolbar
     */
    private void setupToolbar() {
        ActivityUtils.replaceFragmentInActivity(
                getSupportFragmentManager(),
                MainOneFragment.newInstance(),
                R.id.container
        );
    }
}
