package com.example.user.lesson_android_development;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface NameDao {

    @Insert
    void insertName(Name name);

    @Query("SELECT * FROM name_table")
    List<Name> getName();
}
