package com.example.user.lesson_android_development;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private MainAdapter mMainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_atv);

        //find view
        mRecyclerView = findViewById(R.id.rv_main);

        //setup
        setupToolbar();

    }

    /**
     * toolbar
     */
    private void setupToolbar() {

        String imgLoad = "https://vacationidea.com/pix/img25Hy8R/articles/most-beautiful-places-in-the-world_f.jpg";

        ArrayList<Image> list = new ArrayList<Image>();
        list.add(new Image(imgLoad));

        mMainAdapter = new MainAdapter(getApplicationContext(), list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mMainAdapter);

    }
}
