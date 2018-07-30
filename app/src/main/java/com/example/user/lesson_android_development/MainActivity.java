package com.example.user.lesson_android_development;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_atv);

        mTextView = findViewById(R.id.tv_main);

        //setup
        setupToolbar();

    }

    /**
     * toolbar
     */
    private void setupToolbar() {

        NameLocalDataSource source = new NameLocalDataSource(this);

        source.insertName(new Name(
                null,
                "Something"
        ));

        source.getName(new NameLocalDataSource.Callback() {
            @Override
            public void onSuccess(List<Name> name) {
                final String textName = String.valueOf(name.get(0).getName());

                mTextView.setText(textName);

            }

            @Override
            public void onError() {

            }
        });


    }
}
