package com.ponggame.pong;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class playActivity extends AppCompatActivity {
    MediaPlayer button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        button= MediaPlayer.create(this,R.raw.button);

    }
    public void back(View view){
        button.start();
        startActivity(new Intent(this, MainActivity.class));
    }
}
