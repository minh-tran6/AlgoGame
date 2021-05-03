package com.example.algogame;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.algogame.Object.FailureDialog;
import com.example.algogame.Object.Queue_Object;
import com.example.algogame.Object.SuccessDialog;

public class Queue_Game extends AppCompatActivity {

    TextView prompt;
    TextView scramble;
    TextView robot;
    TextView result;
    TextView promptText;
    TextView scrambleText;
    TextView robotText;
    TextView resultText;
    TextView countDownTimer;
    TextView QueueText;

    Button left_button;
    Button right_button;
    Button down_button;
    Button submitQueue_button;
    Button reset_button;

    String timerFront = "00:";
    String timerEnd;
    CountDownTimer timer;
    int value = 60;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_queue__game);

        Queue_Object newGame = new Queue_Object();

        prompt = findViewById(R.id.prompt);
        robot = findViewById(R.id.robot);
        scramble = findViewById(R.id.scramble);
        result = findViewById(R.id.result);

        promptText = findViewById(R.id.promptText);
        robotText = findViewById(R.id.robotText);
        scrambleText = findViewById(R.id.scrambleText);
        resultText = findViewById(R.id.resultText);
        countDownTimer = findViewById(R.id.countDownTimer);
        QueueText = findViewById(R.id.QueueText);

        left_button = findViewById(R.id.left_button);
        right_button = findViewById(R.id.right_button);
        down_button = findViewById(R.id.down_button);
        submitQueue_button = findViewById(R.id.submitQueue_button);
        reset_button = findViewById(R.id.resetQueue_button);

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


        //Prompt Text
        String bufferPrompt = "BIKECYCLE";
        promptText.setText(newGame.getPrompt(1));

        //Robot Text
        robotText = findViewById((R.id.robotText));
        newGame.setRobot();
        robotText.setText(newGame.getRobot());

        //Scramble Text
        newGame.setScramble();
        scrambleText.setText(newGame.getScramble());

        left_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newGame.leftRobot();
                robotText.setText(newGame.getRobot());
                QueueText.setText(newGame.getDirection());
            }
        }); ;

        right_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newGame.rightRobot();
                robotText.setText(newGame.getRobot());
                QueueText.setText(newGame.getDirection());
            }
        });

        down_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newGame.downRobot();
                QueueText.setText(newGame.getDirection());
            }
        });

        submitQueue_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newGame.clearRobot();
                newGame.setRobot();
                robotText.setText(newGame.getRobot());
                timer.cancel();

                Handler handler = new Handler();
                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        int index = newGame.performDirection();
                        String highlight = newGame.getScramble();
                        SpannableString ss = new SpannableString(highlight);

                        ForegroundColorSpan fcsRed = new ForegroundColorSpan(Color.RED);
                        ss.setSpan(fcsRed,index,index+1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

                        scrambleText.setText(ss);
                        robotText.setText(newGame.getRobot());
                        resultText.setText(newGame.getResult());
                        QueueText.setText(newGame.getDirection());


                        handler.postDelayed(this, 3000);

                        if(newGame.getDirectionSize()==0) {
                            robotText.setText(newGame.getRobot());
                            resultText.setText(newGame.getResult());
                            QueueText.setText(newGame.getDirection());
                            handler.removeCallbacks(this);
                            if (newGame.checkMatching()) {
                                openDialog(0);
                            } else {
                                openDialog(1);
                            }
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    finish();
                                }
                            }, 4000);
                        }
                    }
                };
                runnable.run();

            }
        });

        reset_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newGame.reset();
                robotText.setText(newGame.getRobot());
                QueueText.setText(newGame.getDirection());
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