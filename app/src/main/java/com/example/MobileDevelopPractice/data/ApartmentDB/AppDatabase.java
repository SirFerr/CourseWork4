package com.example.MobileDevelopPractice.data.ApartmentDB;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Apartment.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ApartmentDao apartmentDao();
}
