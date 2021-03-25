package com.example.algogame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button stackgame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //------------------------------------------------------------------------------
        // STACK GAME MENU
        stackgame = findViewById(R.id.stackgame);
        stackgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newStackGame = new Intent(getApplicationContext(),PushandPop_Stack_Tutorial.class);
                startActivity(newStackGame);
            }
        });

        //------------------------------------------------------------------------------
}
}