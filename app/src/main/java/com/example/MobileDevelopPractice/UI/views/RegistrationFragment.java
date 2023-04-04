package com.example.MobileDevelopPractice.UI.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.MobileDevolopPractice.R;

public class RegistrationFragment extends Fragment {
    View view;

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_registration, container, false);
        Bundle bundle = getArguments();
        if (bundle != null) {
            TextView textView = view.findViewById(R.id.editTextTextEmailAddress2);
            textView.setText(bundle.getString("email"));
        }
        view.findViewById(R.id.regBtnNew).setOnClickListener(v -> {
            Bundle result = new Bundle();
            result.putString("email", String.valueOf(((EditText) view.findViewById(R.id.editTextTextEmailAddress2)).getText()));
            Navigation.findNavController(view).navigate(R.id.action_registrationFragment_to_loginFragment, bundle);
        });
        return view;
    }

}

