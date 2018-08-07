package com.example.user.lesson_android_development.data.storage.local.workout;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.user.lesson_android_development.data.Workout;

import java.util.List;

/**
 * in this class we command db what we want
 */
@Dao
public interface WorkoutDao {

    //onCOnfilctStrategy we we identify the duplicate data
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<Workout> workouts);

    //in this line we teak everting from workout table
    @Query("SELECT * FROM workout_table")
    List<Workout> getWorkouts();
}
