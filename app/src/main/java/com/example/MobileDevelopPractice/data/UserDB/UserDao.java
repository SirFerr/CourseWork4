package com.example.MobileDevelopPractice.data.UserDB;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.google.common.util.concurrent.ListenableFuture;

import java.util.List;

@Dao
public interface UserDao {

    @Query("SELECT * FROM User")
    LiveData<List<User>> getAll();

    @Query("DELETE FROM User")
    void deleteAll();

    @Query("DELETE FROM USER WHERE UserID = :id")
    void deleteByID(int id);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(User user);

    @Query("SELECT * FROM user WHERE email = :email")
    ListenableFuture<User> searchByEmail(String email);

    @Query("UPDATE user SET role=:Role WHERE UserID=:id")
    void updateRole(int id, int Role);
}
