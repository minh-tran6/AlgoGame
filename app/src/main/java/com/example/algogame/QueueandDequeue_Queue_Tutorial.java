package com.example.algogame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class QueueandDequeue_Queue_Tutorial extends AppCompatActivity {

    TextView textInScroll;
    Button start_button_queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_queueand_dequeue__queue__tutorial);

        start_button_queue = findViewById(R.id.start_button_queue);
        start_button_queue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newQueue = new Intent(getApplicationContext(),Queue_Game.class);
                startActivity(newQueue);
                finish();
            }
        });
        textInScroll = findViewById(R.id.textInScroll);
        textInScroll.setText("Your  goal  is  to  make  scramble  word  to  become  prompt  word.\n" +
                "\n\n\n" +
                "1.  PUSH  :  move  first  letter  of  Scramble  to  the  Stack  until  there  is  no  more  letters  left  in  Scramble.\n\n" +
                "2.  POP  :  move  the  top  letter  from  the  Stack  to  Result  until  there  is  no  more  letters  left  in  Stack.\n\n" +
                "3.  RESET  :  restart  the  game  and  try  again  with  Scramble  word.\n\n" +
                "4.  SUBMIT  :  when  you’re  ready  with  your  RESULT.");
    }
}