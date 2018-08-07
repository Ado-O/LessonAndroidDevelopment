package com.example.user.lesson_android_development.data.storage.local.workout;

import com.example.user.lesson_android_development.data.Workout;
import com.example.user.lesson_android_development.data.storage.convertor.RemoteToLocal;
import com.example.user.lesson_android_development.data.storage.remote.response.WorkoutResponse;
import com.example.user.lesson_android_development.util.AppExecutors;

import java.util.List;

/**
 * The main class for inserting and getting the data from the local database
 */
public class WorkoutLocalDataSource {
    private static WorkoutLocalDataSource sInstance = null;

    private final WorkoutDao mWorkoutDao;
    private final AppExecutors mAppExecutors;

    private WorkoutLocalDataSource(WorkoutDao workoutDao, AppExecutors appExecutors) {
        mWorkoutDao = workoutDao;
        mAppExecutors = appExecutors;
    }

    public static WorkoutLocalDataSource getInstance(WorkoutDao workoutDao, AppExecutors appExecutors) {
        if (sInstance == null) {
            sInstance = new WorkoutLocalDataSource(workoutDao, appExecutors);
        }
        return sInstance;
    }

    /**
     * Inserting the data from remote to the local database
     * @param workoutResponses
     */
    public void insertWorkouts(List<WorkoutResponse> workoutResponses) {
        mWorkoutDao.insert(
                RemoteToLocal.workoutConvertor(workoutResponses)
        );
    }

    /**
     * Getting everything from the workout_table
     * @param callback
     */
    public void getWorkouts(final GetWorkoutsCallback callback) {
        mAppExecutors.diskIO().execute(
                new Runnable() {
                    @Override
                    public void run() {
                        final List<Workout> workouts = mWorkoutDao.getWorkouts();

                        mAppExecutors.mainThread().execute(
                                new Runnable() {
                                    @Override
                                    public void run() {
                                        callback.onSuccess(workouts);
                                    }
                                });
                    }
                });
    }

    public interface GetWorkoutsCallback {
        void onSuccess(List<Workout> workouts);

        void onError();
    }

}
