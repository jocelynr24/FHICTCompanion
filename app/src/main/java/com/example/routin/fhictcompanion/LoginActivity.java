package com.example.routin.fhictcompanion;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


    }
    public void clickLogin(View view) {
        // Intent(FirstActivity, SecondActivity.class)
        Intent intent = new Intent(this, MainActivity.class);

        // Start Activity (GreetingActivity)
        // (No need feedback from the activity is called)
        this.startActivity(intent);
    }


}
