package com.example.MobileDevelopPractice.data.ApartmentDB;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ApartmentDao {
    @Query("SELECT * FROM Apartment")
    List<Apartment> getAll();

    @Query("SELECT * FROM Apartment WHERE apartmentId IN (:userIds)")
    List<Apartment> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM Apartment WHERE name LIKE :apartmentName LIMIT 1")
    Apartment findByName(String apartmentName);

    @Query("SELECT * FROM Apartment WHERE apartmentId LIKE :id LIMIT 1")
    Apartment findById(int id);

    @Insert
    void insertAll(Apartment... apartments);

    @Query("INSERT INTO Apartment(apartmentId,name) VALUES (:id,:name)")
    void insert(int id, String name);

    @Delete
    void delete(Apartment apartment);

    @Query("DELETE FROM Apartment WHERE apartmentId LIKE :id")
    void delete(int id);
}
