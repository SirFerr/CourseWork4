package com.example.MobileDevelopPractice.UI.viewmodels;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.MobileDevelopPractice.data.UserDB.User;
import com.example.MobileDevelopPractice.data.UserDB.UserRepository;

import java.util.List;

public class UserVM extends AndroidViewModel {

    private final LiveData<List<User>> mAllUser;
    private final UserRepository mRepository;

    public UserVM(Application application) {
        super(application);
        mRepository = new UserRepository(application);
        mAllUser = mRepository.getAllUser();
    }

    public String findByEmail(String email) {
        return mRepository.findByEmail(email);
    }

    public LiveData<List<User>> getAllUser() {
        return mAllUser;
    }

    public void insert(User user) {
        mRepository.insert(user);
    }

}
