package com.example.user.lesson_android_development;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.user.lesson_android_development.data.storage.Exercise;

public class MainViewHolder  extends RecyclerView.ViewHolder{

private ImageView mImageView;
private TextView mName;

    public MainViewHolder(@NonNull View itemView) {
        super(itemView);

        mImageView = itemView.findViewById(R.id.iv_excersis);
        mName = itemView.findViewById(R.id.tv_title);
    }

    public void setup(Exercise exercise){
        Glide.with(itemView.getContext())
                .load(exercise.getImage())
                .into(mImageView);

        mName.setText(exercise.getTitle());

    }
}
