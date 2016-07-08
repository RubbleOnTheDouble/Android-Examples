package com.example.colle.projectcoddy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LegoOpenScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lego_open_screen);
    }

    public void startPublicButon(View v){
        Intent intent = new Intent(this, LegoOpenScreen.class);
        startActivity(intent);
    }
}
