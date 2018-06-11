package com.ponggame.pong.storage;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class entitty {
    @PrimaryKey(autoGenerate = true)int id;

}
