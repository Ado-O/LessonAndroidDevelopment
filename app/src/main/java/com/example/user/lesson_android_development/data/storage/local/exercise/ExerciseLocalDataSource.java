package com.example.user.lesson_android_development.data.storage.local.exercise;

import com.example.user.lesson_android_development.data.Exercise;
import com.example.user.lesson_android_development.data.storage.convertor.RemoteToLocal;
import com.example.user.lesson_android_development.data.storage.remote.response.ExerciseResponse;
import com.example.user.lesson_android_development.util.AppExecutors;

import java.util.List;

/**
 * The main class for inserting and getting the data from the local database
 */
public class ExerciseLocalDataSource {

    private static ExerciseLocalDataSource sInstance = null;

    private final ExerciseDao mExerciseDao;
    private final AppExecutors mAppExecutors;

    private ExerciseLocalDataSource(ExerciseDao exerciseDao, AppExecutors appExecutors) {
        mExerciseDao = exerciseDao;
        mAppExecutors = appExecutors;
    }

    public static ExerciseLocalDataSource getInstance(ExerciseDao exerciseDao, AppExecutors appExecutors) {
        if (sInstance == null) {
            sInstance = new ExerciseLocalDataSource(exerciseDao, appExecutors);
        }
        return sInstance;
    }

    /**
     * Inserting the data from remote to the local database
     * @param exerciseResponses
     */
    public void insertExercise(List<ExerciseResponse> exerciseResponses) {
        mExerciseDao.insert(RemoteToLocal.exerciseConverter(exerciseResponses));
    }

    /**
     * Getting everything from the exercise_table
     * @param callback
     */
    public void getExercises(final GetExerciseCallback callback) {
        mAppExecutors.diskIO().execute(new Runnable() {
            @Override
            public void run() {
                final List<Exercise> exercises = mExerciseDao.getExercise();

                mAppExecutors.mainThread().execute(new Runnable() {
                    @Override
                    public void run() {
                        callback.onSuccess(exercises);
                    }
                });
            }
        });

    }

    public interface GetExerciseCallback {
        void onSuccess(List<Exercise> exercises);

        void onError();
    }

}
