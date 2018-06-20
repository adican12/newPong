package com.ponggame.pong;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class PlayActivity extends AppCompatActivity {
//    // TODO: mediaPlayer for background song
    SharedPreferences sharedpreferences;
    SharedPreferences.Editor editor;
    MainActivity ma;

    // TODO: soundpool for sound FX
    int songVolume,buttonVolume,speed;
    PongView PongView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        PongView=findViewById(R.id.pongView);
        // TODO: add speed  ball.v0 setV0()
        // TODO: add sound fx
        // shared preferences
//        sharedpreferences = getSharedPreferences("pongData", Context.MODE_PRIVATE);
//        editor = sharedpreferences.edit();
//        songVolume=sharedpreferences.getInt("music_seekBar", 10);        // getting Integer
//        ma.getMusicPlayer().run();
//        MainActivity.getMusicPlayer().getMediaPlayer().setVolume(songVolume, songVolume);

        Log.d("myapp","start game");
    }
}
