package com.example.juzer.dashboard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;

public class Settings extends AppCompatActivity implements View.OnClickListener {

    Button btnBeginner,btnIntermediate,btnAdvance;
    static int limit=10,selectedRange=20;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        btnAdvance=(Button) findViewById(R.id.btnAdvance);
        btnBeginner=(Button) findViewById(R.id.btnBeginner);
        btnIntermediate=(Button)findViewById(R.id.btnIntermediate);

        btnIntermediate.setOnClickListener(Settings.this);
        btnBeginner.setOnClickListener(Settings.this);
        btnAdvance.setOnClickListener(Settings.this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnBeginner:
                limit=10;
                selectedRange=20;
                i=new Intent(Settings.this,Start.class);
                startActivity(i);
                finish();
                break;
            case R.id.btnIntermediate:
                limit=15;
                selectedRange=35;
                i=new Intent(Settings.this,Start.class);
                startActivity(i);
                finish();
                break;
            case R.id.btnAdvance:
                limit=25;
                selectedRange=50;
                i=new Intent(Settings.this,Start.class);
                startActivity(i);
                finish();
                break;
        }
    }
}
