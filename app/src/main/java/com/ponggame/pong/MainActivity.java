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

import com.ponggame.pong.storage.db;
import com.ponggame.pong.storage.entity;

import java.time.Instant;
import java.util.List;

//TODO: capital letter class (camel case all classes)
// TODO: orintion portirit - fixed portrited in manifest
public class MainActivity extends AppCompatActivity {

    MediaPlayer song, button;
    AudioManager am;
    db _db;
    int songVolume,buttonVolume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        am = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
        _db = Room.databaseBuilder(getApplicationContext(),db.class,"clog")
                .allowMainThreadQueries()
                .build();
//      TODO: check if app is running - go to this function only once
//        startDatabsae();
        songVolume=_db.entityDao().getVolume("music_seekBar");
        song = MediaPlayer.create(this, R.raw.eviatar);
        song.setLooping(true);
        song.start();
        song.setVolume(songVolume,songVolume);
        buttonVolume=_db.entityDao().getVolume("soundfx_seekBar");
        button=MediaPlayer.create(this,R.raw.button);
        button.setVolume(buttonVolume,buttonVolume);
        printDatabase();
    }

    public void onPlay(View view){
        song.pause();
        button.start();
        startActivity(new Intent(this, playActivity.class));

    }

    public void onSettings(View view){
        song.pause();
        button.start();
        startActivity(new Intent(this, settingsActivity.class));
    }

    public void startDatabsae(){
        Log.d("myapp","startDatabsae function");
        _db.entityDao().deleteAll();
        entity en1=new entity("music_seekBar",10);
        entity en2=new entity("soundfx_seekBar",10);
        entity en3=new entity("speed",10);
        _db.entityDao().insertTodb(en1);
        _db.entityDao().insertTodb(en2);
        _db.entityDao().insertTodb(en3);
    }

    public void printDatabase(){
        Log.d("myapp"," ----- printDatabase function ----- ");
        Log.d("myapp","songVolume: "+songVolume);
        Log.d("myapp","buttonVolume: "+buttonVolume);
        Log.d("myapp","speed: "+_db.entityDao().getVolume("speed") );
        Log.d("myapp", " ----- end ----- ");
    }
}