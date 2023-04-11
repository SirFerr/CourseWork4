package com.example.MobileDevelopPractice.data.ApartmentDB;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Apartment {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")
    public int apartmentId;
    @ColumnInfo(name = "name")
    public String apartmentName;

    public Apartment(String apartmentName) {
        this.apartmentName = apartmentName;
    }
}
