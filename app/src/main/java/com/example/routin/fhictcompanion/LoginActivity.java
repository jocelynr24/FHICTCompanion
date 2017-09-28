package com.example.routin.fhictcompanion;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity implements TokenFragment.OnFragmentInteractionListener {
    private static LoginActivity self;
    static LoginActivity getInstance() {
        return self;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        self = this;
        loadToken();
    }


    @Override
    public void onFragmentInteraction(String token) {
        saveToken(token);
        startIntent();
    }

    private void saveToken(String token) {
        TokenSingleton.getInstance().setToken(token);

        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("token", token);
        editor.commit();
    }

    private void loadToken() {
        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        String token = sharedPref.getString("token", "");
        if (token != "") {
            TokenSingleton.getInstance().setToken(token);
            startIntent();
        }
    }

    private void startIntent(){
        // LOGGED IN YEAH
        // Intent(FirstActivity, SecondActivity.class)
        Intent intent = new Intent(this, MainActivity.class);

        // Start Activity (GreetingActivity)
        // (No need feedback from the activity is called)
        this.startActivity(intent);
    }
}
