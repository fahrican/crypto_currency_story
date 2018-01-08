package com.android.example.cryptocurrencystory.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.android.example.cryptocurrencystory.R;
import com.android.example.cryptocurrencystory.model.Choice;

public class StoryActivity extends AppCompatActivity {

    private static final String LOG_TAG = StoryActivity.class.getSimpleName();
    private ImageView image;
    private String story;
    private Choice choice1;
    private Choice choice2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);


    }
}
