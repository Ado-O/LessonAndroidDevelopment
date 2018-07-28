package com.example.user.lesson_android_development;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.lesson_android_development.data.Item;

public class ViewHolderThree extends RecyclerView.ViewHolder {

    private ImageView mIcon;
    private TextView mTextView;

    public ViewHolderThree(@NonNull View itemView) {
        super(itemView);

        mIcon = itemView.findViewById(R.id.iv_icon);
        mTextView = itemView.findViewById(R.id.tv_iconText);
    }

    public void setupThree(Item item) {

        mIcon.setImageResource(item.getImage());
        mTextView.setText(item.getFirstText());

    }
}