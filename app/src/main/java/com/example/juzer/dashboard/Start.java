package com.example.juzer.dashboard;

import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.security.SecureRandom;

public class Start extends AppCompatActivity implements View.OnClickListener {

    EditText edtGuess;
    Button btnCheck;
    TextView txtHint,txtMsg,txtInfo,txtAttempt;
    int randomNo,counter=0;
    int userNo,guessLimit;

    public void numberAndHint(){
        guessLimit=20;
        SecureRandom sc=new SecureRandom();
        txtHint.setText("HINT: I have guessed a number between 1 and 20.");
        randomNo=1+sc.nextInt(guessLimit);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);


        btnCheck=(Button) findViewById(R.id.btnCheck);
        txtMsg=(TextView) findViewById(R.id.txtMsg);
        txtAttempt=(TextView) findViewById(R.id.txtAttempt);
        txtHint=(TextView) findViewById(R.id.txtHint);
        txtInfo=(TextView) findViewById(R.id.txtInfo);

        txtMsg.setPaintFlags(txtMsg.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
        btnCheck.setOnClickListener(Start.this);

        numberAndHint();
    }

    @Override
    public void onClick(View view) {

        theGame();
        if(counter<guessLimit) {

            counter = counter + 1;
            txtAttempt.setText("Attempts: " + counter);
        }
        else
            txtInfo.setText("Sorry, you have crossed the maximum limit of guessing.! The number in my mind was "+randomNo+ ". Better luck next time.!");


    }

        public void theGame(){

        edtGuess=(EditText) findViewById(R.id.edtGuess);
        userNo=Integer.parseInt(edtGuess.getText().toString());
        if(userNo<0||userNo>20){
            counter = counter + 1;
            txtInfo.setText("You are guessing values which are not in the given range. This will increase your no. of attempts two times more than actual increament.");
        }
        else if(userNo==randomNo)
            txtInfo.setText("Congratualations.! You have managed to guess the number that i had in my mind in " +(counter+1)+ " attempts." +
                    "You are all set to appear for objective exams. All the best.! :)");
        else if(userNo>randomNo)
            txtInfo.setText("The number that you have guessed is larger than the number that is in my mind. Try for a smaller number" +
                    " than the one that you have guessed and you will definitely crack it.!");
        else if(userNo<randomNo)
            txtInfo.setText("The number that you have guessed is smaller than the number that is in my mind. Try for a larger number" +
                    " than the one that you have guessed and you will definitely crack it.!");

        }
}
