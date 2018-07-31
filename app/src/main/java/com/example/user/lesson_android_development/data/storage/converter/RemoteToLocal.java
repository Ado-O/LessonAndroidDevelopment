package com.example.user.lesson_android_development.data.storage.converter;

import com.example.user.lesson_android_development.data.storage.Exercise;
import com.example.user.lesson_android_development.data.storage.remote.response.ExerciseResponse;

import java.util.ArrayList;
import java.util.List;

public class RemoteToLocal {

    public static List<Exercise> exerciseConverter(List<ExerciseResponse> exerciseResponses){

        List<Exercise> exercises = new ArrayList<>();

        for(ExerciseResponse e : exerciseResponses){
            exercises.add(
                    new Exercise(e.getName(), e.getThumbnail())
            );
        }
        return exercises;
    }

}
