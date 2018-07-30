package com.example.user.lesson_android_development.data;

import android.content.Context;

import com.example.user.lesson_android_development.util.AppExecutors;

import java.util.List;

public class NameLocalDataSource {

    private Context mContext;

    private NameDao mNameDao;

    //story of Thred
    private AppExecutors mAppExecutors;

    public NameLocalDataSource(Context context) {
        mContext = context;
        mAppExecutors = new AppExecutors();

        mNameDao =AppDatabase.getInstance(context).getNameDao();
    }

    public void getDelete(){
        mAppExecutors.diskIO().execute(new Runnable() {
            @Override
            public void run() {
                mNameDao.delete();
            }
        });
    }

    public void insertName(final Name name) {
        mAppExecutors.diskIO().execute(new Runnable() {
            @Override
            public void run() {
                mNameDao.insertName(name);
            }
        });
    }

    public void getName(final Callback callback) {
        mAppExecutors.diskIO().execute(new Runnable() {
            @Override
            public void run() {

                List<Name> names = mNameDao.getName();

                callback.onSuccess(names);

            }
        });
    }

    public interface Callback {
        void onSuccess(List<Name> name);

        void onError();
    }

}
