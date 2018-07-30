package com.example.user.lesson_android_development.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.user.lesson_android_development.data.Name;

import java.util.List;

@Dao
public interface NameDao {

    @Insert
    void insertName(Name name);

    @Query("SELECT * FROM name_table")
    List<Name> getName();

    @Query("DELETE FROM name_table")
    void delete();

}
