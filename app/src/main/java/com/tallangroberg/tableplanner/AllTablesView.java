package com.tallangroberg.tableplanner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

public class AllTablesView extends AppCompatActivity {

    private int NUMBER_OF_TABLES;
    String numberOfTablesAsString;
    String[] tables;
    TableViewAdapter tableViewAdapter;
    RecyclerView mTableList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_tables_view);

        mTableList = (RecyclerView) findViewById(R.id.rv_numbers);

        Intent sentFromDecideTableCount = getIntent();
        if(sentFromDecideTableCount.hasExtra(Intent.EXTRA_TEXT)) {
            numberOfTablesAsString = sentFromDecideTableCount.getStringExtra(Intent.EXTRA_TEXT);
            NUMBER_OF_TABLES = Integer.parseInt(numberOfTablesAsString);
            makeTables();
        }


        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mTableList.setLayoutManager(layoutManager);

        mTableList.setHasFixedSize(true);


        tableViewAdapter = new TableViewAdapter(tables);
        mTableList.setAdapter(tableViewAdapter);
    }

    public void makeTables() {

        if(NUMBER_OF_TABLES > 0 )
        {
            tables = new String[NUMBER_OF_TABLES];
            Log.e("more than one table",  NUMBER_OF_TABLES + "");
            for (int i = 0; i < tables.length; i++) {
                int n = i + 1;
                tables[i] = "table " + n;
            }

            } else {
            tables = new String[]{"you have to have at least one table."};
        }
    }


}