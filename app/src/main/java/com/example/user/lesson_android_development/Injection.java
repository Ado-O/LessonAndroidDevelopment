package com.example.user.lesson_android_development;

import android.content.Context;

import com.example.user.lesson_android_development.data.storage.ContentRepository;
import com.example.user.lesson_android_development.data.storage.ExerciseRepository;
import com.example.user.lesson_android_development.data.storage.WorkoutRepository;
import com.example.user.lesson_android_development.data.storage.local.AppDatabase;
import com.example.user.lesson_android_development.data.storage.local.exercise.ExerciseLocalDataSource;
import com.example.user.lesson_android_development.data.storage.local.workout.WorkoutLocalDataSource;
import com.example.user.lesson_android_development.data.storage.remote.content.ContentRemoteDataSource;
import com.example.user.lesson_android_development.util.AppExecutors;

public class Injection {
    public static AppDatabase provideAppDatabase(Context context) {
        return AppDatabase.getInstance(context.getApplicationContext());
    }

    public static AppExecutors provideAppExecutors() {
        return new AppExecutors();
    }

    public static ContentRemoteDataSource provideContentRemoteDataSource() {
        return ContentRemoteDataSource.getInstance();
    }

    public static ExerciseLocalDataSource provideExerciseLocalDataSource(Context context) {
        return ExerciseLocalDataSource.getInstance(
                provideAppDatabase(context.getApplicationContext()).getExerciseDao(),
                provideAppExecutors()
        );
    }

    public static WorkoutLocalDataSource provideWorkoutLocalDataSource(Context context) {
        return WorkoutLocalDataSource.getInstance(
                provideAppDatabase(context.getApplicationContext()).getWorkoutDao(),
                provideAppExecutors()
        );
    }

    public static ContentRepository provideContentRepository(Context context) {
        return ContentRepository.getInstance(
                provideAppExecutors(),
                provideContentRemoteDataSource(),
                provideExerciseLocalDataSource(context.getApplicationContext()),
                provideWorkoutLocalDataSource(context.getApplicationContext())
        );
    }

    public static ExerciseRepository provideExerciseRepository(Context context) {
        return ExerciseRepository.getInstance(
                provideExerciseLocalDataSource(context.getApplicationContext())
        );
    }

    public static WorkoutRepository provideWorkoutRepository(Context context){
        return WorkoutRepository.getInstance(
                provideWorkoutLocalDataSource(context.getApplicationContext())
        );
    }
}
