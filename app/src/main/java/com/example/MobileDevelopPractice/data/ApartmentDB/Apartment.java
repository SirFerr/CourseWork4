package com.example.MobileDevelopPractice.data.ApartmentDB;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Apartment {
    @PrimaryKey
    public int apartmentId;
    @ColumnInfo(name = "name")
    public String apartmentName;

    public Apartment(int apartmentId, String apartmentName) {
        this.apartmentId = apartmentId;
        this.apartmentName = apartmentName;
    }

    public int getApartmentId() {
        return apartmentId;
    }

    public String getApartmentName() {
        return apartmentName;
    }
}
