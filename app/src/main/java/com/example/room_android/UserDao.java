package com.example.room_android;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * from user ")
    abstract List<User> getAll();

    @Insert
    void insert( User user);
}
