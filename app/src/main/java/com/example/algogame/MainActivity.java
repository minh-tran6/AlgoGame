package com.example.algogame;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button button_get_name;
    String user_name ;
    EditText getName;
    public static final String EXTRA_NAME = "name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getName = findViewById(R.id.getName);
        button_get_name = findViewById(R.id.button_name);

        button_get_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user_name = getName.getText().toString();
                Intent intent = new Intent( MainActivity.this, homescreen.class);
                intent.putExtra(EXTRA_NAME,user_name);
                startActivity(intent);
            }
        });
    }

}