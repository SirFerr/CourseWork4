package com.example.MobileDevelopPractice.data.UserDB;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {

    @Query("SELECT * FROM User")
    LiveData<List<User>> getAll();

    @Query("DELETE FROM User")
    void deleteAll();

    @Query("SELECT password FROM User WHERE email = :email")
    String findByEmail(String email);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(User user);
}
