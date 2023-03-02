package com.example.pract__2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class LoginFragment extends Fragment {

    public LoginFragment() {
        super(R.layout.fragment_login);
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("MainActivity", "onCreate: ");
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        EditText editText = view.findViewById(R.id.editTextTextEmailAddress);
        ImageView imageView = view.findViewById(R.id.imageView);
        editText.setText(getResources().getString(R.string.testEmail));
        imageView.setImageResource(R.drawable.transparency_demonstration_1);


        return inflater.inflate(R.layout.fragment_login, container, false);

    }

}