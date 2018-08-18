package com.example.juzer.dashboard;

import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Start extends AppCompatActivity implements View.OnClickListener {

    EditText edtGuess;
    Button btnCheck;
    TextView txtMsg;
    TextView txtAttempt;
    int counter=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        edtGuess=(EditText) findViewById(R.id.edtGuess);
        btnCheck=(Button) findViewById(R.id.btnCheck);
        txtMsg=(TextView) findViewById(R.id.txtMsg);
        txtAttempt=(TextView) findViewById(R.id.txtAttempt);

        txtMsg.setPaintFlags(txtMsg.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
        btnCheck.setOnClickListener(Start.this);
    }

    @Override
    public void onClick(View view) {
        counter=counter+1;
        txtAttempt.setText("Attempts: "+counter);

        }
}
