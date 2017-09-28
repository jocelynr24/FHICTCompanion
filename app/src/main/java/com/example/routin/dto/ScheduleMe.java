package com.example.routin.dto;

import java.util.Date;

/**
 * Created by coen on 28/09/2017.
 */

public class ScheduleMe {
    private String room;
    private String subject;
    private Date start;

    public ScheduleMe() {
    }

    private Date end;

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }
}
