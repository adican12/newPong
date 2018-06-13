package com.ponggame.pong.storage;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class entity {
//    @PrimaryKey(autoGenerate = true)int id;
//    @ColumnInfo(name = "info")
    @PrimaryKey @NonNull String info;
//    @ColumnInfo(name = "volume")
    int volume;

    public entity() {
        this.info="empty";
    }

    public entity(String _info, int _volume){
        this.info=_info;
        this.volume=_volume;
    }

    @Override
    public String toString() {
        return "entity{" +
                "info='" + info + '\'' +
                ", volume=" + volume +
                '}';
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }


}
