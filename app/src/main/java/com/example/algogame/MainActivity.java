package com.example.algogame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button stackgame;
    Button queuegame;
    Button sortgame;
    Button exitApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //------------------------------------------------------------------------------
        // STACK GAME MENU
        stackgame = findViewById(R.id.button_stack);
        stackgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newStackGame = new Intent(getApplicationContext(),PushandPop_Stack_Tutorial.class);
                startActivity(newStackGame);
            }
        });

        //------------------------------------------------------------------------------
        //------------------------------------------------------------------------------
        // QUEUE GAME MENU
        queuegame = findViewById(R.id.button_queue);
        queuegame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newQueueGame = new Intent(getApplicationContext(),Queue_Game.class);
                startActivity(newQueueGame);
            }
        });

        //------------------------------------------------------------------------------
        //------------------------------------------------------------------------------
        // SORT GAME MENU
        sortgame = findViewById(R.id.button_sort);
        sortgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newSortGame = new Intent(getApplicationContext(),Sort_Game.class);
                startActivity(newSortGame);
            }
        });

        //------------------------------------------------------------------------------
}
}