package com.example.user.lesson_android_development.data.storage;

import com.example.user.lesson_android_development.data.Workout;
import com.example.user.lesson_android_development.data.storage.local.workout.WorkoutLocalDataSource;

import java.util.List;

/**
 * This repository handles everything specific for workout
 */
public class WorkoutRepository {

    private static WorkoutRepository sInstance = null;

    private final WorkoutLocalDataSource mWoekoutLocalDataSource;

    //construct
    private WorkoutRepository(WorkoutLocalDataSource workoutLocalDataSource) {
        mWoekoutLocalDataSource = workoutLocalDataSource;
    }

    public static WorkoutRepository getInstance(WorkoutLocalDataSource workoutLocalDataSource) {
        if (sInstance == null) {
            sInstance = new WorkoutRepository(workoutLocalDataSource);
        }
        return sInstance;
    }

    /**
     * We getting data from the WorkoutLocalDataSource (the local database)
     *
     * @param callback for passing the state(onSuccess, onError)
     */
    public void getWorkout(final GetWorkoutsCallback callback) {
        mWoekoutLocalDataSource.getWorkouts(new WorkoutLocalDataSource.GetWorkoutsCallback() {
            @Override
            public void onSuccess(List<Workout> workouts) {
                callback.onSuccess(workouts);
            }

            @Override
            public void onError() {
                callback.onError();
            }
        });
    }

    public interface GetWorkoutsCallback {
        void onSuccess(List<Workout> workouts);

        void onError();
    }


}

