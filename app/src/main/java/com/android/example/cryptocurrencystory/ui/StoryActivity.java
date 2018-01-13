package com.android.example.cryptocurrencystory.ui;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.example.cryptocurrencystory.R;
import com.android.example.cryptocurrencystory.model.Choice;
import com.android.example.cryptocurrencystory.model.Page;
import com.android.example.cryptocurrencystory.model.Story;

public class StoryActivity extends AppCompatActivity {

    private static final String LOG_TAG = StoryActivity.class.getSimpleName();

    private Story story;

    private ImageView storyImage;
    private TextView storyTextView;
    private Button choice1;
    private Button choice2;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        this.storyImage = (ImageView) findViewById(R.id.pageImage);
        this.storyTextView = (TextView) findViewById(R.id.pageText);
        this.choice1 = (Button) findViewById(R.id.choice1);
        this.choice2 = (Button) findViewById(R.id.choice2);

        Intent intent = getIntent();
        name = intent.getStringExtra(getString(R.string.user_name_key));
        if (name == null || name.isEmpty()) {
            name = "friend";
        }
        Log.d(LOG_TAG, "name: " + name);

        story = new Story();
        loadPage(0);
    }

    private void loadPage(int pageNumber) {

        final Page page = story.getPage(pageNumber);

        Drawable pageImage = ContextCompat.getDrawable(this, page.getImageId());
        storyImage.setImageDrawable(pageImage);

        String pageText = getString(page.getTextId());
        pageText = String.format(pageText, name);

        storyTextView.setText(pageText);
        choice1.setText(page.getChoice1().getTextId());
        choice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                loadPage(page.getChoice1().getNextPage());
            }
        });
        choice2.setText(page.getChoice2().getTextId());
        choice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
                loadPage(page.getChoice2().getNextPage());
            }
        });
    }
}
