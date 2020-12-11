package com.tallangroberg.tableplanner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;


import android.widget.TextView;



public class AllTablesView extends AppCompatActivity {

      String[] tables;
    private boolean tablesMade;
    private  int NUMBER_OF_TABLES;
    TableViewAdapter tableViewAdapter;
    RecyclerView mTableList;
    TextView tv_tableName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_tables_view);

        if(savedInstanceState != null) {
            if(savedInstanceState.containsKey("numberOfTables")){
                NUMBER_OF_TABLES = savedInstanceState.getInt( "numberOfTables");
            }
        }



        makeView();
    }



    public  void makeView() {
        Bundle extras = getIntent().getExtras();

        String newTable =  extras.getString("new_table");

        String oldTable =  extras.getString("old_table");





        NUMBER_OF_TABLES = extras.getInt("numberOfTables");
        tables = new String[NUMBER_OF_TABLES];
        mTableList = (RecyclerView) findViewById(R.id.rv_numbers);
        tv_tableName = (TextView) findViewById(R.id.table_in_list);



        if(NUMBER_OF_TABLES > 0)
        {
            tablesMade = extras.getBoolean("tablesMade");
            if(tablesMade) {
            tables = extras.getStringArray("tables_array");

                displayTables(newTable, oldTable);
            } else {
                makeTables();
                tablesMade = true;
            }
        }



        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mTableList.setLayoutManager(layoutManager);

        mTableList.setHasFixedSize(true);

        tableViewAdapter = new TableViewAdapter(tables, tablesMade);
        mTableList.setAdapter(tableViewAdapter);
    }


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("numberOfTables", NUMBER_OF_TABLES);
    }

    public void makeTables()
    {

            for (int i = 0; i < tables.length; i++) {

                int n = i + 1;
                tables[i] = "table " + n;
            }
            tablesMade = true;
    }

    public void displayTables(String newTable, String oldTable) {

        for (int i = 0; i < tables.length; i++) {

            if(tables[i].equals(oldTable))
            {
                tables[i] = newTable;
            }
        }

    }


}
