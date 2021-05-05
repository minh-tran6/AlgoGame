package com.example.algogame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.service.autofill.TextValueSanitizer;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

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

        questions.add(new MC_Question("What is insertion sort's time complexity?", "n", "n^2", "1", "n^2", "What is insertion sort's space complexity?", "1", "log n","n", "1"));
        questions.add(new MC_Question("What is bubble sort's time complexity?", "n^2", "log n", "log n^2", "n^2", "What is bubble sort's space complexity?", "log n", "n^2", "1", "1"));
        questions.add(new MC_Question("What is selection sort's time complexity?", "n^3", "1", "n^2", "n^2", "What is selection sort's space complexity?", "n", "1", "log n^2", "1"));
        this.displayQuestion(currentQuestionIndex);

        MCQ_submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                advance();
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

    }

    private void advance() {
        currentQuestionIndex = (currentQuestionIndex + 1) % questions.size();
        displayQuestion(currentQuestionIndex);
    }
}

