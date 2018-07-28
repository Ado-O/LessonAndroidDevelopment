package com.example.user.lesson_android_development;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.user.lesson_android_development.data.Item;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private MainAdapter mMainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_atv);

        //find view
        mRecyclerView = (RecyclerView) findViewById(R.id.main_rv);

        //setup
        setupToolbar();

    }
    /**
     * toolbar
     */
    private void setupToolbar() {
        ArrayList<Item> itemList = new ArrayList<Item>();

        mMainAdapter = new MainAdapter(this, itemList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mMainAdapter);

        itemList.add(new Item(0, "Single line", "", Item.ItemType.ONE_ITEM));
        itemList.add(new Item(R.drawable.download, "Single line", "Single Line", Item.ItemType.TWO_ITEM));
        itemList.add(new Item(R.drawable.ic_android_black, "Single line", "", Item.ItemType.THREE_ITEM));
    }
}
