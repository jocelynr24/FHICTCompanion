package com.example.routin.fhictcompanion;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Locale;

public class SettingsFragment extends Fragment {
    View myView;
    String[] arraySpinner;
    String spinner_lang;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.settings_layout, container, false);

        this.arraySpinner = new String[] {
                myView.getContext().getString(R.string.settings_en), myView.getContext().getString(R.string.settings_fr), myView.getContext().getString(R.string.settings_nl)
        };
        final Spinner mySpinner = (Spinner) myView.findViewById(R.id.spinner_lang);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, arraySpinner);
        mySpinner.setAdapter(adapter);

        final Button button = myView.findViewById(R.id.button_change);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                spinner_lang = mySpinner.getSelectedItem().toString();
                changeLanguage(getResources(), spinner_lang);
            }
        });

        return myView;
    }

    private void changeLanguage(Resources res, String lang) {
        Configuration config;
        config = new Configuration(res.getConfiguration());

        switch(lang){
            case "English":
                config.locale = new Locale("en");
                break;
            case "Anglais":
                config.locale = new Locale("en");
                break;
            case "Engels":
                config.locale = new Locale("en");
                break;
            case "French":
                config.locale = new Locale("fr");
                break;
            case "Français":
                config.locale = new Locale("fr");
                break;
            case "Frans":
                config.locale = new Locale("fr");
                break;
            case "Dutch":
                config.locale = new Locale("nl");
                break;
            case "Néerlandais":
                config.locale = new Locale("nl");
                break;
            case "Nederlands":
                config.locale = new Locale("nl");
                break;
            default:
                config.locale = new Locale("en");
                break;
        }

        getResources().updateConfiguration(config, res.getDisplayMetrics());
        Intent i = myView.getContext().getPackageManager().getLaunchIntentForPackage( myView.getContext().getPackageName() );
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
    }
}
