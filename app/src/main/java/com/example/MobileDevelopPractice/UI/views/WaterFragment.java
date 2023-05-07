package com.example.MobileDevelopPractice.UI.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.MobileDevolopPractice.R;


public class WaterFragment extends Fragment {

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_water, container, false);

        view.findViewById(R.id.payBtnWater).setOnClickListener(v ->
                Navigation.findNavController(view).navigate(R.id.action_waterFragment_to_payFragment)
        );
        return view;
    }
}