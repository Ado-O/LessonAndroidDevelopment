package com.example.user.lesson_android_development;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_atv);

        //find view
        mToolbar = findViewById(R.id.main_abl);

        //setup
        setupToolbar();

    }
    /**
     * toolbar
     */
    private void setupToolbar() {
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("My Toolbar");
        ;
    }
}
