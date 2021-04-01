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

public class homescreen extends MainActivity {
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

        Intent intent = getIntent();
        String new_name = intent.getStringExtra(homescreen.EXTRA_NAME);
        textView.setText(new_name);

        //------------------------------------------------------------------------------
        // STACK GAME MENU

        stackgame = findViewById(R.id.button_stack);
        stackgame.setBackgroundColor(Color.BLACK);
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
        queuegame.setBackgroundColor(Color.BLACK);
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
        sortgame.setBackgroundColor(Color.BLACK);
        sortgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newSortGame = new Intent(getApplicationContext(),Sort_Game.class);
                startActivity(newSortGame);
            }
        });

        //------------------------------------------------------------------------------
        //------------------------------------------------------------------------------
        // EXIT APP
        exitApp = findViewById(R.id.button_exit);
        exitApp.setBackgroundColor(Color.BLACK);
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
                        System.exit(0);
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });

        //------------------------------------------------------------------------------
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}