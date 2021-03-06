package com.ponggame.pong;

import android.content.Context;
import android.media.MediaPlayer;

import java.io.IOException;

class MyMusicRunnable implements Runnable, MediaPlayer.OnCompletionListener {
    Context appContext;
    MediaPlayer mPlayer;
    boolean musicIsPlaying = false;

    public MyMusicRunnable(Context c) {
        // be careful not to leak the activity context.
        // can keep the app context instead.
        appContext = c.getApplicationContext();
    }

    public boolean isMusicIsPlaying() {
        return musicIsPlaying;
    }

    /**
     * MediaPlayer.OnCompletionListener callback
     *
     * @param mp
     */
    @Override
    public void onCompletion(MediaPlayer mp) {
        // loop back - play again
        if (musicIsPlaying && mPlayer != null) {
            mPlayer.start();
        }
    }

    /**
     * toggles the music player state
     * called asynchronously every time the play/pause button is pressed
     */
    @Override
    public void run() {

        if (musicIsPlaying) {
            mPlayer.stop();
            musicIsPlaying = false;
        } else {
            if (mPlayer == null) {
                mPlayer = MediaPlayer.create(appContext, R.raw.eviatar);
                mPlayer.start();
                mPlayer.setOnCompletionListener(this); // MediaPlayer.OnCompletionListener
            } else {
                try {
                    mPlayer.prepare();
                    mPlayer.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            musicIsPlaying = true;
        }

    }


    public MediaPlayer getMediaPlayer() {
        return mPlayer;
    }

    public void stopMusic(){
        this.mPlayer.stop();
        this.musicIsPlaying=false;
    }

    // TODO: not working !! crushing app 
    public void changeVolume(int output){
        this.mPlayer.setVolume(output,output);
    }
}