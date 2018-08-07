package com.example.user.lesson_android_development.data.storage.local.exercise;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.user.lesson_android_development.data.Exercise;

import java.util.List;

/**
 * in this class we command db what we want
 */
@Dao
public interface ExerciseDao {

    //onCOnfilctStrategy we we identify the duplicate data
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<Exercise> exercise);

    //in this line we teak everting from exercise table
    @Query("SELECT * FROM exercise_table")
    List<Exercise> getExercise();

}