package com.example.user.lesson_android_development.data.storage.remote.content;

import com.example.user.lesson_android_development.data.storage.converter.RemoteToLocal;
import com.example.user.lesson_android_development.data.storage.Exercise;
import com.example.user.lesson_android_development.data.storage.remote.ServiceGenerator;
import com.example.user.lesson_android_development.data.storage.remote.response.BaseResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ContentRemoteDataSource {

    public void getContent(final GetContentCallback callback) {
        ContentService contentService = ServiceGenerator.createService(ContentService.class);

        contentService
                .getContent("spartan.system", "pro", "0", "en")
                .enqueue(new Callback<BaseResponse>() {
                    @Override
                    public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {
                        if (response.isSuccessful()) {
                            callback.onSuccess(
                                    RemoteToLocal.exerciseConverter(
                                            response.body().getResponseResponse().getExercise()
                                    )
                            );
                        } else {
                            callback.onError();
                        }
                    }

                    @Override
                    public void onFailure(Call<BaseResponse> call, Throwable t) {
                        callback.onError();
                    }
                });
    }


    public interface GetContentCallback {
        void onSuccess(List<Exercise> exercises);

        void onError();
    }


}
