package com.londonappbrewery.quizzler;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    // TODO: Declare member variables here:
    Button mButtonTrue;
    Button mButtonFalse;
    TextView mQuestionTextView; // for viewing question
    TextView mScoreTextView;
    ProgressBar mProgressBar;
    int mQuestionNumber;//tracks question
    int mQuestion; //Shows question based on id
    int mScore; //For tracing user score


    // TODO: Uncomment to create question bank
    private TrueFalse[] mQuestionBank = {
            new TrueFalse(R.string.question_1, true),
            new TrueFalse(R.string.question_2, true),
            new TrueFalse(R.string.question_3, true),
            new TrueFalse(R.string.question_4, true),
            new TrueFalse(R.string.question_5, true),
            new TrueFalse(R.string.question_6, false),
            new TrueFalse(R.string.question_7, true),
            new TrueFalse(R.string.question_8, false),
            new TrueFalse(R.string.question_9, true),
            new TrueFalse(R.string.question_10, true),
            new TrueFalse(R.string.question_11, false),
            new TrueFalse(R.string.question_12, false),
            new TrueFalse(R.string.question_13,true)
    };

    // TODO: Declare constants here
    final int PROGRESS_BAR_INCREMENT = (int) Math.ceil(100.0/mQuestionBank.length); // 100/13=8 . Progress bar will increase by 8

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButtonTrue = findViewById(R.id.true_button);
        mButtonFalse = findViewById(R.id.false_button);
        mQuestionTextView = findViewById(R.id.question_text_view);
        mScoreTextView = findViewById(R.id.score);
        mProgressBar = findViewById(R.id.progress_bar);

        mQuestion = mQuestionBank[mQuestionNumber].getQuestion();
        mQuestionTextView.setText(mQuestion);

        mButtonTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(true);
                questionUpdater();
            }
        });

        mButtonFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(false);
                questionUpdater();

            }
        });

    }

    private void questionUpdater(){
        mQuestionNumber=(mQuestionNumber+1)%mQuestionBank.length;

        if(mQuestionNumber == 0){
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("Game Over");
            alert.setCancelable(false);
            alert.setMessage("You scored "+ mScore+" points.");
            alert.setPositiveButton("Close Application", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finish();
                }
            });
            alert.show();
        }

        mQuestion = mQuestionBank[mQuestionNumber].getQuestion();
        mQuestionTextView.setText(mQuestion);
        mProgressBar.incrementProgressBy(PROGRESS_BAR_INCREMENT);
        mScoreTextView.setText("Score is " + mScore + "/" +mQuestionBank.length);
    }

    //checks whether the answer is correct or not

    private void checkAnswer(boolean userAnswer){
        boolean correctAnswer = mQuestionBank[mQuestionNumber].isAnswer();
        if(userAnswer==correctAnswer){
            Toast.makeText(getApplicationContext(),R.string.correct_toast,Toast.LENGTH_SHORT).show();
            mScore++;
        } else {
            Toast.makeText(getApplicationContext(),R.string.incorrect_toast,Toast.LENGTH_SHORT).show();
        }
    }
}
