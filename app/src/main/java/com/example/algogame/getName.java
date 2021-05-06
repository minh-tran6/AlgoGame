package com.example.algogame;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class getName extends AppCompatActivity {

    Button button_get_name;
    String user_name ;
    public static final String EXTRA_NAME = "name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_name);
        button_get_name = findViewById(R.id.button_name);
        button_get_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getName.this);
                builder.setTitle("Enter your name: ");

                final EditText name = new EditText(getName.this);
                name.setInputType(InputType.TYPE_CLASS_TEXT);
                builder.setView(name);

                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        user_name = name.getText().toString();
                        Intent intent = new Intent( getName.this, homescreen.class);
                        intent.putExtra(EXTRA_NAME,user_name);
                        startActivity(intent);
                        finish();

                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        dialog.cancel();
                    }
                });
                builder.show();
            }

        });
    }

}