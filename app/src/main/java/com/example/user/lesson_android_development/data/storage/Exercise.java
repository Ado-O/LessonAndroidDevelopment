package com.example.user.lesson_android_development.data.storage;

public class Exercise {
    private String mTitle;

    private String mMusclesInvolved;

    private String mImage;

    public Exercise(String title, String musclesInvolved, String image) {
        mTitle = title;
        mMusclesInvolved = musclesInvolved;
        mImage = image;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getMusclesInvolved() {
        return mMusclesInvolved;
    }

    public void setMusclesInvolved(String musclesInvolved) {
        mMusclesInvolved = musclesInvolved;
    }

    public String getImage() {
        return mImage;
    }

    public void setImage(String image) {
        mImage = image;
    }
}
