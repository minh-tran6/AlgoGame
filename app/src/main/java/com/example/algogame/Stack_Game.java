package com.example.algogame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.algogame.Object.FailureDialog;
import com.example.algogame.Object.Stack_Object;
import com.example.algogame.Object.SuccessDialog;

public class Stack_Game extends AppCompatActivity  {
    TextView prompt;
    TextView scramble;
    TextView stack;
    TextView result;
    TextView promptText;
    TextView scrambleText;
    TextView stackText;
    TextView resultText;
    TextView countDownTimer;

    Button push_button;
    Button pop_button;
    Button submitStack_button;
    Button reset_button;

    String timerFront = "00:";
    String timerEnd;
    CountDownTimer timer;
    int value = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stack__game);

        Stack_Object newGame = new Stack_Object();


        prompt = findViewById(R.id.prompt);
        scramble = findViewById(R.id.robot);
        stack = findViewById(R.id.scramble);
        result = findViewById(R.id.result);

        promptText = findViewById(R.id.promptText);
        scrambleText = findViewById(R.id.robotText);
        stackText = findViewById(R.id.scrambleText);
        resultText = findViewById(R.id.resultText);
        countDownTimer = findViewById(R.id.countDownTimer);

        push_button = findViewById(R.id.push_button);
        pop_button = findViewById(R.id.pop_button);
        submitStack_button = findViewById(R.id.submitQueue_button);
        reset_button = findViewById(R.id.reset_button);

        timer = new CountDownTimer((value+1)*1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                if(value<10)
                {
                    timerEnd = "0"+String.valueOf(value);
                }
                else {
                    timerEnd = String.valueOf(value);
                }
                countDownTimer.setText(timerFront+timerEnd);
                value--;
            }

            @Override
            public void onFinish() {
                timer.cancel();
                if(newGame.checkMatching()) {
                    openDialog(0);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            finish();
                        }
                    },4000);
                }
                else
                {
                    openDialog(1);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            finish();
                        }
                    },4000);
                }
            }
        }.start();

        //Generating Prompt
        String bufferPrompt = "BIKECYCLE";
        promptText.setText(newGame.getPrompt(1));

        //Scramble Text
        newGame.setScramble();
        scrambleText = findViewById((R.id.robotText));
        scrambleText.setText(newGame.getScramble());

        push_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newGame.setStack();
                stackText.setText(newGame.getStack());
                scrambleText.setText(newGame.getScramble());
            }
        }); ;

        pop_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newGame.setResult();
                resultText.setText(newGame.getResult());
                stackText.setText(newGame.getStack());
            }
        });

        submitStack_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.cancel();
                if(newGame.checkMatching()) {
                    openDialog(0);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            finish();
                        }
                    },4000);
                }
                else
                {
                    openDialog(1);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            finish();
                        }
                    },4000);
                }
            }
        });

        reset_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newGame.reset();
                scrambleText.setText(newGame.getScramble());
                stackText.setText(newGame.getStack());
                resultText.setText(newGame.getResult());
            }
        });
    }

    private void openDialog(int i) {
        if(i==0) {
            SuccessDialog successDialog = new SuccessDialog();
            successDialog.show(getSupportFragmentManager(), "successDialog");
        }
        else
        {
            FailureDialog failureDialog = new FailureDialog();
            failureDialog.show(getSupportFragmentManager(),"failureDialog");
        }
    }

    @Override
    public void onBackPressed() {
        timer.cancel();
        super.onBackPressed();
    }
}