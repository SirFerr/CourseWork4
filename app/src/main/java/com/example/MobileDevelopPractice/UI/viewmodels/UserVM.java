package com.example.MobileDevelopPractice.UI.viewmodels;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.MobileDevelopPractice.data.UserDB.User;
import com.example.MobileDevelopPractice.data.UserDB.UserRepository;
import com.google.common.util.concurrent.ListenableFuture;

import java.util.List;

public class UserVM extends AndroidViewModel {
    private final LiveData<List<User>> mAllUser;
    private final UserRepository mRepository;

    public UserVM(Application application) {
        super(application);
        mRepository = new UserRepository(application);
        mAllUser = mRepository.getAllUser();
    }

    public ListenableFuture<User> searchByEmail(String email) {
        return mRepository.searchByEmail(email);
    }

    public void updateRole(int id, int role) {
        mRepository.updateRole(id, role);
    }

    public void deleteByID(int id) {
        mRepository.deleteByID(id);
    }

    public LiveData<List<User>> getAllUser() {
        return mAllUser;
    }

    public void insert(User user) {
        mRepository.insert(user);
    }
}
