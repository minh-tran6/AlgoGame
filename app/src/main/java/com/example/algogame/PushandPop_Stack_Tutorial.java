package com.example.algogame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PushandPop_Stack_Tutorial extends MainActivity {

    Button start_button_stack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pushand_pop__stack__tutorial);

        start_button_stack = findViewById(R.id.start_button_stack);
        start_button_stack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newGame = new Intent(getApplicationContext(),Stack_Game.class);
                startActivity(newGame);
            }
        });
    }


}