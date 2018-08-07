package com.example.user.lesson_android_development.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.user.lesson_android_development.Injection;
import com.example.user.lesson_android_development.R;
import com.example.user.lesson_android_development.data.Exercise;
import com.example.user.lesson_android_development.data.Workout;
import com.example.user.lesson_android_development.data.storage.ContentRepository;
import com.example.user.lesson_android_development.data.storage.ExerciseRepository;
import com.example.user.lesson_android_development.data.storage.WorkoutRepository;

import java.util.List;

/**
 * 1.) Get the content from server & insert it to the local db
 * 2.) Get the exercise count from the local database
 */
public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private ContentRepository mContentRepository;

    private ExerciseRepository mExerciseRepository;

    private WorkoutRepository mWorkoutRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_atv);

        /**
         * i this line of code we get all content from local db wich we have becom from networking
         */
        mContentRepository = Injection.provideContentRepository(this);
        mContentRepository.getContent();

        /**
         * i this line of code we get data from exercise whic we have create object for this call
         */
        mExerciseRepository = Injection.provideExerciseRepository(this);
        mExerciseRepository.getExercises(
                new ExerciseRepository.GetExerciseCallback() {
                    @Override
                    public void onSuccess(List<Exercise> exercises) {
                        Log.e(TAG, String.valueOf(exercises.size()));
                    }

                    @Override
                    public void onError() {

                    }
                });

        /**
         * i this line of code we get data from workout which we have create object for this call
         */
        mWorkoutRepository = Injection.provideWorkoutRepository(this);
        mWorkoutRepository.getWorkout(
                new WorkoutRepository.GetWorkoutsCallback() {
                    @Override
                    public void onSuccess(List<Workout> workouts) {
                        Log.e(TAG, String.valueOf(workouts.get(0).getName()));
                    }

                    @Override
                    public void onError() {

                    }
                }
        );

    }
}


