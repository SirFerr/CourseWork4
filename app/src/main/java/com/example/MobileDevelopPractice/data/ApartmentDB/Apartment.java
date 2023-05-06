package com.example.MobileDevelopPractice.data.ApartmentDB;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Apartment {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "apartmentId")
    public int apartmentId;
    @ColumnInfo(name = "apartmentName")
    public String apartmentName;

    @ColumnInfo(name = "apartmentAddress")
    public String apartmentAddress;

    @ColumnInfo(name = "apartmentNumber")
    public String apartmentNumber;
    @ColumnInfo(name = "payerCode")
    public String payerCode;
    @ColumnInfo(name = "energyCode")
    public String energyCode;
    @ColumnInfo(name = "energyDeviceCode")
    public String energyDeviceCode;

    @ColumnInfo(name = "UserID")
    public int UserID;

    public Apartment(int UserID, String apartmentName, String apartmentAddress, String apartmentNumber, String payerCode, String energyCode, String energyDeviceCode) {
        this.UserID = UserID;
        this.apartmentName = apartmentName;
        this.apartmentAddress = apartmentAddress;
        this.apartmentNumber = apartmentNumber;
        this.payerCode = payerCode;
        this.energyCode = energyCode;
        this.energyDeviceCode = energyDeviceCode;
    }

    public String getApartmentName() {
        return apartmentName;
    }

    public void setApartmentName(String apartmentName) {
        this.apartmentName = apartmentName;
    }

    public String getApartmentAddress() {
        return apartmentAddress;
    }

    public void setApartmentAddress(String apartmentAddress) {
        this.apartmentAddress = apartmentAddress;
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public String getPayerCode() {
        return payerCode;
    }

    public void setPayerCode(String payerCode) {
        this.payerCode = payerCode;
    }

    public String getEnergyCode() {
        return energyCode;
    }

    public void setEnergyCode(String energyCode) {
        this.energyCode = energyCode;
    }

    public String getEnergyDeviceCode() {
        return energyDeviceCode;
    }

    public void setEnergyDeviceCode(String energyDeviceCode) {
        this.energyDeviceCode = energyDeviceCode;
    }
}
