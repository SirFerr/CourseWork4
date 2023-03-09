package com.example.pract__2;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class LoginFragment extends Fragment {

    View view;

    String debugTAG = "fragmentLifeCycle";

    public LoginFragment() {
        super(R.layout.fragment_login);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Toast.makeText(getActivity(),"onCreate", Toast.LENGTH_SHORT).show();
        Log.d(debugTAG, "onCreate");
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
        Toast.makeText(getActivity(),"onStart", Toast.LENGTH_SHORT).show();
        Log.d(debugTAG, "onStart");
        super.onStart();
    }

    @Override
    public void onResume() {
        Toast.makeText(getActivity(),"onResume", Toast.LENGTH_SHORT).show();
        Log.d(debugTAG, "onResume");
        super.onResume();
    }

    @Override
    public void onPause() {
        Toast.makeText(getActivity(),"onPause", Toast.LENGTH_SHORT).show();
        Log.d(debugTAG, "onPause");
        super.onPause();
    }

    @Override
    public void onStop() {
        Toast.makeText(getActivity(),"onStop", Toast.LENGTH_SHORT).show();
        Log.d(debugTAG, "onStop");
        super.onStop();
    }

    @Override
    public void onDestroy() {
        Toast.makeText(getActivity(),"onDestroy", Toast.LENGTH_SHORT).show();
        Log.d(debugTAG, "onDestroy");
        super.onDestroy();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_login, container, false);
        EditText editText = (EditText) view.findViewById(R.id.editTextTextEmailAddress);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
        editText.setText(getResources().getString(R.string.testEmail));
        imageView.setImageResource(R.drawable.transparency_demonstration_1);


        return view;
    }

}