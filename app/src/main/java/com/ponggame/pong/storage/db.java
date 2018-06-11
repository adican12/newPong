package com.ponggame.pong.storage;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {entitty.class}, version = 1)
public abstract class db extends RoomDatabase {

}
