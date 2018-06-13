package com.ponggame.pong.storage;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import java.util.List;

@Database(entities = {entity.class}, version = 1)
public abstract class db extends RoomDatabase {
    private static db INSTANCE;
    public abstract dao entityDao();

    public static db getInstance(Context context) {
        synchronized (db.class) {
            if (INSTANCE == null) {
                // notice getApplicationContext
                // -- it prevents the memory leak that would happen if the activity was passed
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                        db.class, "clog.db").build();
            }
            return INSTANCE;
        }
    }


}
