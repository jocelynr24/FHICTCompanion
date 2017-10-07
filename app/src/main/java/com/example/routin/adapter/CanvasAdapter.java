package com.example.routin.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.routin.dto.CanvasMe;
import com.example.routin.fhictcompanion.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.TimeZone;

public class CanvasAdapter extends ArrayAdapter<CanvasMe> {
    Context context;
    int layoutResourceId;
    ArrayList<CanvasMe> assignment = new ArrayList<CanvasMe>();

    public CanvasAdapter(Context context, int layoutResourceId, ArrayList<CanvasMe> assignment) {
        super(context, layoutResourceId, assignment);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.assignment = assignment;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View row = convertView;

        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
        }
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.ENGLISH);
        df.setTimeZone(TimeZone.getTimeZone("GMT+4"));
        for(int i = 0; i < assignment.size(); i++) {
            ((TextView) row.findViewById(R.id.textcanvasname)).setText(assignment.get(i).getName());
            ((TextView) row.findViewById(R.id.textcanvassubmitted)).setText(assignment.get(i).getHas_submitted_submissions());
            ((TextView) row.findViewById(R.id.textcanvascreated)).setText(context.getString(R.string.canvas_from) + " " + df.format(assignment.get(i).getCreated_at()));
            ((TextView) row.findViewById(R.id.textcanvasdue)).setText(context.getString(R.string.canvas_to) + " " + df.format(assignment.get(i).getDue_at()));
        }

        return row;

    }
}
