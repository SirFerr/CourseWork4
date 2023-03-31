package com.example.MobileDevelopPractice.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.MobileDevelopPractice.model.Apartment;
import com.example.MobileDevelopPractice.model.User;
import com.example.MobileDevelopPractice.repository.Repository;

public class ViewModel extends androidx.lifecycle.ViewModel {

    private final MutableLiveData<Repository> apartmentUI =
            new MutableLiveData(new Repository(new Apartment(null, null)));
    private final MutableLiveData<Repository> userID =
            new MutableLiveData(new Repository(new User(null, null)));

    public LiveData<Repository> getApartmentUI() {
        return apartmentUI;
    }

    public void addApartment(String id, String name) {
        apartmentUI.setValue(
                new Repository(new Apartment(id, name))
        );
    }

    public LiveData<Repository> getUserID() {
        return userID;
    }

    public void addUser(String email, String password) {
        userID.setValue(
                new Repository(new User(email, password))
        );
    }
}
