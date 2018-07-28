package com.example.user.lesson_android_development;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.lesson_android_development.databinding.ListItemBinding;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter {

    private ArrayList<Image> mList;
    private LayoutInflater mInflater;

    public MainAdapter(Context context, ArrayList<Image> list) {
        mInflater = LayoutInflater.from(context);
        mList = list;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MainViewHolder(ListItemBinding.inflate(mInflater, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
       ((MainViewHolder)holder).setup(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}
