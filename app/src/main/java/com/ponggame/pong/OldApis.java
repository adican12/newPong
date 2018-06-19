package com.ponggame.pong;

import android.media.AudioManager;
import android.media.SoundPool;

@SuppressWarnings("deprecation")
class OldApis {
    public static SoundPool createSoundPool() {
        return new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
    }
}