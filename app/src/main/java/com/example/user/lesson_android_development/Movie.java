package com.example.user.lesson_android_development;

public class Movie {

    public String mName;
    public String mRelease;

    public Movie(String name, String release) {
        mName = name;
        mRelease = release;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getRelease() {
        return mRelease;
    }

    public void setRelease(String release) {
        mRelease = release;
    }
}
