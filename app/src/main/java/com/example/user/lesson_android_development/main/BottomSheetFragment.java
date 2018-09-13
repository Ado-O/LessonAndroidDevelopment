package com.example.user.lesson_android_development.main;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.design.widget.CoordinatorLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.user.lesson_android_development.R;
import com.example.user.lesson_android_development.databinding.FragmentBottomSheetBinding;

public class BottomSheetFragment extends BottomSheetDialogFragment {

    private FragmentBottomSheetBinding mFragmentBottomSheetBinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mFragmentBottomSheetBinding = FragmentBottomSheetBinding.inflate(inflater, container, false);

//        mFragmentBottomSheetBinding.btGoPro.setOnClickListener(view -> {
//            LinkUtils.openLink(getContext(), getString(R.string.appLink_pro));
//        });

        return mFragmentBottomSheetBinding.getRoot();
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        BottomSheetDialog dialog = (BottomSheetDialog) super.onCreateDialog(savedInstanceState);

        dialog.setOnShowListener(dialogInterface -> {
            BottomSheetDialog d = (BottomSheetDialog) dialogInterface;

            FrameLayout bottomSheet = (FrameLayout) d.findViewById(android.support.design.R.id.design_bottom_sheet);
            BottomSheetBehavior bsb = BottomSheetBehavior
                    .from(bottomSheet);

            bsb.setState(BottomSheetBehavior.STATE_EXPANDED);

        });


        return dialog;
    }
}