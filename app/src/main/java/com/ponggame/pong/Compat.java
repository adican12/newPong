package com.ponggame.pong;

import android.media.SoundPool;
import android.os.Build;

public class Compat {
    public static SoundPool createSoundPool() {
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
            return Api21Plus.createSoundPool();
        }
        return OldApis.createSoundPool();
    }
}