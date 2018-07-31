package com.example.user.lesson_android_development.data.storage;

public class Exercise {
    private String mTitle;
    private String mImage;

    public Exercise(String title, String image) {
        mTitle = title;
        mImage = image;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getImage() {
        return mImage;
    }

    public void setImage(String image) {
        mImage = image;
    }
}
