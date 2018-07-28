package com.example.user.lesson_android_development;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.user.lesson_android_development.data.Item;

public class ViewHolderOne extends RecyclerView.ViewHolder {

    public TextView mTextView;

    public ViewHolderOne(@NonNull View itemView) {
        super(itemView);

        mTextView = (TextView) itemView.findViewById(R.id.row_item);

    }

    public void setupOne(Item item) {

        mTextView.setText(item.getFirstText());

    }
}