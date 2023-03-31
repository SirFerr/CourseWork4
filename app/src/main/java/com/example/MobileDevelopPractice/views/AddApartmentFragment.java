package com.example.MobileDevelopPractice.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.MobileDevolopPractice.R;

public class AddApartmentFragment extends Fragment {
    View view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_add_apartment, container, false);
        view.findViewById(R.id.continueNewApartment).setOnClickListener(v -> Navigation.findNavController(view).navigate(R.id.action_addApartmentFragment_to_mainMenuFragment));
        return view;
    }
}