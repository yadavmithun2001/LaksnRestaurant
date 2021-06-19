package com.example.laksnrestaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SpashScreen extends AppCompatActivity {
    private static int SPLASH_SCREEN = 750;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spash_screen);
        getSupportActionBar().hide();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SpashScreen.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        },SPLASH_SCREEN);

    }
}