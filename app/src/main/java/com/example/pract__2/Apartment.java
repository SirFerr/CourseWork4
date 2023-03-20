package com.example.pract__2;

public class Apartment {
    private String apartmentID;
    private int imageID;
    private String apartmentName;

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
