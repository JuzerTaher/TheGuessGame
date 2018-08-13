package com.example.juzer.dashboard;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import static com.example.juzer.dashboard.R.color.cardPressed;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    CardView cardStart, cardExit, cardAbout, cardSettings;
    static boolean value = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        cardStart = (CardView) findViewById(R.id.cardStart);
        cardAbout = (CardView) findViewById(R.id.cardAbout);
        cardExit = (CardView) findViewById(R.id.cardExit);
        cardSettings = (CardView) findViewById(R.id.cardSettings);

        cardStart.setOnClickListener(MainActivity.this);
        cardAbout.setOnClickListener(MainActivity.this);
        cardExit.setOnClickListener(MainActivity.this);
        cardSettings.setOnClickListener(MainActivity.this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.cardStart:
                Intent i;
                i=new Intent(MainActivity.this,Start.class);
                startActivity(i);
                break;
            case R.id.cardAbout:
                Intent i1;
                i1=new Intent(MainActivity.this,About.class);
                startActivity(i1);
                break;
            case R.id.cardSettings:
                Intent i2;
                i2=new Intent(MainActivity.this,Settings.class);
                startActivity(i2);
                break;
            case R.id.cardExit:
                new AlertDialog.Builder(this).setTitle("CONFIRM EXIT").setMessage("Are you sure you want to Exit?")
                        .setNegativeButton("NO",null).setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                }).create().show();
                break;
        }

    }
}



