package com.example.MobileDevelopPractice.data.UserDB;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    public int UserID;
    @ColumnInfo(name = "password")
    public String password;
    @ColumnInfo(name = "email")
    public String email;
    @ColumnInfo(name = "phoneNum")
    public String phoneNum;

    public User(String password, String email, String phoneNum) {
        this.password = password;
        this.email = email;
        this.phoneNum = phoneNum;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
}
