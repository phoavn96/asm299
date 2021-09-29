package com.example.asmhoa.expend;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Category.class,Expend.class}, version = 1)
public  abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase appDatabase;
    public abstract ExpendDao expendDao();

    public static AppDatabase getAppDatabase(Context context) {
        if (appDatabase == null) {
            appDatabase = Room.databaseBuilder(context,
                    AppDatabase.class, "Expend.db").allowMainThreadQueries().build();
        }
        return appDatabase;
    }
}
