package com.example.algogame;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.algogame.Object.Stack_Object;
import com.example.algogame.Object.SubmitDialog;

public class Stack_Game extends AppCompatActivity {
    TextView prompt;
    TextView scramble;
    TextView stack;
    TextView result;
    TextView promptText;
    TextView scrambleText;
    TextView stackText;
    TextView resultText;

    Button push_button;
    Button pop_button;
    Button submitStack_button;

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
        pop_button = findViewById(R.id.pop_button);
        submitStack_button = findViewById(R.id.submitStack_button);

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
                if(newGame.checkMatching()) {
                    openDialog();
                }
                else
                {

                }
            }
        });

    }

    private void openDialog() {
        SubmitDialog submitDialog = new SubmitDialog();
        submitDialog.show(getSupportFragmentManager(),"submitDialog");
    }


}