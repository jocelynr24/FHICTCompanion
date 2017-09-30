package com.example.routin.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.routin.dto.ScheduleMe;
import com.example.routin.fhictcompanion.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
        }
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        ScheduleMe schedule = data.get(position);
        ((TextView) row.findViewById(R.id.textgradesubject)).setText(schedule.getSubject());
        ((TextView) row.findViewById(R.id.textgradeclass)).setText(schedule.getRoom());
        ((TextView) row.findViewById(R.id.textgradestart)).setText(df.format(schedule.getStart()));
        ((TextView) row.findViewById(R.id.textgradeend)).setText(df.format(schedule.getEnd()));
        return row;

    }
}
