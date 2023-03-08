package com.example.pract__2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MainMenuFragment extends Fragment {
    View view;

    @Nullable
    @Override
    public View getView() {
        return view;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main_menu, container, false);
        Bundle bundle = getArguments();
        if (bundle != null) {
            TextView textView = (TextView) view.findViewById(R.id.emailName);
            textView.setText(bundle.getString("email"));
        }
        return view;
    }
}