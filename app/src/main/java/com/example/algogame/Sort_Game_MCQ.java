package com.example.algogame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.service.autofill.TextValueSanitizer;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Sort_Game_MCQ extends AppCompatActivity {

    private static TextView MCQ_question1;
    private static RadioGroup MCQ_rg1;
    private static RadioButton rg1_selected;
    private static RadioButton rd_1;
    private static RadioButton rd_2;
    private static RadioButton rd_3;

    private static TextView MCQ_question2;
    private static RadioGroup MCQ_rg2;
    private static RadioButton rg2_selected;
    private static RadioButton rd_4;
    private static RadioButton rd_5;
    private static RadioButton rd_6;

    private static Button MCQ_submit;

    private ArrayList<MC_Question> questions;
    private int currentQuestionIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sort__game__m_c_q);
        this.initialize();
    }

    private void initialize() {
        MCQ_question1 = (TextView)findViewById(R.id.MCQ_question1);
        MCQ_rg1 = (RadioGroup)findViewById(R.id.MCQ_rg1);
        rd_1 = (RadioButton)findViewById(R.id.rd_1);
        rd_2 = (RadioButton)findViewById(R.id.rd_2);
        rd_3 = (RadioButton)findViewById(R.id.rd_3);

        MCQ_question2 = (TextView)findViewById(R.id.MCQ_question2);
        MCQ_rg2 = (RadioGroup)findViewById(R.id.MCQ_rg2);
        rd_4 = (RadioButton)findViewById(R.id.rd_4);
        rd_5 = (RadioButton)findViewById(R.id.rd_5);
        rd_6 = (RadioButton)findViewById(R.id.rd_6);

        MCQ_submit = (Button)findViewById(R.id.MCQ_submit);

        questions = new ArrayList<MC_Question>();

        questions.add(new MC_Question("What is insertion sort's time complexity?", "n", "n^2", "1", "b", "What is insertion sort's space complexity?", "1", "log n","n", "a"));
        questions.add(new MC_Question("What is bubble sort's time complexity?", "n^2", "log n", "log n^2", "a", "What is bubble sort's space complexity?", "log n", "n^2", "1", "c"));
        questions.add(new MC_Question("What is selection sort's time complexity?", "n^3", "1", "n^2", "c", "What is selection sort's space complexity?", "n", "1", "log n^2", "b"));
        this.displayQuestion(currentQuestionIndex);

        MCQ_submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(this.answerIsRight()){
                    Toast.makeText(getApplicationContext(), "Correct.", Toast.LENGTH_SHORT).show();
                    advance();
                } else {
                    Toast.makeText(getApplicationContext(), "Try again.", Toast.LENGTH_SHORT).show();
                }
            }

            private boolean answerIsRight() {
                String answer1 = "x";
                String answer2 = "x";
                int id1 = MCQ_rg1.getCheckedRadioButtonId();
                int id2 = MCQ_rg2.getCheckedRadioButtonId();
                rg1_selected = (RadioButton)findViewById(id1);
                rg2_selected = (RadioButton)findViewById(id2);
                if(rg1_selected == rd_1) answer1 = "a";
                if(rg1_selected == rd_2) answer1 = "b";
                if(rg1_selected == rd_3) answer1 = "c";
                if(rg2_selected == rd_4) answer2 = "a";
                if(rg2_selected == rd_5) answer2 = "b";
                if(rg2_selected == rd_6) answer2 = "c";
                return questions.get(currentQuestionIndex).isCorrectAnswer(answer1, answer2);
            }
        });
    }
    private void displayQuestion(int index) {
        MCQ_question1.setText(questions.get(currentQuestionIndex).getQuestion1Text());
        MCQ_question2.setText(questions.get(currentQuestionIndex).getQuestion2Text());
        rd_1.setText(questions.get(currentQuestionIndex).getChoice1A());
        rd_2.setText(questions.get(currentQuestionIndex).getChoice1B());
        rd_3.setText(questions.get(currentQuestionIndex).getChoice1C());
        rd_4.setText(questions.get(currentQuestionIndex).getChoice2A());
        rd_5.setText(questions.get(currentQuestionIndex).getChoice2B());
        rd_6.setText(questions.get(currentQuestionIndex).getChoice2C());
        MCQ_rg1.clearCheck();
        MCQ_rg2.clearCheck();
    }

    private void advance() {
        currentQuestionIndex = (currentQuestionIndex + 1);
        if(currentQuestionIndex > 3)
            return; // Remove this and add in how we move on from the MCQ section.
        displayQuestion(currentQuestionIndex);
    }
}

