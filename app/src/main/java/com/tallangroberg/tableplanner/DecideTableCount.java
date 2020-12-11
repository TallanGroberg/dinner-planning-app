package com.tallangroberg.tableplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DecideTableCount extends AppCompatActivity
{

    private TextView plannerName;
    private EditText ed_numberOfTables;
    private Button bt_submitTableCount;
    private String[] tables;
    private int numberOfTables;
    private TextView howManyTables;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decide_table_count);
        plannerName = (TextView) findViewById(R.id.planner);
        howManyTables = (TextView) findViewById(R.id.how_many_tables);
        ed_numberOfTables = (EditText) findViewById(R.id.number_of_tables);
        bt_submitTableCount = (Button) findViewById(R.id.submit_button_count);

        Intent sentFromMainActivity = getIntent();

        if(sentFromMainActivity.hasExtra(Intent.EXTRA_TEXT)) {
            String planner = sentFromMainActivity.getStringExtra(Intent.EXTRA_TEXT);
            plannerName.setText("Welcome "  + planner);
        }

        bt_submitTableCount.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
        Intent sendToAllTablesView = new Intent(DecideTableCount.this, AllTablesView.class);
        String numberOfTables = String.valueOf(ed_numberOfTables.getText());
        int numOtables = Integer.parseInt(numberOfTables);
        sendToAllTablesView.putExtra("numberOfTables", numOtables);

        startActivity(sendToAllTablesView);

            }
        });
    }

}