package com.example.algogame;

public class MC_Question {
    private String question1Text;
    private String choice1A;
    private String choice1B;
    private String choice1C;
    private String correctAnswer1;
    private boolean creditAlreadyGiven1;

    private String question2Text;
    private String choice2A;
    private String choice2B;
    private String choice2C;
    private String correctAnswer2;
    private boolean creditAlreadyGiven2;

    public String getQuestion1Text() {
        return question1Text;
    }

    public void setQuestion1Text(String question1Text) {
        this.question1Text = question1Text;
    }

    public String getChoice1A() {
        return choice1A;
    }

    public void setChoice1A(String choice1A) {
        this.choice1A = choice1A;
    }

    public String getChoice1B() {
        return choice1B;
    }

    public void setChoice1B(String choice1B) {
        this.choice1B = choice1B;
    }

    public String getChoice1C() {
        return choice1C;
    }

    public void setChoice1C(String choice1C) {
        this.choice1C = choice1C;
    }

    public String getCorrectAnswer1() {
        return correctAnswer1;
    }

    public void setCorrectAnswer1(String correctAnswer1) {
        this.correctAnswer1 = correctAnswer1;
    }

    public boolean isCreditAlreadyGiven1() {
        return creditAlreadyGiven1;
    }

    public void setCreditAlreadyGiven1(boolean creditAlreadyGiven1) {
        this.creditAlreadyGiven1 = creditAlreadyGiven1;
    }

    public String getQuestion2Text() {
        return question2Text;
    }

    public void setQuestion2Text(String question2Text) {
        this.question2Text = question2Text;
    }

    public String getChoice2A() {
        return choice2A;
    }

    public void setChoice2A(String choice2A) {
        this.choice2A = choice2A;
    }

    public String getChoice2B() {
        return choice2B;
    }

    public void setChoice2B(String choice2B) {
        this.choice2B = choice2B;
    }

    public String getChoice2C() {
        return choice2C;
    }

    public void setChoice2C(String choice2C) {
        this.choice2C = choice2C;
    }

    public String getCorrectAnswer2() {
        return correctAnswer2;
    }

    public void setCorrectAnswer2(String correctAnswer2) {
        this.correctAnswer2 = correctAnswer2;
    }

    public boolean isCreditAlreadyGiven2() {
        return creditAlreadyGiven2;
    }

    public void setCreditAlreadyGiven2(boolean creditAlreadyGiven2) {
        this.creditAlreadyGiven2 = creditAlreadyGiven2;
    }

    public boolean isCorrectAnswer (String selectedAnswer1, String selectedAnswer2) {
        return (selectedAnswer1.equals(correctAnswer1) && selectedAnswer2.equals(correctAnswer2));
    }

    public MC_Question(String question1Text, String choice1A, String choice1B, String choice1C, String correctAnswer1, String question2Text, String choice2A, String choice2B, String choice2C, String correctAnswer2) {
        this.question1Text = question1Text;
        this.choice1A = choice1A;
        this.choice1B = choice1B;
        this.choice1C = choice1C;
        this.correctAnswer1 = correctAnswer1;
        this.question2Text = question2Text;
        this.choice2A = choice2A;
        this.choice2B = choice2B;
        this.choice2C = choice2C;
        this.correctAnswer2 = correctAnswer2;
        this.creditAlreadyGiven1 = false;
        this.creditAlreadyGiven2 = false;
    }

    public String toString(String questionText) {
        return questionText;
    }
}
