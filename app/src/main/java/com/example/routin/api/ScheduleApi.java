package com.example.routin.api;

import android.os.AsyncTask;

import com.example.routin.dto.ScheduleMe;
import com.example.routin.fhictcompanion.TokenSingleton;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by coen on 28/09/2017.
 */

public class ScheduleApi extends AsyncTask<String, Void, ScheduleMe> {

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

    }

    @Override
    protected ScheduleMe doInBackground(String... token) {
        try {

            URL url = new URL("https://api.fhict.nl/schedule/me");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Authorization", "Bearer " + token[0]);
            connection.connect();
            switch (connection.getResponseCode())
            {
                case 200:
                case 201:
                    BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    StringBuilder sb = new StringBuilder();
                    String line;
                    while ((line = br.readLine()) != null) {
                        sb.append(line+"\n");
                    }
                    br.close();
                    String jsonText = sb.toString();
                    //Serialize
                    return new Gson().fromJson(jsonText, ScheduleMe.class);
            }

            return null;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    protected void onPostExecute(Boolean result) {

    }
}
