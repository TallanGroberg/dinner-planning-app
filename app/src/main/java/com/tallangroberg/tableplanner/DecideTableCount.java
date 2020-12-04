package com.tallangroberg.tableplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DecideTableCount extends AppCompatActivity {

    private TextView planner_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decide_table_count);
        planner_name = (TextView) findViewById(R.id.planner);

        Intent sentFromMainActivity = getIntent();

        if(sentFromMainActivity.hasExtra(Intent.EXTRA_TEXT)) {
            String planner = sentFromMainActivity.getStringExtra(Intent.EXTRA_TEXT);
            planner_name.setText("Welcome "  + planner);
        }
    }
}