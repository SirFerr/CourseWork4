package com.example.MobileDevelopPractice.data.ApartmentDB;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Apartment {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    public int apartmentId;
    @ColumnInfo(name = "name")
    public String apartmentName;

    @ColumnInfo(name = "userID")
    public int userID;

    public Apartment(String apartmentName, int userID) {
        this.apartmentName = apartmentName;
        this.userID = userID;
    }
}
