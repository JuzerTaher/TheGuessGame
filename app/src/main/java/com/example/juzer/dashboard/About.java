package com.example.juzer.dashboard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class About extends AppCompatActivity implements View.OnClickListener {

    Button btnProceed,btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        btnBack=(Button) findViewById(R.id.btnBack);
        btnProceed=(Button) findViewById(R.id.btnProceed);

        btnProceed.setOnClickListener(About.this);
        btnBack.setOnClickListener(About.this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btnProceed:
                Intent i;
                i=new Intent(About.this,Start.class);
                startActivity(i);
                finish();
                break;
            case R.id.btnBack:
                finish();
                break;

        }
    }
}
