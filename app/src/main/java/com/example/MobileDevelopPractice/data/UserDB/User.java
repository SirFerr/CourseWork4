package com.example.MobileDevelopPractice.data.UserDB;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {
    @PrimaryKey(autoGenerate = true)
    public int UserID;
    @ColumnInfo
    public int role; //0 user 1 admin 2 banned
    @ColumnInfo
    public String email;
    @ColumnInfo
    public String password;
    @ColumnInfo
    public String phoneNum;

    public User(int role, String email, String password, String phoneNum) {
        this.role = role;
        this.email = email;
        this.password = password;
        this.phoneNum = phoneNum;
    }
}
