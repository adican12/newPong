package com.ponggame.pong;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.ponggame.pong.storage.db;

public class playActivity extends AppCompatActivity {
    MediaPlayer button,song;
    db _db;
    int songVolume,buttonVolume,speed;
    pongView Pongview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        Pongview = findViewById(R.id.pongGame);

        _db = Room.databaseBuilder(getApplicationContext(),db.class,"clog")
                .allowMainThreadQueries()
                .build();
        songVolume=_db.entityDao().getVolume("music_seekBar");
        song = MediaPlayer.create(this, R.raw.eviatar);
        song.setLooping(true);
        song.start();
        song.setVolume(songVolume,songVolume);
        buttonVolume=_db.entityDao().getVolume("soundfx_seekBar");
        button=MediaPlayer.create(this,R.raw.button);
        button.setVolume(buttonVolume,buttonVolume);
        speed=_db.entityDao().getVolume("speed");

    }
    public void back(View view){
        button.start();
        startActivity(new Intent(this, MainActivity.class));
    }
}
