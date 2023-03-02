package com.example.pract__2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class LinearFragment extends Fragment {

    public LinearFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_linear, container, false);
        Button button = view.findViewById(R.id.button4);
        MainMenuFragment mainMenuFragment = new MainMenuFragment();
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("onRegBtnClick","clicked");
            }
        });
        return inflater.inflate(R.layout.fragment_linear, container, false);
    }
}