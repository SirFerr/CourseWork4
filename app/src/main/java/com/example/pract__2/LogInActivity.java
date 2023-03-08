package com.example.pract__2;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import java.util.Stack;

public class LogInActivity extends AppCompatActivity {
    MainMenuFragment mainMenuFragment = new MainMenuFragment();
    LinearFragment linearFragment = new LinearFragment();
    RelativeFragment relativeFragment = new RelativeFragment();
    LoginFragment loginFragment = new LoginFragment();

    Fragment startFragment,endFragment;
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
        switch (view.getId()) {

            case R.id.continueBtn: {
                Bundle bundle = new Bundle();
                bundle.putString("email", String.valueOf(((EditText) loginFragment.getView().findViewById(R.id.editTextTextEmailAddress)).getText()));
                mainMenuFragment.setArguments(bundle);
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.fragment_container_view, mainMenuFragment)
                        .hide(loginFragment)
                        .commit();
                startFragment=loginFragment;
                endFragment=mainMenuFragment;
                break;
            }
            case R.id.regBtn: {
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.fragment_container_view, linearFragment)
                        .hide(loginFragment)
                        .commit();
                startFragment=loginFragment;
                endFragment=linearFragment;
                break;
            }
            case R.id.addApartmentBtn: {
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.fragment_container_view, relativeFragment)
                        .hide(mainMenuFragment)
                        .commit();

                startFragment=mainMenuFragment;
                endFragment=relativeFragment;
                break;
            }
        }
    }

    @Override
    public void onBackPressed() {
        getSupportFragmentManager().beginTransaction()
                .hide(endFragment)
                .show(startFragment)
                .commit();
    }
}