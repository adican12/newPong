package com.ponggame.pong;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

public class settingsActivity extends AppCompatActivity {
    MediaPlayer button;
    MediaPlayer song;

    SeekBar music_seekBar,soundfx_seekBar,speed_seekBar;

    AudioManager am;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        song = MediaPlayer.create(this, R.raw.eviatar);
        song.setLooping(true);
        song.start();

        music_seekBar= (SeekBar)findViewById(R.id.music_seekBar);
        soundfx_seekBar= (SeekBar)findViewById(R.id.soundfx_seekBar);
        speed_seekBar= (SeekBar)findViewById(R.id.speed_seekBar);

        am = (AudioManager)getSystemService(Context.AUDIO_SERVICE);

        music_seekBar.setMax(am.getStreamMaxVolume(AudioManager.STREAM_MUSIC));
        music_seekBar.setProgress(am.getStreamVolume(AudioManager.STREAM_MUSIC));

        music_seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                am.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        button= MediaPlayer.create(this,R.raw.button);
    }
    public void onOK(View view){
        song.pause();
        button.start();
        startActivity(new Intent(this, MainActivity.class));
    }
}
