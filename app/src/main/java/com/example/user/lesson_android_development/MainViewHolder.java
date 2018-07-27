package com.example.user.lesson_android_development;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.user.lesson_android_development.databinding.ListItemBinding;

public class MainViewHolder {

    private ListItemBinding mBinding;

    public MainViewHolder(@NonNull ListItemBinding binding) {
       super(binding.getRoot());

        mBinding = binding;
    }


    public void setup(Name name) {
        mBinding.setName(name);
    }
}
