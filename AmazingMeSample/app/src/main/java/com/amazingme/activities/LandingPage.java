package com.amazingme.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.amazingme.activities.R;

import amazingme.AmazingMeApplicationContext;
import amazingme.model.EnumeratedActivity;

public class LandingPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("on create in landing page before super");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);
        System.out.println("on create in landing page after super");
        long start = System.currentTimeMillis();

        while(System.currentTimeMillis() - start < 5000) {

        }
//        AmazingMeApplicationContext.activityManager.goTo(MainMenu.class);
        Intent newIntent = new Intent(AmazingMeApplicationContext.getAmazingMeAndroidContext(), MainMenu.class);
        startActivity(newIntent);
    }
}
