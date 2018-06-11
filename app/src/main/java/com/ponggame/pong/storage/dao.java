package com.ponggame.pong.storage;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface dao {

    @Query("select id from entitty")
    LiveData<List<entitty>> loadCaptainsLog();

    @Insert
    void insertToLog(entitty logRow);


}
