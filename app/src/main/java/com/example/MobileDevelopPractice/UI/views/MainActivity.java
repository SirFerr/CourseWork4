package com.example.MobileDevelopPractice.UI.views;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.MobileDevelopPractice.UI.viewmodels.ApartmentVM;
import com.example.MobileDevolopPractice.R;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ApartmentVM apartmentVM = new ViewModelProvider(this).get(ApartmentVM.class);
        setContentView(R.layout.activity_main);
    }
}