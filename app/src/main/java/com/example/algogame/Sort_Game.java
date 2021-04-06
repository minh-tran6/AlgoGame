package com.example.algogame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.media.Image;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Sort_Game extends AppCompatActivity {
 int flag = 0;
 TextView text1 = (TextView) findViewById(R.id.number_text);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sort__game);
        //Initializing Views and flags text1 is global to ensure visibility

       ImageView img2 = (ImageView) findViewById(R.id.dropZone_1);
       ImageView img3 = (ImageView) findViewById(R.id.dropZone_2);
       Button subBut = (Button) findViewById(R.id.submit_button);


        //Connecting number_text to longClickListener
        text1.setOnLongClickListener(longClickListener);

        //Setting drag Listener for img2 and img3
        img2.setOnDragListener(dragListener);
        img3.setOnDragListener(dragListener2);

        //Evan use "flag" to determine what the submit button does. This is a test for now
        //Flag 1 is correct, 2 is wrong, 0 is when the user hasnt properly put the textView onto the correct drop zone.
        subBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag == 1)
                {
                    Toast.makeText(Sort_Game.this, "Correct! Evan will implement MCQ", Toast.LENGTH_SHORT).show();
                }
                else if(flag == 2)
                {
                    Toast.makeText(Sort_Game.this, "Wrong! Try Again!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(Sort_Game.this, "Please put the number into the position you think is right", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
    //On click lister to act on long click. This will start the drag
    View.OnLongClickListener longClickListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            ClipData data = ClipData.newPlainText("","");
            View.DragShadowBuilder myShadowBuilder = new View.DragShadowBuilder(v);
            v.startDrag(data, myShadowBuilder,v, 0);
            return true;
        }
    };
    //This will activate when the drag starts same for dragListener2. Based on the action the respective flag will be set
    //draglistener 1 is the correct dropzone while the other is wrong
    View.OnDragListener dragListener = new View.OnDragListener() {
        @Override
        public boolean onDrag(View v, DragEvent event) {

            int dragevent = event.getAction();
            View view =  (View) event.getLocalState();

            switch(dragevent)
            {
                case DragEvent.ACTION_DRAG_ENTERED:
                    flag = 1;
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    flag = 0;
                    break;
                case DragEvent.ACTION_DROP:
                    flag = 1;
                    view.animate()
                            .x(text1.getX())
                            .y(text1.getY())
                            .setDuration(700)
                            .start();
                    break;
            }
            return true;
        }
    };
    View.OnDragListener dragListener2 = new View.OnDragListener() {
        @Override
        public boolean onDrag(View v, DragEvent event) {

            int dragevent = event.getAction();
            View view =  (View) event.getLocalState();

            switch(dragevent)
            {
                case DragEvent.ACTION_DRAG_ENTERED:
                    flag = 2;
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    flag = 0;
                    break;
                case DragEvent.ACTION_DROP:
                    flag = 2;
                    view.animate()
                            .x(text1.getX())
                            .y(text1.getY())
                            .setDuration(700)
                            .start();
                    break;
            }

            return true;
        }
    };
}