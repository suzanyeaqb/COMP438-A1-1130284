package com.example.lenovo.diceroller;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

//activity game
public class Game extends AppCompatActivity {

    int randomNumber;//integer number to random number
    MediaPlayer mediaPlayer;//create object media player to play music

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);


        GradientDrawable gd = new GradientDrawable();//to change design text
        gd.setCornerRadius(2);
        TextView tv = (TextView) findViewById(R.id.txt);
        gd.setColor(getResources().getColor(R.color.white));
        gd.setSize(50, 30);
        tv.setBackgroundDrawable(gd);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        createRandomNumber();//call method random number

    }

    //method set random number between 0-1000
    private void createRandomNumber() {
        Random random = new Random();
        randomNumber = random.nextInt(1000);


    }

    //method to set action onclick restart button
    public void restart(View view) {
        createRandomNumber();//create new random number
        TextView textView = (TextView) findViewById(R.id.txt);//txt view in activity
        textView.setText("");//set text number is empty

    }


    //method  to check input user and random number in range { smaller,greater,very close ,equal}
    public void check(View view) {


        TextView textView = (TextView) findViewById(R.id.txt);

        int number = Integer.parseInt(textView.getText().toString());

        if (number > randomNumber) {
            //if difference  number is setting user and random number equal or smaller than  and the number is greater/**/
            if (Math.abs(number - randomNumber) <= 5) {
//dialog to show massage is smaller or greater or very close or win
                AlertDialog alertDialog = new AlertDialog.Builder(this).create();
                alertDialog.setTitle("The Number :" + number);
                alertDialog.setMessage("Very Close!!");
                alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
// here you can add functions
                    }
                });
                alertDialog.setIcon(R.drawable.dice1);
                alertDialog.show();
            } else {
                AlertDialog alertDialog = new AlertDialog.Builder(this).create();
                alertDialog.setTitle("The Number :" + number);
                alertDialog.setMessage("Smaller");
                alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
// here you can add functions
                    }
                });
                alertDialog.setIcon(R.drawable.dice1);
                alertDialog.show();
            }


        } else if (number < randomNumber) {
            //if difference  number is setting user and random number equal or smaller than  and the number is greater smaller/**/
            if (Math.abs(number - randomNumber) <= 5) {
                AlertDialog alertDialog = new AlertDialog.Builder(this).create();
                alertDialog.setTitle("The Number :" + number);
                alertDialog.setMessage("Very Close!!");
                alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
// here you can add functions
                    }
                });
                alertDialog.setIcon(R.drawable.dice1);
                alertDialog.show();

            } else {

                AlertDialog alertDialog = new AlertDialog.Builder(this).create();
                alertDialog.setTitle("The Number :" + number);
                alertDialog.setMessage("Greater");
                alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
// here you can add functions
                    }
                });
                alertDialog.setIcon(R.drawable.dice1);
                alertDialog.show();
            }


        } else if (number == randomNumber) {//if number setting user is equal random number
            AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            mediaPlayer = MediaPlayer.create(this, R.raw.win);//create object to get music in folder
            mediaPlayer.start();
            alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
// here you can add functions
                    mediaPlayer.stop();

                }
            });
            alertDialog.setTitle("Winner the number is :" + number);

            alertDialog.setIcon(R.drawable.win);
            alertDialog.show();
        }
    }

}
