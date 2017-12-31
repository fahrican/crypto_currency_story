package com.android.example.cryptocurrencystory.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.example.cryptocurrencystory.R;

public class MainActivity extends AppCompatActivity {

    private TextView mainPageText;
    private EditText userInput;
    private Button startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //here gets the member variables declared to put later content on the main activity
        mainPageText = (TextView) findViewById(R.id.mainPagText);
        userInput = (EditText) findViewById(R.id.userInput);
        startButton = (Button) findViewById(R.id.startButton);

        mainPageText.setText(getString(R.string.main_page_text));
        final String userName = userInput.toString();
        startButton.setText(getString(R.string.start_button));

        //when the button on the main activity gets clicked, an intent gets created to start the story
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, StoryActivity.class);
                intent.putExtra(getString(R.string.user_name_key), userName);
                startActivity(intent);
            }
        });
    }
}
