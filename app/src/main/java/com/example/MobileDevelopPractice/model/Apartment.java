package com.example.MobileDevelopPractice.model;

public class Apartment {
    private final String apartmentID;
    private final String apartmentName;

    public Apartment(String apartmentID, String apartmentName) {
        this.apartmentID = apartmentID;
        this.apartmentName = apartmentName;
    }

    public String getApartmentID() {
        return apartmentID;
    }

    public String getApartmentName() {
        return apartmentName;
    }

}
