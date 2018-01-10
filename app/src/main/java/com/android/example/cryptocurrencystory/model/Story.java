package com.android.example.cryptocurrencystory.model;

import com.android.example.cryptocurrencystory.R;

public class Story {

    private Page[] stories;

    public Story (){

        stories = new Page[7];

        stories[0] = new Page(R.drawable.page0,
                R.string.page0,
                new Choice(R.string.page1_choice1, 1),
                new Choice(R.string.page1_choice2, 2));


        stories[1] = new Page(R.drawable.page1,
                R.string.page1,
                new Choice(R.string.page1_choice1, 3),
                new Choice(R.string.page1_choice2, 4));

        stories[2] = new Page(R.drawable.page2,
                R.string.page2,
                new Choice(R.string.page2_choice1, 4),
                new Choice(R.string.page2_choice2, 6));

        stories[3] = new Page(R.drawable.page3,
                R.string.page3,
                new Choice(R.string.page3_choice1, 4),
                new Choice(R.string.page3_choice2, 5));

        stories[4] = new Page(R.drawable.page4,
                R.string.page4,
                new Choice(R.string.page4_choice1, 5),
                new Choice(R.string.page4_choice2, 6));

        stories[5] = new Page(R.drawable.page5, R.string.page5);

        stories[6] = new Page(R.drawable.page6, R.string.page6);
    }

    public Page getPage(int pageNumber) {

        if (pageNumber >= stories.length) {
            return  stories[0];
        }
        return  stories[pageNumber];
    }
}
