package com.example.routin.dto;

import java.util.ArrayList;

/**
 * Created by coen on 28/09/2017.
 */

public class ScheduleMeRoot {
    public ScheduleMeRoot() {
    }

    public ArrayList<ScheduleMe> getData() {
        return data;
    }

    public void setData(ArrayList<ScheduleMe> data) {
        this.data = data;
    }

    private ArrayList<ScheduleMe> data;
}
