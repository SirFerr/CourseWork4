package com.example.pract__2.data;

public class Apartment {
    private final String apartmentID;
    private final int imageID;
    private final String apartmentName;

    public Apartment(String apartmentID, int imageID, String apartmentName) {
        this.apartmentID = apartmentID;
        this.imageID = imageID;
        this.apartmentName = apartmentName;
    }

    public String getApartmentID() {
        return apartmentID;
    }

    public int getImageID() {
        return imageID;
    }

    public String getApartmentName() {
        return apartmentName;
    }

}
