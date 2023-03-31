package com.example.MobileDevelopPractice.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.MobileDevelopPractice.model.Apartment;

public class ApartmentViewModel extends ViewModel {

    private final MutableLiveData<Apartment> apartmentUI =
            new MutableLiveData(new Apartment(null, null));

    public LiveData<Apartment> getApartmentUI() {
        return apartmentUI;
    }

    public void addApartment(String id, String name) {
        apartmentUI.setValue(
                new Apartment(id, name)
        );
    }
}
