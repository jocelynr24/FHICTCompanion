package com.example.routin.dto;

/**
 * Created by coen on 28/09/2017.
 */

public class ScheduleMeRoot {
    public ScheduleMeRoot() {
    }

    public ScheduleMe[] getData() {

        return data;
    }

    public void setData(ScheduleMe[] data) {
        this.data = data;
    }

    private ScheduleMe[] data;
}
