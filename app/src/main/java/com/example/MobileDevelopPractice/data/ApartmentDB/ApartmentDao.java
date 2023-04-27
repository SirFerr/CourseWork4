package com.example.MobileDevelopPractice.data.ApartmentDB;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ApartmentDao {
    @Query("SELECT * FROM Apartment")
    LiveData<List<Apartment>> getAll();

    @Query("DELETE FROM Apartment")
    void deleteAll();

    @Query("SELECT * FROM Apartment WHERE userID = :userId")
    LiveData<List<Apartment>> getByUserID(int userId);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Apartment apartment);

}
