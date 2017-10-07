package com.example.routin.dto;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CanvasMe {
    private String name;
    private boolean has_submitted_submissions;
    private String created_at;
    private String due_at;


    public CanvasMe() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isHas_submitted_submissions() {
        return has_submitted_submissions;
    }

    public void setHas_submitted_submissions(boolean has_submitted_submissions) {
        this.has_submitted_submissions = has_submitted_submissions;
    }

    public String getHas_submitted_submissions(){
        String strReturn;
        if(this.has_submitted_submissions){
            strReturn = "Already submitted";
        } else {
            strReturn = "Not submitted yet";
        }
        return strReturn;
    }

    public Date getCreated_at() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH);
        Date date = null;
        try {
            date = df.parse(created_at);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public Date getDue_at() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH);
        Date date = null;
        try {
            date = df.parse(due_at);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public void setDue_at(String due_at) {
        this.due_at = due_at;
    }
}
