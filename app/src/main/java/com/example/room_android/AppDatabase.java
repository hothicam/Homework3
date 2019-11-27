package com.example.room_android;

import androidx.room.Database;
import androidx.room.RoomDatabase;


@Database(entities = {User.class}, version = 4)
public abstract class AppDatabase extends RoomDatabase {

    abstract UserDao userDao();
}
