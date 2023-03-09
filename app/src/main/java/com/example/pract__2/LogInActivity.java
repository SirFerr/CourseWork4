package com.example.pract__2;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class LogInActivity extends AppCompatActivity {
    Fragment mainMenuFragment = new MainMenuFragment();
    Fragment linearFragment = new LinearFragment();
    Fragment relativeFragment = new RelativeFragment();
    Fragment loginFragment = new LoginFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportFragmentManager().beginTransaction()
                .setReorderingAllowed(true)
                .add(R.id.fragment_container_view, loginFragment)
                .commit();

    }

    public void Change(View view) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        switch (view.getId()) {
            case R.id.continueBtn: {
                Bundle bundle = new Bundle();
                bundle.putString("email", String.valueOf(((EditText) loginFragment
                        .getView()
                        .findViewById(R.id.editTextTextEmailAddress))
                        .getText()));
                mainMenuFragment.setArguments(bundle);
                ft
                        .add(R.id.fragment_container_view, mainMenuFragment)
                        .hide(loginFragment);
                break;
            }
            case R.id.regBtn: {
                ft
                        .add(R.id.fragment_container_view, linearFragment)
                        .hide(loginFragment);
            }
            case R.id.addApartmentBtn: {
                ft
                        .add(R.id.fragment_container_view, relativeFragment)
                        .hide(mainMenuFragment);
                break;
            }
        }
        ft.addToBackStack(null).commit();
    }
}