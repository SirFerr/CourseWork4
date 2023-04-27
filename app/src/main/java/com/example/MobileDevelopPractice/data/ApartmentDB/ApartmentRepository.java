package com.example.MobileDevelopPractice.data.ApartmentDB;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class ApartmentRepository {

    private final ApartmentDao mApartmentDao;
    private final LiveData<List<Apartment>> Apartments;

    public ApartmentRepository(Application application) {
        ApartmentDatabase db = ApartmentDatabase.getDatabase(application);
        mApartmentDao = db.apartmentDao();
        Apartments = mApartmentDao.getAll();
    }

    public LiveData<List<Apartment>> getAllApartment() {
        return Apartments;
    }

    public LiveData<List<Apartment>> getByUserID(int id) {
        return mApartmentDao.getByUserID(id);
    }

    public void insert(Apartment apartment) {
        ApartmentDatabase.databaseWriteExecutor.execute(() -> {
            mApartmentDao.insert(apartment);
        });
    }


}
