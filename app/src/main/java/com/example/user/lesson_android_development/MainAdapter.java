package com.example.user.lesson_android_development;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.user.lesson_android_development.data.Name;
import com.example.user.lesson_android_development.databinding.ListItemBinding;

import java.util.ArrayList;
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter {

    private LayoutInflater mInflater;
    public List<Name> itemList = new ArrayList<Name>();

    //constructor
    public MainAdapter(Context context, List<Name> list) {

        mInflater = LayoutInflater.from(context);
        itemList = list;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MainViewHolder(ListItemBinding.inflate(mInflater, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((MainViewHolder) holder).setup(itemList.get(position));
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

}

