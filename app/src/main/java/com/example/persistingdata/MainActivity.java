package com.example.persistingdata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    SharedPreferences prefs;
    String prefName = "MyPref";

    public void readPrefValues(){
        prefs = getSharedPreferences(prefName, MODE_PRIVATE);
        float temperature = prefs.getFloat("temperatre",50);
        boolean authenticated = prefs.getBoolean("authenticated", false);
        String username = prefs.getString("username","");
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //---get the SharedPreferences object---
        prefs = getSharedPreferences(prefName, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();


        //---save some values using the SharedPreferences object---
        editor.putFloat("temperature", 85);
        editor.putBoolean("authenticated",true);
        editor.putString("username", "Mei-Meng Lee");

        //---saves the values---
        editor.commit();
        
        readPrefValues();
    }
}
