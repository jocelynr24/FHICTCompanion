package com.example.routin.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.routin.dto.ScheduleMe;

import java.util.ArrayList;

/**
 * Created by coen on 28/09/2017.
 */

public class ScheduleAdapter extends ArrayAdapter<ScheduleMe> {
    Context context;
    int layoutResourceId;
    ArrayList<ScheduleMe> data = new ArrayList<ScheduleMe>();

    public ScheduleAdapter(Context context, int layoutResourceId,
                             ArrayList<ScheduleMe> data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View row = convertView;

        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
            /*
            holder.textName = (TextView) row.findViewById(R.id.textView1);
            holder.textAddress = (TextView) row.findViewById(R.id.textView2);
            holder.textLocation = (TextView) row.findViewById(R.id.textView3);
            holder.btnEdit = (Button) row.findViewById(R.id.button1);
            */
        }
        /*
        Customers user = data.get(position);
        holder.textName.setText(user.getName());
        holder.textAddress.setText(user.getAddress());
        holder.textLocation.setText("");
        */
        return row;

    }
}
