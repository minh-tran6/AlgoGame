package com.example.algogame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Sort_Game extends AppCompatActivity {

    int flag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Setting layout randomly
        super.onCreate(savedInstanceState);
        //int flag;
        int random = new Random().nextInt((3-1)+1)+1;
        TextView text1;
        Log.i("myTag",random + "");
        //On click lister to act on long click. This will start the drag
        View.OnTouchListener longClickListener = new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                ClipData data = ClipData.newPlainText("", "");
                View.DragShadowBuilder myShadowBuilder = new View.DragShadowBuilder(v);
                v.startDrag(data, myShadowBuilder, v, 0);
                return true;
            }
        };
/*
            @Override
            public boolean onTouch(View v) {
                ClipData data = ClipData.newPlainText("","");
                View.DragShadowBuilder myShadowBuilder = new View.DragShadowBuilder(v);
                v.startDrag(data, myShadowBuilder,v, 0);
                return true;
            }
        };
        */

        //This will activate when the drag starts same for dragListener2. Based on the action the respective flag will be set
        //draglistener 1 is the correct dropzone while the other is wrong
        View.OnDragListener dragListener = new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {

                int dragevent = event.getAction();
                View view =  (View) event.getLocalState();
                ImageView drop;
                if(random == 1)
                {
                     drop = (ImageView) findViewById(R.id.dropZone_1);
                }
                else if(random == 2)
                {
                     drop = (ImageView) findViewById(R.id.dropZone3);
                }
                else
                {
                    drop = (ImageView) findViewById(R.id.dropZone5);
                }

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
                       // view.setX(event.getX());
                        //view.setY(event.getY());

                        view.animate()
                                .x(drop.getX())
                                .y(drop.getY())
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
                ImageView drop;
                if(random == 1)
                {
                    drop = (ImageView) findViewById(R.id.dropZone_2);
                }
                else if(random == 2)
                {
                    drop = (ImageView) findViewById(R.id.dropZone4);
                }
                else
                {
                    drop = (ImageView) findViewById(R.id.dropZone6);
                }
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
                       // view.setX(event.getX());
                       // view.setY(event.getY());

                        view.animate()
                                .x(drop.getX())
                                .y(drop.getY())
                                .setDuration(700)
                                .start();


                        break;
                }

                return true;
            }
        };
        if(random == 1)
        {
            setContentView(R.layout.activity_sort__game);
            text1 = (TextView) findViewById(R.id.number_text);

            //Connecting number_text to longClickListener
            text1.setOnTouchListener(longClickListener);

            //Initializing Views and flags text1 is global to ensure visibility
            //Insertion sort views
            ImageView Iimg2 = (ImageView) findViewById(R.id.dropZone_1);
            ImageView Iimg3 = (ImageView) findViewById(R.id.dropZone_2);
            Button subBut = (Button) findViewById(R.id.submit_button);

            //Setting drag Listeners for drop points
            Iimg2.setOnDragListener(dragListener);
            Iimg3.setOnDragListener(dragListener2);

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
        else if(random ==2)
        {
            setContentView(R.layout.activity_sort_game2);
            text1 = (TextView) findViewById(R.id.bAns);

            //Connecting bAns to longClickListener
            text1.setOnTouchListener(longClickListener);

            //Bubble sort views
            ImageView Bimg1 = (ImageView) findViewById(R.id.dropZone3);
            ImageView Bimg2 = (ImageView) findViewById(R.id.dropZone4);
            Button subButB = (Button) findViewById(R.id.bSub);
            //Setting drop zones
            Bimg1.setOnDragListener(dragListener);
            Bimg2.setOnDragListener(dragListener2);
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
        }
        else
        {
            setContentView(R.layout.activity_sort_game3);
            text1 = (TextView) findViewById(R.id.sAns);

            //Connecting sAns to longClickListener
            text1.setOnTouchListener(longClickListener);


            //Selection sort views
            ImageView Simg1 = (ImageView) findViewById(R.id.dropZone5);
            ImageView Simg2 = (ImageView) findViewById(R.id.dropZone6);
            Button subButS = (Button) findViewById(R.id.sSub);
            //Setting drop zones
            Simg1.setOnDragListener(dragListener);
            Simg2.setOnDragListener(dragListener2);

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



















    }


}