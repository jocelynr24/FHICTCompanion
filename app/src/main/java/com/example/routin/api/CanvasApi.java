package com.example.routin.api;

import android.os.AsyncTask;
import android.util.JsonReader;

import com.example.routin.dto.CanvasMe;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class CanvasApi extends AsyncTask<String, Void, ArrayList<CanvasMe>> {
    ArrayList<CanvasMe> cm = new ArrayList<CanvasMe>();

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

    }

    @Override
    protected ArrayList<CanvasMe> doInBackground(String... token) {
        ArrayList<CanvasMe> retval;
        try {

            URL url = new URL("https://api.fhict.nl/canvas/upcoming/me");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Authorization", "Bearer " + token[0]);
            connection.connect();
            switch (connection.getResponseCode()) {
                case 200:
                case 201:
                    BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    JsonReader jr = new JsonReader(br);

                    String jsonString = (new Scanner(br)).useDelimiter("\\A").next();
                    JSONArray jsonArray = new JSONArray(jsonString);

                    for(int i = 0; i < jsonArray.length(); i++) {
                        cm.add(i, new CanvasMe());
                        JSONObject cmObject = jsonArray.getJSONObject(i).getJSONObject("assignment");
                        cm.get(i).setName(cmObject.getString("name"));
                        cm.get(i).setHas_submitted_submissions(cmObject.getBoolean("has_submitted_submissions"));
                        cm.get(i).setCreated_at(cmObject.getString("created_at"));
                        cm.get(i).setDue_at(cmObject.getString("due_at"));
                    }

                    retval = cm;
                break;
                default:
                    retval = null;
                break;
            }
        } catch (IOException | JSONException e) {
            e.printStackTrace();
            retval = null;
        }
        return retval;
    }

    protected void onPostExecute(ArrayList<CanvasMe> result) {

    }
}
