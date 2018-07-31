package com.example.user.lesson_android_development;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.user.lesson_android_development.data.storage.ContentRepository;
import com.example.user.lesson_android_development.data.storage.Exercise;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ContentRepository mContentRepository;
    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_atv);

        mImageView = findViewById(R.id.iv_main);

        mContentRepository = new ContentRepository();

        mContentRepository.getContent(new ContentRepository.GetContentCallback() {
            @Override
            public void onSuccess(List<Exercise> exercises) {
                //Toast.makeText(MainActivity.this, exercises.get(0).getImage() + "", Toast.LENGTH_SHORT).show();
                Glide.with(MainActivity.this).load(exercises.get(0).getImage()).into(mImageView);
            }

            @Override
            public void onError() {
                Toast.makeText(MainActivity.this, "errorr ba", Toast.LENGTH_SHORT).show();

            }
        });

    }
}
