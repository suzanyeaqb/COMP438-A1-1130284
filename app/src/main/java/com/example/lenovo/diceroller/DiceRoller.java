package com.example.lenovo.diceroller;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class DiceRoller extends AppCompatActivity {
    MediaPlayer mediaPlayer;//create object media player to play music

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice_roller);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mediaPlayer = MediaPlayer.create(this, R.raw.music);//create object to get music in folder
        mediaPlayer.start();//start music

    }

    //method to click bottom Start
    //start game
    public void startGame(View view) {
        mediaPlayer.stop();

        Intent myIntent = new Intent(DiceRoller.this, Game.class);//to open ne activity
        DiceRoller.this.startActivity(myIntent);//start new activity

    }
//method to click bottom End

    public void exitGame(View view) {
        mediaPlayer.stop();//stop music
        this.finish();//finish application running

    }


}
