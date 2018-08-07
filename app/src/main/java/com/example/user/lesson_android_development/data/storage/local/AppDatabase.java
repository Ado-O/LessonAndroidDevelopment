package com.example.user.lesson_android_development.data.storage.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.user.lesson_android_development.data.Exercise;
import com.example.user.lesson_android_development.data.Workout;
import com.example.user.lesson_android_development.data.storage.local.exercise.ExerciseDao;
import com.example.user.lesson_android_development.data.storage.local.workout.WorkoutDao;

/**
 * this is main clas when we create table and taek class ExerciseDao, WorkoutDao
 */
@Database(entities = {
        Exercise.class, Workout.class
}, version = 3, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE;

    /**
     * add two class wich get request from db
     * @return
     */
    public abstract ExerciseDao getExerciseDao();
    public abstract WorkoutDao getWorkoutDao();

    public static final Object sLock = new Object();

    public static AppDatabase getInstance(Context context){
        synchronized (sLock){
            if(INSTANCE == null){
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "app.db").build();
            }
            return INSTANCE;
        }
    }

}
