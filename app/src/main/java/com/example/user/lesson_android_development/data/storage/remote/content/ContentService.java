package com.example.user.lesson_android_development.data.storage.remote.content;

import com.example.user.lesson_android_development.data.storage.remote.response.BaseResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ContentService {

    /**
     * Call last class and tell what piece you want
     */
    @GET("mobile")
    Call<BaseResponse> getContent(
            @Query("app") String app,
            @Query("type") String type,
            @Query("version") String version,
            @Query("lang") String lang
    );

}
