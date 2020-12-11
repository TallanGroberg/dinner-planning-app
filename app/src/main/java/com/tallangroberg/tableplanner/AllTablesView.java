package com.tallangroberg.tableplanner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AllTablesView extends AppCompatActivity {

    private  String[] tables;
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
                Log.e("saved state", savedInstanceState.getInt( "numberOfTables") + "");
                NUMBER_OF_TABLES = savedInstanceState.getInt( "numberOfTables");
            }
        }

        makeView();
    }



    public  void makeView() {
        Bundle extras = getIntent().getExtras();

        NUMBER_OF_TABLES = extras.getInt("numberOfTables");
        tables = new String[NUMBER_OF_TABLES];

        mTableList = (RecyclerView) findViewById(R.id.rv_numbers);
        tv_tableName = (TextView) findViewById(R.id.table_in_list);



        if(NUMBER_OF_TABLES > 0)
        {
            makeTables("new table", "old Table");
        }



        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mTableList.setLayoutManager(layoutManager);

        mTableList.setHasFixedSize(true);

        tableViewAdapter = new TableViewAdapter(tables);
        mTableList.setAdapter(tableViewAdapter);
    }


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("numberOfTables", NUMBER_OF_TABLES);
    }

    public void makeTables(String newTable, String oldTable)
    {



            Log.e("more than one table",  NUMBER_OF_TABLES + "");
            for (int i = 0; i < tables.length; i++) {

                int n = i + 1;
                tables[i] = "table " + n;

                Log.e("in make Tables", tables[i]);
            }

    }


}
