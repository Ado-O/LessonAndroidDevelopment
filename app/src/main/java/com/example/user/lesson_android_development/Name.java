package com.example.user.lesson_android_development;

public class Name {

    private String mName;
    private String mLasteName;

    public Name(String name, String lasteName) {
        mName = name;
        mLasteName = lasteName;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getLasteName() {
        return mLasteName;
    }

    public void setLasteName(String lasteName) {
        mLasteName = lasteName;
    }
}
