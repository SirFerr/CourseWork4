package com.example.MobileDevelopPractice.UI.viewmodels;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.MobileDevelopPractice.data.ApartmentDB.Apartment;
import com.example.MobileDevelopPractice.data.ApartmentDB.ApartmentRepository;

import java.util.List;

public class ApartmentVM extends AndroidViewModel {

    private final LiveData<List<Apartment>> mAllApartment;
    private final ApartmentRepository mRepository;

    public ApartmentVM(Application application) {
        super(application);
        mRepository = new ApartmentRepository(application);
        mAllApartment = mRepository.getAllApartment();
    }

    public LiveData<List<Apartment>> getByUserID(int id) {
        return mRepository.getByUserID(id);
    }

    public LiveData<List<Apartment>> getAllApartment() {
        return mAllApartment;
    }

    public void insert(Apartment apartment) {
        mRepository.insert(apartment);
    }

}
