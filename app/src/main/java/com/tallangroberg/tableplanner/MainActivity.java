package com.tallangroberg.tableplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv_plannerName;
    Button bt_submitPlannerName;
    EditText ed_inputPlannerName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tv_plannerName = (TextView) findViewById(R.id.planner_name);
        bt_submitPlannerName = (Button) findViewById(R.id.submit_planner_button);
        ed_inputPlannerName = (EditText) findViewById(R.id.input_planner_name);


        bt_submitPlannerName.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                tv_plannerName.setText("Welcome " + ed_inputPlannerName.getText());
            }
        });
    }
}