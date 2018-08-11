package com.example.juzer.dashboard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    CardView cardStart,cardExit,cardAbout,cardSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        cardStart=(CardView)findViewById(R.id.cardStart);
        cardAbout=(CardView)findViewById(R.id.cardAbout);
        cardExit=(CardView) findViewById(R.id.cardExit);
        cardSettings=(CardView)findViewById(R.id.cardSettings);

        cardStart.setOnClickListener(MainActivity.this);
        cardSettings.setOnClickListener(MainActivity.this);
        cardExit.setOnClickListener(MainActivity.this);
        cardAbout.setOnClickListener(MainActivity.this);


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
                Intent i2;
                i2=new Intent(MainActivity.this,About.class);
                startActivity(i2);
                break;
            case R.id.cardSettings:
                Intent i3;
                i3=new Intent(MainActivity.this,Settings.class);
                startActivity(i3);
                break;
            case R.id.cardExit:
                finish();
                break;
        }
    }
}
