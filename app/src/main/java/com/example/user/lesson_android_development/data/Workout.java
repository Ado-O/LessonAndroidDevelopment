package com.example.user.lesson_android_development.data;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "workout_table")
public class Workout {

    @ColumnInfo(name = "_id")
    @PrimaryKey(autoGenerate = true)
    private long mId;

    @ColumnInfo(name = "name")
    private String mName;

    @ColumnInfo(name = "description")
    private String mDescription;

    @ColumnInfo(name = "duration")
    private long mDuration;


    public Workout(long id, String name, String description, long duration) {
        mId = id;
        mName = name;
        mDescription = description;
        mDuration = duration;
    }

    public long getId() {
        return mId;
    }

    public void setId(long id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public long getDuration() {
        return mDuration;
    }

    public void setDuration(long duration) {
        mDuration = duration;
    }
}
