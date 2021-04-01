package com.example.algogame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.algogame.Object.Stack_Object;

public class Stack_Game extends MainActivity {
    TextView prompt;
    TextView scramble;
    TextView stack;
    TextView result;
    TextView promptText;
    TextView scrambleText;
    TextView stackText;
    TextView resultText;

    Button push_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stack__game);

        Stack_Object newGame = new Stack_Object();

        prompt = findViewById(R.id.prompt);
        scramble = findViewById(R.id.scramble);
        stack = findViewById(R.id.stack);
        result = findViewById(R.id.result);

        promptText = findViewById(R.id.promptText);
        scrambleText = findViewById(R.id.scrambleText);
        stackText = findViewById(R.id.stackText);
        resultText = findViewById(R.id.resultText);

        push_button = findViewById(R.id.push_button);

        //Generating Prompt
            String bufferPrompt = "BIKECYCLE";
            promptText.setText(newGame.getPrompt(1));

        //Scramble Text
            newGame.setScramble();
            scrambleText = findViewById((R.id.scrambleText));
            scrambleText.setText(newGame.getScramble());

        push_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stackText.setText(newGame.getStack());
                scrambleText.setText(newGame.getScramble());
            }
        }); ;

    }





}