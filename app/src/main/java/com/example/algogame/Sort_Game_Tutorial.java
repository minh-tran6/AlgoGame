package com.example.algogame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Sort_Game_Tutorial extends AppCompatActivity {
    TextView textInScroll;
    Button start_button_queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sort__game__tutorial);

        start_button_queue = findViewById(R.id.start_button_sort);
        start_button_queue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newSort = new Intent(getApplicationContext(),animationToSort.class);
                startActivity(newSort);
                finish();
            }
        });
        textInScroll = findViewById(R.id.textInScroll);
        textInScroll.setText("Follow the instructions on screen to complete the sort\n\n"+
                "Assume this is the first step in the outer loop of each sort meaning that the numbers only change position once\n"+
                "Here are a few refreshers on the 3 sorts in this game\n\n"+
                "1. Insertion Sort: This sorting simply moves the current number in an array into its appropriate position. It does this by moving back every position until it is the right one. This algorithm starts with the last number.\n\n"+
                "2. Bubble Sort: This algorithm simply compares the number in front of it and swap if necessary. Starts with the first number\n\n"+
                "3. Selection Sort: This is similar to insertion sort except that instead of moving back step by step, the number are immediately placed in the right position. Starts with last number\n\n"+
                "Hope you learn a little about the various sorting algorithms! Have fun! ");
    }
}