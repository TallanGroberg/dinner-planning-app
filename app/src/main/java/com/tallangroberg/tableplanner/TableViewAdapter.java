package com.tallangroberg.tableplanner;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;

public class TableViewAdapter extends RecyclerView.Adapter<TableViewAdapter.ViewHolder>
{
        private static final String TAG = "TableViewAdapter";

        private String[] mDataSet;


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
                }
            });
                textView = v.findViewById(R.id.table_in_list);

        }

        public TextView getTextView() {
            return textView;
        }
    }

    // END ViewHolder.


    public TableViewAdapter(String[] dataSet)
    {

        mDataSet = dataSet;
        Log.e("tables array:::::", Arrays.toString(mDataSet));

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
        return mDataSet.length;
    }

}
