package com.tallangroberg.tableplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;

public class SingleTableView extends AppCompatActivity {

    private EditText ed_tableName;
    private Button bt_submit;
    private String tableName;
    private int numberOfTables;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_table_view);

        Bundle extras = getIntent().getExtras();

        numberOfTables = extras.getInt("numberOfTables");
        Log.e("TAG", " " + numberOfTables);


        Intent sentFromTableViewAdapter = getIntent();
        ed_tableName = (EditText) findViewById(R.id.single_table_name);
        bt_submit = (Button) findViewById(R.id.submit_table_change);

        if(sentFromTableViewAdapter.hasExtra(Intent.EXTRA_TEXT)) {
            tableName = sentFromTableViewAdapter.getStringExtra(Intent.EXTRA_TEXT);
            ed_tableName.setText(tableName);
        }

        bt_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newTableName = String.valueOf(ed_tableName.getText());
                Intent intent = new Intent(SingleTableView.this, AllTablesView.class);
                intent.putExtra(Intent.EXTRA_TITLE, newTableName);
                intent.putExtra("old_table", tableName);
                intent.putExtra("numberOfTables", numberOfTables);

                startActivity(intent);
            }
        });



    }
}