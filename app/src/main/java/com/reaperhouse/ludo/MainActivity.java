package com.reaperhouse.ludo;

import androidx.appcompat.app.AppCompatActivity;

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

        Button rollButton;
        rollButton=findViewById(R.id.rollButton);

        final int ludoArray[]={R.drawable.dice1,
                R.drawable.dice2,
                R.drawable.dice3,
                R.drawable.dice4,
                R.drawable.dice5,
                R.drawable.dice6
        }; //Array for holding image references

        final ImageView leftDice=findViewById(R.id.image_leftDice); //Will keep it constant cause we are going to use it onClick() function
        final ImageView rightDice=findViewById(R.id.image_rightDice);

        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Dice","The button has been pressed");
                Random randomNumber=new Random();
                int rLeftNumberHolder=randomNumber.nextInt(6); // 0-5 values
                int rRightNumberHolder=randomNumber.nextInt(6); // 0-5 values
                Log.d("Dice roll","The random number for left dice is "+(rLeftNumberHolder+1)+ " and right dice is "+(rRightNumberHolder+1)); //Just to check whether it's working or not

                leftDice.setImageResource(ludoArray[rLeftNumberHolder]);
                rightDice.setImageResource(ludoArray[rRightNumberHolder]);
            }
        });
    }
}
