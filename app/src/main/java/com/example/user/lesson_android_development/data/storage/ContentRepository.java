package com.example.user.lesson_android_development.data.storage;

import com.example.user.lesson_android_development.data.storage.remote.content.ContentRemoteDataSource;

import java.util.List;

public class ContentRepository {

    private static ContentRepository sContentRepository = null;

    private final ContentRemoteDataSource mContentRemoteDataSource;

    public ContentRepository() {
        mContentRemoteDataSource = new ContentRemoteDataSource();
    }

    public static ContentRepository getInstance() {
        if (sContentRepository == null) {
            sContentRepository = new ContentRepository();
        }
        return sContentRepository;
    }

    public void getContent(final GetContentCallback callback) {
        mContentRemoteDataSource.getContent(
                new ContentRemoteDataSource.GetContentCallback() {
                    @Override
                    public void onSuccess(List<Exercise> exercises) {
                        callback.onSuccess(exercises);
                    }

                    @Override
                    public void onError() {
                        callback.onError();
                    }
                }
        );
    }

    public interface GetContentCallback {
        void onSuccess(List<Exercise> exercises);

        void onError();
    }

}
