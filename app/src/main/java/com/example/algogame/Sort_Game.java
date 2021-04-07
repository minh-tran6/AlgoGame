package com.example.algogame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Sort_Game extends AppCompatActivity {
 int flag = 0;
 int random = new Random().nextInt((3-1)+1)+1;
 TextView text1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Setting layout randomly
        super.onCreate(savedInstanceState);
        if(random == 1)
        {
            setContentView(R.layout.activity_sort__game);
            text1 = (TextView) findViewById(R.id.number_text);
        }
        else if(random ==2)
        {
            setContentView(R.layout.activity_sort_game2);
            text1 = (TextView) findViewById(R.id.bAns);
        }
        else
        {
            setContentView(R.layout.activity_sort_game3);
            text1 = (TextView) findViewById(R.id.sAns);
        }

        //Initializing Views and flags text1 is global to ensure visibility
        //Insertion sort views
       ImageView Iimg2 = (ImageView) findViewById(R.id.dropZone_1);
       ImageView Iimg3 = (ImageView) findViewById(R.id.dropZone_2);
       Button subBut = (Button) findViewById(R.id.submit_button);
       //Bubble sort views
       ImageView Bimg1 = (ImageView) findViewById(R.id.dropZone3);
       ImageView Bimg2 = (ImageView) findViewById(R.id.dropZone4);
       Button subButB = (Button) findViewById(R.id.bSub);
       //Selection sort views
        ImageView Simg1 = (ImageView) findViewById(R.id.dropZone5);
        ImageView Simg2 = (ImageView) findViewById(R.id.dropZone6);
        Button subButS = (Button) findViewById(R.id.sSub);


        //Connecting number_text to longClickListener
        text1.setOnLongClickListener(longClickListener);

        //Setting drag Listeners for drop points
        Iimg2.setOnDragListener(dragListener);
        Iimg3.setOnDragListener(dragListener2);
        Bimg1.setOnDragListener(dragListener);
        Bimg2.setOnDragListener(dragListener2);
        Simg1.setOnDragListener(dragListener);
        Simg2.setOnDragListener(dragListener2);


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
        //Button for bubble Sort
        subButB.setOnClickListener(new View.OnClickListener() {
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
        //Button for selection sort
        subButS.setOnClickListener(new View.OnClickListener() {
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