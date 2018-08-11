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

public class MainActivity extends AppCompatActivity implements View.OnTouchListener{

    CardView cardStart,cardExit,cardAbout,cardSettings;
    static boolean value=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        cardStart=(CardView)findViewById(R.id.cardStart);
        cardAbout=(CardView)findViewById(R.id.cardAbout);
        cardExit=(CardView) findViewById(R.id.cardExit);
        cardSettings=(CardView)findViewById(R.id.cardSettings);



        cardStart.setOnTouchListener(MainActivity.this);
        cardAbout.setOnTouchListener(MainActivity.this);
        cardExit.setOnTouchListener(MainActivity.this);
        cardSettings.setOnTouchListener(MainActivity.this);

        }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {

        switch(view.getId()){

            case R.id.cardStart:
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    cardStart.setCardBackgroundColor(getResources().getColor(R.color.cardPressed));
                    Intent i;
                    i=new Intent(MainActivity.this,Start.class);
                    startActivity(i);
                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    cardStart.setCardBackgroundColor(getResources().getColor(R.color.cardReleased));
                }
                break;

            case R.id.cardAbout:
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    cardAbout.setCardBackgroundColor(getResources().getColor(R.color.cardPressed));
                    Intent i;
                    i=new Intent(MainActivity.this,About.class);
                    startActivity(i);
                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    cardAbout.setCardBackgroundColor(getResources().getColor(R.color.cardReleased));
                }
                break;

            case R.id.cardSettings:
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    cardSettings.setCardBackgroundColor(getResources().getColor(R.color.cardPressed));
                    Intent i;
                    i=new Intent(MainActivity.this,Settings.class);
                    startActivity(i);
                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    cardSettings.setCardBackgroundColor(getResources().getColor(R.color.cardReleased));
                }
                break;

            case R.id.cardExit:
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    cardExit.setCardBackgroundColor(getResources().getColor(R.color.cardPressed));
                    new AlertDialog.Builder(this).setTitle("CONFIRM EXIT").setMessage("Are you sure you want to Exit?")
                            .setNegativeButton("NO",null).setPositiveButton("YES", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finish();
                        }
                    }).create().show();
                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    cardExit.setCardBackgroundColor(getResources().getColor(R.color.cardReleased));
                }
                break;

        }

        return true;
    }

     @Override
    protected void onPause() {
        super.onPause();
        cardStart.setCardBackgroundColor(getResources().getColor(R.color.cardReleased));
        cardSettings.setCardBackgroundColor(getResources().getColor(R.color.cardReleased));
        cardAbout.setCardBackgroundColor(getResources().getColor(R.color.cardReleased));
        cardExit.setCardBackgroundColor(getResources().getColor(R.color.cardReleased));
    }
}