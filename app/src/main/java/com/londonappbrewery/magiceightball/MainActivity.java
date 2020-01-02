package com.londonappbrewery.magiceightball;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button askButton=findViewById(R.id.askButton);
        final int ballArray[]={R.drawable.ball1,
                R.drawable.ball2,
                R.drawable.ball3,
                R.drawable.ball4,
                R.drawable.ball5
        };
        final ImageView askImage=findViewById(R.id.imageBall);
        askButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random mRandom=new Random();
                int randomVal=mRandom.nextInt(5);
                Log.d("askButton","image number "+(randomVal+1));
                askImage.setImageResource(ballArray[randomVal]);

            }
        });
    }
}
