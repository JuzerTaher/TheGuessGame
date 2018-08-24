package com.example.juzer.dashboard;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
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
    TextView txtHint,txtMsg,txtInfo,txtAttempt,txtLimitHint;
    int randomNo,counter=0;
    int userNo,guessLimit,range;

    public void numberAndHint(){
        range=Settings.selectedRange;
        guessLimit=Settings.limit;
        SecureRandom sc=new SecureRandom();
        txtHint.setText("HINT: I have guessed a number between 1 and " +range+ ".");
        txtLimitHint.setText("           You have "+guessLimit+" attempts to find it out. ");
        randomNo=1+sc.nextInt(range);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        edtGuess=(EditText) findViewById(R.id.edtGuess);
        btnCheck=(Button) findViewById(R.id.btnCheck);
        btnTryAgain=(Button) findViewById(R.id.btnTryAgain);
        btnHome=(Button) findViewById(R.id.btnHome);
        txtMsg=(TextView) findViewById(R.id.txtMsg);
        txtAttempt=(TextView) findViewById(R.id.txtAttempt);
        txtHint=(TextView) findViewById(R.id.txtHint);
        txtInfo=(TextView) findViewById(R.id.txtInfo);
        txtLimitHint=(TextView) findViewById(R.id.txtLimitHint);

        txtMsg.setPaintFlags(txtMsg.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
        btnCheck.setOnClickListener(Start.this);
        btnHome.setOnClickListener(Start.this);
        btnTryAgain.setOnClickListener(Start.this);

        btnTryAgain.setVisibility(View.INVISIBLE);
        btnHome.setVisibility(View.INVISIBLE);

        edtGuess.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                String value=edtGuess.getText().toString().trim();
                btnCheck.setEnabled(!value.isEmpty());

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        numberAndHint();


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
                //range=20;
                //guessLimit=10;
                Intent i=new Intent(Start.this,Start.class);
                startActivity(i);
                break;

            case R.id.btnHome:
                finish();
                break;


        }
    }

        public void theGame(){


        try {
            userNo = 0 + Integer.parseInt(edtGuess.getText().toString());
        }catch (NumberFormatException e){
            Toast.makeText(this,"Cannot be empty",Toast.LENGTH_LONG).show();
        }


        if(userNo<1||userNo>range){
            edtGuess.setText("");
            counter = counter + 1;
            txtInfo.setText("You are guessing values which are not in the given range. This will increase your no. of attempts two times more than actual increament.");
        }
        else if(userNo==randomNo && counter<guessLimit) {
            edtGuess.setText("");
            txtInfo.setText("CONGRATULATIONS..! You have managed to guess the number that i had in my mind in " + (counter) + " attempts." +
                    "You are all set to appear for objective exams. All the best.! :)");
            btnHome.setVisibility(View.VISIBLE);
            btnTryAgain.setVisibility(View.VISIBLE);
            btnCheck.setVisibility(View.INVISIBLE);
        }else if(userNo>randomNo && counter<guessLimit) {
            edtGuess.setText("");
            txtInfo.setText("TRY LOWER : The number that you have guessed is larger than the number that is in my mind. Try for a smaller number" +
                    " than the one that you have guessed and you will definitely crack it.!");
        }else if(userNo<randomNo && counter<guessLimit) {
            edtGuess.setText("");
            txtInfo.setText("TRY HIGHER : The number that you have guessed is smaller than the number that is in my mind. Try for a larger number" +
                    " than the one that you have guessed and you will definitely crack it.!");

        }
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
