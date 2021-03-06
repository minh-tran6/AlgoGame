package com.example.algogame;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class homescreen extends AppCompatActivity {
    Button stackgame;
    Button queuegame;
    Button sortgame;
    Button exitApp;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);
        textView = findViewById(R.id.player);

        String new_name = getIntent().getExtras().getString("name");
        textView.setText(new_name);

        //------------------------------------------------------------------------------
        // STACK GAME MENU

        stackgame = findViewById(R.id.button_stack);
        stackgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent newStackGame = new Intent(homescreen.this,PushandPop_Stack_Tutorial.class);
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
                Intent newQueueGame = new Intent(homescreen.this,QueueandDequeue_Queue_Tutorial.class);
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
                Intent newSortGame = new Intent(homescreen.this,Sort_Game_Tutorial.class);
                startActivity(newSortGame);


            }
        });

        //------------------------------------------------------------------------------
        //------------------------------------------------------------------------------
        // EXIT APP
        exitApp = findViewById(R.id.button_exit);
        exitApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(homescreen.this);
                builder.setMessage("Do you want to exit ?");
                builder.setCancelable(true);
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        dialog.cancel();
                    }
                });
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        finish();
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });

        //------------------------------------------------------------------------------
    }

}