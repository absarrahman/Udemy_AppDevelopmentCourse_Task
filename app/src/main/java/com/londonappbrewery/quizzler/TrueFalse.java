package com.londonappbrewery.quizzler;

public class TrueFalse {
    private int mQuestion;// question id in strings.xml
    private boolean mAnswer;

    public TrueFalse(int question, boolean answer) {
        mQuestion = question;
        mAnswer = answer;
    }

    public int getQuestion() {
        return mQuestion;
    }

    public void setQuestion(int question) {
        mQuestion = question;
    }

    public boolean isAnswer() {
        return mAnswer;
    }

    public void setAnswer(boolean answer) {
        mAnswer = answer;
    }
}
