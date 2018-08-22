package com.example.juzer.dashboard;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.security.SecureRandom;

public class Start extends AppCompatActivity implements View.OnClickListener {

    EditText edtGuess;
    Button btnCheck,btnTryAgain,btnHome;
    TextView txtHint,txtMsg,txtInfo,txtAttempt;
    int randomNo,counter=0;
    int userNo,guessLimit,range;

    public void numberAndHint(){
        range=20;
        guessLimit=10;
        SecureRandom sc=new SecureRandom();
        txtHint.setText("HINT: I have guessed a number between 1 and " +range+ ".");
        randomNo=1+sc.nextInt(range);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);


        btnCheck=(Button) findViewById(R.id.btnCheck);
        btnTryAgain=(Button) findViewById(R.id.btnTryAgain);
        btnHome=(Button) findViewById(R.id.btnHome);
        txtMsg=(TextView) findViewById(R.id.txtMsg);
        txtAttempt=(TextView) findViewById(R.id.txtAttempt);
        txtHint=(TextView) findViewById(R.id.txtHint);
        txtInfo=(TextView) findViewById(R.id.txtInfo);

        txtMsg.setPaintFlags(txtMsg.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
        btnCheck.setOnClickListener(Start.this);
        btnHome.setOnClickListener(Start.this);
        btnTryAgain.setOnClickListener(Start.this);

        btnTryAgain.setVisibility(View.INVISIBLE);
        btnHome.setVisibility(View.INVISIBLE);

        numberAndHint();
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.btnCheck:
                hideKeyboard();
                progress();
                if (counter < guessLimit) {
                    counter = counter + 1;
                    txtAttempt.setText("Attempts: " + counter);
                } else if (counter == guessLimit) {
                    txtInfo.setText("Sorry, you have crossed the maximum limit of guessing.! The number in my mind was " + randomNo + ". Better luck next time.!");
                    btnHome.setVisibility(View.VISIBLE);
                    btnTryAgain.setVisibility(View.VISIBLE);
                }
                theGame();
                break;

            case R.id.btnTryAgain:
                finish();
                Intent i=new Intent(Start.this,Start.class);
                startActivity(i);
                break;

            case R.id.btnHome:
                finish();
                break;


        }
    }

        public void theGame(){

        edtGuess=(EditText) findViewById(R.id.edtGuess);
        userNo=Integer.parseInt(edtGuess.getText().toString());

        if(userNo<1||userNo>guessLimit){
            counter = counter + 1;
            txtInfo.setText("You are guessing values which are not in the given range. This will increase your no. of attempts two times more than actual increament.");
        }
        else if(userNo==randomNo && counter<guessLimit) {
            txtInfo.setText("CONGRATULATIONS..! You have managed to guess the number that i had in my mind in " + (counter) + " attempts." +
                    "You are all set to appear for objective exams. All the best.! :)");
            btnHome.setVisibility(View.VISIBLE);
            btnTryAgain.setVisibility(View.VISIBLE);
            btnCheck.setVisibility(View.INVISIBLE);
        }else if(userNo>randomNo && counter<guessLimit)
            txtInfo.setText("TRY LOWER : The number that you have guessed is larger than the number that is in my mind. Try for a smaller number" +
                    " than the one that you have guessed and you will definitely crack it.!");
        else if(userNo<randomNo && counter<guessLimit)
            txtInfo.setText("TRY HIGHER : The number that you have guessed is smaller than the number that is in my mind. Try for a larger number" +
                    " than the one that you have guessed and you will definitely crack it.!");

        }

        public void progress(){
            final ProgressDialog progressDialog=new ProgressDialog(Start.this);
            progressDialog.setMessage("Fetching the result for you... Please wait..!");
            progressDialog.show();
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {
                    progressDialog.dismiss();
                }
            }, 1000);

        }

        public void hideKeyboard(){
            InputMethodManager inputManager = (InputMethodManager)
                    getSystemService(Context.INPUT_METHOD_SERVICE);

            inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                    InputMethodManager.HIDE_NOT_ALWAYS);
        }
}
