package com.example.MobileDevelopPractice.data.UserDB;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.google.common.util.concurrent.ListenableFuture;

import java.util.List;

public class UserRepository {

    private final UserDao mUserDao;
    private final LiveData<List<User>> Users;

    public UserRepository(Application application) {
        UserDatabase db = UserDatabase.getDatabase(application);
        mUserDao = db.userDao();
        Users = mUserDao.getAll();
    }

    public ListenableFuture<User> searchByEmail(String email) {
        return mUserDao.searchByEmail(email);
//        AtomicReference<User> temp = null;
//        UserDatabase.databaseWriteExecutor.execute(() -> {
//            if (mUserDao.searchByEmail(email) != null) temp.set(mUserDao.searchByEmail(email));
//        });
//        if (temp != null)
//            return temp.get();
//        else return null;
    }

    public void deleteByID(int id) {
        UserDatabase.databaseWriteExecutor.execute(() -> {
            mUserDao.deleteByID(id);
        });
    }

    public LiveData<List<User>> getAllUser() {
        return Users;
    }

    public void insert(User user) {
        UserDatabase.databaseWriteExecutor.execute(() -> {
            mUserDao.insert(user);
        });
    }

    public void updateRole(int id, int role) {
        UserDatabase.databaseWriteExecutor.execute(() -> {
            mUserDao.updateRole(id, role);
        });
    }
}
