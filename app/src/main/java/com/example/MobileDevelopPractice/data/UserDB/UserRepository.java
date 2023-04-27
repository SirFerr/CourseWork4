package com.example.MobileDevelopPractice.data.UserDB;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class UserRepository {

    private final UserDao mUserDao;
    private final LiveData<List<User>> Users;

    public UserRepository(Application application) {
        UserDatabase db = UserDatabase.getDatabase(application);
        mUserDao = db.userDao();
        Users = mUserDao.getAll();
    }

    public LiveData<List<User>> getAllUser() {
        return Users;
    }

    public String findByEmail(String email) {
        return mUserDao.findByEmail(email);
    }

    public void insert(User user) {
        UserDatabase.databaseWriteExecutor.execute(() -> {
            mUserDao.insert(user);
        });
    }
}
