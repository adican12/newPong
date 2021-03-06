package com.ponggame.pong;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static MyMusicRunnable mMusicPlayer;
    private static MySFxRunnable mSoundEffects;

    int songVolume;
    float buttonVolume;
    SharedPreferences sharedpreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // using shared shared preferences to get volume settings
        sharedpreferences = getSharedPreferences("pongData", Context.MODE_PRIVATE);
        editor = sharedpreferences.edit();
        songVolume=sharedpreferences.getInt("music_seekBar", 10);
        buttonVolume=(float) sharedpreferences.getInt("soundfx_seekBar", 10);

        // start music
        if (mMusicPlayer == null) {
            mMusicPlayer = new MyMusicRunnable(this);
        }
        // TODO: change volume to stored value : songVolume
//        mMusicPlayer.changeVolume(songVolume);
        AsyncHandler.post(mMusicPlayer);

        // start button
        if (mSoundEffects == null) {
            mSoundEffects = new MySFxRunnable(this);
        }
        // TODO: change volume to stored value : buttonVolume
//        mSoundEffects.getSoundPool().setVolume(R.raw.button,buttonVolume,buttonVolume);
        printDatabase();
    }

    // press onPlay button - start new acitivity
    public void onPlay(View view){
        mMusicPlayer.stopMusic();
        mSoundEffects.play(R.raw.button,buttonVolume);
        startActivity(new Intent(this, PlayActivity.class));

    }

    // press onSettings button - start new acitivity
    public void onSettings(View view){
        mMusicPlayer.stopMusic();
        mSoundEffects.play(R.raw.button,buttonVolume);
        startActivity(new Intent(this, SettingsActivity.class));
    }


    public void printDatabase(){
        Log.d("myapp"," ----- printDatabase function ----- ");
        Log.d("myapp","songVolume: "+sharedpreferences.getInt("music_seekBar", 10));
        Log.d("myapp","buttonVolume: "+sharedpreferences.getInt("soundfx_seekBar", 10));
        Log.d("myapp","speed: "+sharedpreferences.getInt("speed", 10) );
        Log.d("myapp", " ----- end ----- ");
    }

    public static MyMusicRunnable getMusicPlayer() {
        return mMusicPlayer;
    }

    public static MySFxRunnable getSoundEffects() {
        return mSoundEffects;
    }
}