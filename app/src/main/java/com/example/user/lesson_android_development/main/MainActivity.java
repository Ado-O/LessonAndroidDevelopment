package com.example.user.lesson_android_development.main;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.example.user.lesson_android_development.R;
import com.example.user.lesson_android_development.data.Item;
import com.example.user.lesson_android_development.databinding.FragmentBottomSheetBinding;

public class MainActivity extends AppCompatActivity {

    private FragmentBottomSheetBinding mFragmentBottomSheetBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_atv);

        mFragmentBottomSheetBinding = DataBindingUtil.setContentView(this, R.layout.fragment_bottom_sheet);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void myFancyMethod(View view) {


       BottomSheetDialogFragment bottomSheetDialogFragment = new BottomSheetFragment();
       bottomSheetDialogFragment.show(getSupportFragmentManager(), "Bottom Sheet Dialog Fragment");


    }

}

