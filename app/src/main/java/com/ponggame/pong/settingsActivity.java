package com.ponggame.pong;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;

import com.ponggame.pong.storage.db;
import com.ponggame.pong.storage.entity;

import java.util.List;

public class settingsActivity extends AppCompatActivity {
    MediaPlayer button,song;
    db _db;
    SeekBar music_seekBar,soundfx_seekBar,speed_seekBar;
    int speed,songVolume,buttonVolume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: change volume on media player dosen't work
        setContentView(R.layout.activity_settings);
        button= MediaPlayer.create(this,R.raw.button);
        music_seekBar= (SeekBar)findViewById(R.id.music_seekBar);
        soundfx_seekBar= (SeekBar)findViewById(R.id.soundfx_seekBar);
        speed_seekBar= (SeekBar)findViewById(R.id.speed_seekBar);

        // TODO: replace with shered prefernce
        _db = Room.databaseBuilder(getApplicationContext(),db.class,"clog")
                .allowMainThreadQueries()
                .build();
        songVolume=_db.entityDao().getVolume("music_seekBar");
        song = MediaPlayer.create(this, R.raw.eviatar);
        song.setLooping(true);
        song.start();
        song.setVolume(songVolume,songVolume);
        music_seekBar.setProgress(songVolume);
        music_seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                song.setVolume(progress,progress);

                entity Entity = new entity("music_seekBar",progress);
                _db.entityDao().updateEntity(Entity);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        buttonVolume= _db.entityDao().getVolume("soundfx_seekBar");
        button.setVolume(buttonVolume,buttonVolume);
        soundfx_seekBar.setProgress(buttonVolume);
        soundfx_seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                button.setVolume(progress,progress);

                entity Entity = new entity("soundfx_seekBar",progress);
                _db.entityDao().updateEntity(Entity);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        speed= _db.entityDao().getVolume("speed");
        speed_seekBar.setProgress(speed);
        speed_seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                entity Entity = new entity("speed",progress);
                _db.entityDao().updateEntity(Entity);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
    public void onOK(View view){
        song.pause();
        button.start();
        startActivity(new Intent(this, MainActivity.class));
    }
}
