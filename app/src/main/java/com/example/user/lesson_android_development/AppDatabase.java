package com.example.user.lesson_android_development;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {
         Name.class
 },version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase{

     private static AppDatabase INSTANCE;

     public abstract NameDao getNameDao();

     public static final Object sLock = new Object();

     public static AppDatabase getInstance(Context context){
         synchronized (sLock){
             if(INSTANCE == null){
                 INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "name.db").build();
             }
             return INSTANCE;
         }
     }

}
