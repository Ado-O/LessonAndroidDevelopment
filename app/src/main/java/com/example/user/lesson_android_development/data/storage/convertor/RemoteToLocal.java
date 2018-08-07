package com.example.user.lesson_android_development.data.storage.convertor;

import com.example.user.lesson_android_development.data.Exercise;
import com.example.user.lesson_android_development.data.Workout;
import com.example.user.lesson_android_development.data.storage.remote.response.ExerciseResponse;
import com.example.user.lesson_android_development.data.storage.remote.response.WorkoutResponse;

import java.util.ArrayList;
import java.util.List;

public class RemoteToLocal {
    public static List<Exercise> exerciseConverter(List<ExerciseResponse> exerciseResponses) {

        List<Exercise> exercises = new ArrayList<>();

        for (ExerciseResponse e : exerciseResponses) {
            exercises.add(
                    new Exercise(
                            e.getId(),
                            e.getRawName(),
                            e.getName(),
                            e.getThumbnail()
                    )
            );
        }
        return exercises;
    }

    public static List<Workout> workoutConvertor(List<WorkoutResponse> workoutResponses) {
        List<Workout> workouts = new ArrayList<>();

        for (WorkoutResponse w : workoutResponses) {
            workouts.add(
                    new Workout(w.getId(),
                            w.getName(),
                            w.getDescription(),
                            w.getDuration()
                    )
            );
        }

        return workouts;
    }

}
