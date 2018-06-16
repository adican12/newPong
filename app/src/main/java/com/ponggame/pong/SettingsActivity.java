package com.ponggame.pong;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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

public class SettingsActivity extends AppCompatActivity {
    MediaPlayer button,song;
//    db _db;
    MainActivity ma;
    SeekBar music_seekBar,soundfx_seekBar,speed_seekBar;
    int speed,songVolume,buttonVolume;
    SharedPreferences sharedpreferences;
    SharedPreferences.Editor editor;

    private static final float MAX_VOLUME = 100f;
    private final int DEFAULT_VOLUME_VALUE = 50;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        // get shared prefarence
        sharedpreferences = getSharedPreferences("pongData", Context.MODE_PRIVATE);
        editor = sharedpreferences.edit();
        songVolume=sharedpreferences.getInt("music_seekBar", 10);        // getting Integer

        ma.getMusicPlayer().run();

        music_seekBar.setProgress(songVolume);
        music_seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                float output = progress / MAX_VOLUME;
                MainActivity.getMusicPlayer().getMediaPlayer().setVolume(output, output);

                editor.putInt("music_seekBar",progress);
                editor.commit();

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        buttonVolume=sharedpreferences.getInt("soundfx_seekBar", 10);        // getting Integer

        soundfx_seekBar.setProgress(buttonVolume);
        soundfx_seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                float output = progress / MAX_VOLUME;
                MainActivity.getSoundEffects().play(1);
                //TODO: change volume sound fx
                editor.putInt("soundfx_seekBar",progress);
                editor.commit();

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        speed=sharedpreferences.getInt("speed", 10);        // getting Integer
        speed_seekBar.setProgress(speed);
        speed_seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                editor.putInt("speed",progress);
                editor.commit();
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
        ma.printDatabase();
        ma.getMusicPlayer().run();
        ma.getSoundEffects().run();
        startActivity(new Intent(this, MainActivity.class));
    }
}
