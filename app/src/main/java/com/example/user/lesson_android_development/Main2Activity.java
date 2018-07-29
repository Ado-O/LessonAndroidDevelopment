package com.example.user.lesson_android_development;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    public TextView textView;
    public TextView toolbar_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_atv_second);

        textView = findViewById(R.id.tv_second);
        //enter layout text
        toolbar_title = findViewById(R.id.toolbar_title);

        String course = getIntent().getExtras().getString("course","");
        int numberIntent = getIntent().getExtras().getInt("course2",0);
        textView.setText(course);

        toolbar_title.setText("Activity " + numberIntent);
    }
}
