package com.example.user.lesson_android_development.data.storage;

import android.util.Log;

import com.example.user.lesson_android_development.data.storage.local.exercise.ExerciseLocalDataSource;
import com.example.user.lesson_android_development.data.storage.local.workout.WorkoutLocalDataSource;
import com.example.user.lesson_android_development.data.storage.remote.content.ContentRemoteDataSource;
import com.example.user.lesson_android_development.data.storage.remote.response.BaseResponse;
import com.example.user.lesson_android_development.util.AppExecutors;

/**
 * The main function of the ContentRepository is to getContent from the
 * RemoteDataSource(from the server) and inserting it in the Local Database
 */
public class ContentRepository {

    private static final String TAG = ContentRepository.class.getSimpleName();

    //ContentRepository Instance
    private static ContentRepository sInstance = null;

    private final AppExecutors mAppExecutors;

    //this class give path to url
    private final ContentRemoteDataSource mContentRemoteDataSource;

    //this class give us insert and get from db which we have give from networking
    private final ExerciseLocalDataSource mExerciseLocalDataSource;
    private final WorkoutLocalDataSource mWorkoutLocalDataSource;

    private ContentRepository(AppExecutors appExecutors,
                              ContentRemoteDataSource contentRemoteDataSource,
                              ExerciseLocalDataSource exerciseLocalDataSource,
                              WorkoutLocalDataSource workoutLocalDataSource) {
        mAppExecutors = appExecutors;
        mContentRemoteDataSource = contentRemoteDataSource;
        mExerciseLocalDataSource = exerciseLocalDataSource;
        mWorkoutLocalDataSource = workoutLocalDataSource;
    }

    public static ContentRepository getInstance(
            AppExecutors appExecutors,
            ContentRemoteDataSource contentRemoteDataSource,
            ExerciseLocalDataSource exerciseLocalDataSource,
            WorkoutLocalDataSource workoutLocalDataSource) {
        if (sInstance == null) {
            sInstance = new ContentRepository(appExecutors, contentRemoteDataSource, exerciseLocalDataSource, workoutLocalDataSource);
        }
        return sInstance;
    }

    /**
     * Get data from network
     * And put it in the local database
     */
    public void getContent() {

        //Get all data from server
        mContentRemoteDataSource.getContent(new ContentRemoteDataSource.GetContentCallback() {
            @Override
            public void onSuccess(final BaseResponse content) {
                //Insert all data to local storage
                mAppExecutors.diskIO().execute(new Runnable() {
                    @Override
                    public void run() {
                        mExerciseLocalDataSource.insertExercise(content.getResponseResponse().getExercise());
                        mWorkoutLocalDataSource.insertWorkouts(content.getResponseResponse().getWorkouts());

                        Log.e(TAG, "OnSuccess");
                    }
                });
            }

            @Override
            public void onError() {
                Log.e(TAG, "OnError");
            }
        });
    }

}


