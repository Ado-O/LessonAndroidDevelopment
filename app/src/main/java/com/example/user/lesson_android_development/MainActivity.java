package com.example.user.lesson_android_development;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.user.lesson_android_development.data.Name;
import com.example.user.lesson_android_development.data.NameLocalDataSource;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MainAdapter mMainAdapter;
    private RecyclerView mRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_atv);

        mRecyclerView = (RecyclerView) findViewById(R.id.rv_main);

        //setup
        setupToolbar();

    }

    /**
     * toolbar
     */
    private void setupToolbar() {


        NameLocalDataSource source = new NameLocalDataSource(this);

        source.getDelete();

        String Lorem = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been ";

        source.insertName(new Name(null, R.drawable.aa, "Baby", Lorem));
        source.insertName(new Name(null, R.drawable.doctor_strange, "Doctor Strange", Lorem));
        source.insertName(new Name(null, R.drawable.nnn, "nnn", Lorem));
        source.insertName(new Name(null, R.drawable.maze_runner, "Maze Runner", Lorem));
        source.insertName(new Name(null, R.drawable.bbb, "Spider-Man Homecoming", Lorem));

        source.getName(new NameLocalDataSource.Callback() {
            @Override
            public void onSuccess(List<Name> name) {

                mMainAdapter = new MainAdapter(MainActivity.this, name);
                mRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                mRecyclerView.setAdapter(mMainAdapter);

                }

            @Override
            public void onError() {

            }
        });


    }

}
