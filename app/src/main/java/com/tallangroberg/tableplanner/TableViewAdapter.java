package com.tallangroberg.tableplanner;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;

import static android.content.Intent.getIntent;
import static android.content.Intent.getIntentOld;
import static androidx.core.content.ContextCompat.startActivity;

public class TableViewAdapter extends RecyclerView.Adapter<TableViewAdapter.ViewHolder>
{
        private static final String TAG = "TableViewAdapter";

         private static String[] mDataSet;
         private static int mNumberOfTables;
         private static boolean bTablesMade;



    public static class ViewHolder extends RecyclerView.ViewHolder
    {


        private final TextView textView;
        int numberOfTables;


        public ViewHolder(@NonNull View v)
        {
            super(v);
            v.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {

                    Log.d(TAG, "Element " + getAdapterPosition() + " clicked.");
                    Intent intent = new Intent(v.getContext(), SingleTableView.class);
                    String tableName = (String) textView.getText();
                    intent.putExtra(Intent.EXTRA_TEXT, tableName);
                    intent.putExtra("tables_array", mDataSet);
                    intent.putExtra("tablesMade", bTablesMade);
                    intent.putExtra("numberOfTables", mNumberOfTables);




                    v.getContext().startActivity(intent);
                }
            });
                textView = v.findViewById(R.id.table_in_list);

        }

        public TextView getTextView() {
            return textView;
        }
    }

    // END ViewHolder.


    public TableViewAdapter(String[] dataSet, boolean tablesMade)
    {

        mDataSet = dataSet;
        mNumberOfTables = dataSet.length;
       bTablesMade = tablesMade;

    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType)
    {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.table_row_item, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int position)
    {
        Log.d(TAG, "Element " + position + " set.");

        viewHolder.getTextView().setText(mDataSet[position]);


    }

    @Override
    public int getItemCount()
    {
        if(mDataSet != null) {

        return mDataSet.length;
        } else {
            return 0;
        }
    }

}
