package com.example.user.lesson_android_development;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.lesson_android_development.data.Item;

public class ViewHolderTwo extends RecyclerView.ViewHolder {
    public TextView tvLeft, tvRight;
    private ImageView imCentar;

    public ViewHolderTwo(@NonNull View itemView) {
        super(itemView);

        tvLeft = (TextView) itemView.findViewById(R.id.row_item_left);
        tvRight = (TextView) itemView.findViewById(R.id.row_item_right);
        imCentar = (ImageView) itemView.findViewById(R.id.iv_image);
    }

    public void setupTwo(Item item) {

        tvLeft.setText(item.getFirstText());
        tvRight.setText(item.getSecondText());
        imCentar.setImageResource(item.getImage());
    }
}
