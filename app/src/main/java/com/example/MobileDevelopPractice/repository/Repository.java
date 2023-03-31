package com.example.MobileDevelopPractice.repository;

import com.example.MobileDevelopPractice.model.Apartment;
import com.example.MobileDevelopPractice.model.User;

public class Repository {
    private Apartment apartment;
    private User user;

    public Repository(User user) {
        this.user = user;
    }

    public Repository(Apartment apartment) {
        this.apartment = apartment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Apartment getApartment() {
        return apartment;
    }

    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }
}
