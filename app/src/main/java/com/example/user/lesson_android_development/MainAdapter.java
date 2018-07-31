package com.example.user.lesson_android_development;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.user.lesson_android_development.data.storage.Exercise;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter {

    private List<Exercise> mList;
    private LayoutInflater mInflater;
    private Context mContext;

    public MainAdapter(Context context, List<Exercise> list) {
        mInflater = LayoutInflater.from(context);
        mList = list;

        mContext = context;

    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MainViewHolder(mInflater.inflate(R.layout.list_item, parent,false));
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
