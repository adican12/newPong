package com.ponggame.pong;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    MediaPlayer song;
    MediaPlayer button;
    AudioManager am;
    int currentvol;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        am = (AudioManager)getSystemService(Context.AUDIO_SERVICE);

        song = MediaPlayer.create(this, R.raw.eviatar);
        song.setLooping(true);
        song.start();

        button=MediaPlayer.create(this,R.raw.button);
    }



    public void onPlay(View view){
        song.pause();
        button.start();
        startActivity(new Intent(this , Game.class));

    }


    public void onSettings(View view){
        song.pause();
        button.start();
        startActivity(new Intent(this, settingsActivity.class));
    }

}
