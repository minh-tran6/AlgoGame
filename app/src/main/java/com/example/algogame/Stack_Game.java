package com.example.algogame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class Stack_Game extends AppCompatActivity {
    TextView prompt;
    TextView scramble;
    TextView stack;
    TextView result;
    TextView promptText;
    TextView scrambleText;
    TextView stackText;
    TextView resultText;

    Button changeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stack__game);

        prompt = findViewById(R.id.prompt);
        scramble = findViewById(R.id.scramble);
        stack = findViewById(R.id.stack);
        result = findViewById(R.id.result);

        promptText = findViewById(R.id.promptText);
        scrambleText = findViewById(R.id.scrambleText);
        stackText = findViewById(R.id.stackText);
        resultText = findViewById(R.id.resultText);

        //Generating Prompt
            String bufferPrompt = "BIKECYCLE";
            promptText.setText(bufferPrompt);
        //

        //Scramble Text
            String bufferScramble = "CC";
            scrambleText = findViewById((R.id.scrambleText));
            scrambleText.setText(bufferScramble);

            //((TextView)findViewById(R.id.scramble).setText(bufferScramble));

        //
            //changeText= findViewByID(R.id.changeText);
            //changeText.setOnClickListener();
        //
    }





}