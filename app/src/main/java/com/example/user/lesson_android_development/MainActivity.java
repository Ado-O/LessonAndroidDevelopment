package com.example.user.lesson_android_development;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private MainAdapter mAdapter;
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_atv);

        //find view
        mListView=findViewById(R.id.list);

        //setup
        setupToolbar();

    }
    /**
     * toolbar
     */
    private void setupToolbar() {
        //Enter you code and add this method to OnCreate
        ArrayList<Movie> moviesList = new ArrayList<>();
        moviesList.add(new Movie("After Earth" , "2013"));
        moviesList.add(new Movie("After Earth" , "2013"));
        moviesList.add(new Movie("After Earth" , "2013"));

        mAdapter = new MainAdapter(this,moviesList);
        mListView.setAdapter(mAdapter);
    }
}
