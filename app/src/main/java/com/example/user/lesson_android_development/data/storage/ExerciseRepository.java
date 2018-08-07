package com.example.user.lesson_android_development.data.storage;

import com.example.user.lesson_android_development.data.Exercise;
import com.example.user.lesson_android_development.data.storage.local.exercise.ExerciseLocalDataSource;

import java.util.List;

/**
 * This repository handles everything specific for exercises
 */
public class ExerciseRepository {

    private static ExerciseRepository sInstance = null;

    private final ExerciseLocalDataSource mExerciseLocalDataSource;

    private ExerciseRepository(ExerciseLocalDataSource exerciseLocalDataSource) {
        mExerciseLocalDataSource = exerciseLocalDataSource;
    }

    public static ExerciseRepository getInstance(ExerciseLocalDataSource exerciseLocalDataSource) {
        if (sInstance == null) {
            sInstance = new ExerciseRepository(exerciseLocalDataSource);
        }
        return sInstance;
    }

    /**
     * We getting data from the exerciseLocalDataSource (the local database)
     *
     * @param callback for passing the state(onSuccess, onError)
     */
    public void getExercises(final GetExerciseCallback callback) {
        mExerciseLocalDataSource.getExercises(new ExerciseLocalDataSource.GetExerciseCallback() {
            @Override
            public void onSuccess(List<Exercise> exercises) {
                callback.onSuccess(exercises);
            }

            @Override
            public void onError() {
                callback.onError();
            }
        });
    }

    public interface GetExerciseCallback {
        void onSuccess(List<Exercise> exercises);

        void onError();
    }

}
