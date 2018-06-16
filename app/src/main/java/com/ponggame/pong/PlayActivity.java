package com.ponggame.pong;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.ponggame.pong.storage.db;

public class PlayActivity extends AppCompatActivity {
//    // TODO: mediaPlayer for background song
//    MediaPlayer button,song;
    SharedPreferences sharedpreferences;
    SharedPreferences.Editor editor;
    MainActivity ma;

    // TODO: soundpool for sound FX
//    db _db;
    int songVolume,buttonVolume,speed;
    PongView PongView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        PongView=findViewById(R.id.pongView);
        // shared preferences
//        sharedpreferences = getSharedPreferences("pongData", Context.MODE_PRIVATE);
//        editor = sharedpreferences.edit();
//        songVolume=sharedpreferences.getInt("music_seekBar", 10);        // getting Integer
//        ma.getMusicPlayer().run();
//        MainActivity.getMusicPlayer().getMediaPlayer().setVolume(songVolume, songVolume);


        // TODO: replace with shered prefernce - almost done
//        _db = Room.databaseBuilder(getApplicationContext(),db.class,"clog")
//                .allowMainThreadQueries()
//                .build();
//        songVolume=_db.entityDao().getVolume("music_seekBar");
//        song = MediaPlayer.create(this, R.raw.eviatar);
//        song.setLooping(true);
//        song.start();
//        song.setVolume(songVolume,songVolume);
//        buttonVolume=_db.entityDao().getVolume("soundfx_seekBar");
//        button=MediaPlayer.create(this,R.raw.button);
//        button.setVolume(buttonVolume,buttonVolume);
//        speed=_db.entityDao().getVolume("speed");
        Log.d("myapp","start game");

    }

    public void back(View view){
//        button.start();
        startActivity(new Intent(this, MainActivity.class));
    }

}
