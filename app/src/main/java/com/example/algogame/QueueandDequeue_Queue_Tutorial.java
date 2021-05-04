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
                Intent newQueue = new Intent(getApplicationContext(),animationToQueue.class);
                startActivity(newQueue);
                finish();
            }
        });
        textInScroll = findViewById(R.id.textInScroll);
        textInScroll.setText("Your  goal  is  to  make  scramble  word  to  become  prompt  word.\n" +
                "\n\n\n" +
                "1.  LEFT  :  move  your  Robot  (|)  to  the  left.\n\n" +
                "2.  RIGHT  :  move  your  Robot  (|)  to  the  right.\n\n" +
                "3.  DOWN  :  at  the  position  of  Robot  (|) ,  click  this  button  means  you  are  choosing  this  letter  of  Scramble  to  and  move  to  Result.\n\n" +
                "4.  RESET  :  restart  the  game  and  try  again  with  Scramble  word.\n\n" +
                "5.  SUBMIT  :  when  you’re  ready  with  your  RESULT.\n\n\n\n" +
                "MAKE  SURE  YOU ' RE  FINISHED  BEFORE  TIME ' S  UP.");
    }
}