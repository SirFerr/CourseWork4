package com.example.MobileDevelopPractice.data.repository.dataSourceRepository;

public class Apartment {
    private String apartmentID;
    private String apartmentName;

    public Apartment(String apartmentID, String apartmentName) {
        this.apartmentID = apartmentID;
        this.apartmentName = apartmentName;
    }

    public String getApartmentID() {
        return apartmentID;
    }

    public void setApartmentID(String apartmentID) {
        this.apartmentID = apartmentID;
    }

    public String getApartmentName() {
        return apartmentName;
    }

    public void setApartmentName(String apartmentName) {
        this.apartmentName = apartmentName;
    }

}
