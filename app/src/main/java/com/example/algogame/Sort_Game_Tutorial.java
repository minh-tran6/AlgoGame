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
        textInScroll.setText("Inset your tutorial here");
    }
}