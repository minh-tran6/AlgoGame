package com.example.algogame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Stack_Game extends AppCompatActivity {
    TextView prompt;
    TextView scramble;
    TextView stack;
    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stack__game);

        prompt = findViewById(R.id.prompt);
        scramble = findViewById(R.id.scramble);
        stack = findViewById(R.id.stack);
        result = findViewById(R.id.result);

        //Generating Prompt
        String bufferPrompt = "BIKECYCLE";
        prompt.setText(bufferPrompt);
        //

        //Scramble Text
        String bufferScramble = "EBKIYCELC";
        scramble.setText(bufferScramble);
        //
    }
}