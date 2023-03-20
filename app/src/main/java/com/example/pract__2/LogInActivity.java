package com.example.pract__2;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class LogInActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

    }
//    public void Change(View view) {
//        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//        switch (view.getId()) {
//            case R.id.continueBtn: {
//                Bundle bundle = new Bundle();
//                bundle.putString("email", String.valueOf(((EditText) loginFragment
//                        .getView()
//                        .findViewById(R.id.editTextTextEmailAddress))
//                        .getText()));
//                mainMenuFragment.setArguments(bundle);
//                ft
//                        .replace(R.id.fragment_container_view, mainMenuFragment);
//                break;
//            }
//            case R.id.regBtn: {
//                Bundle bundle = new Bundle();
//                bundle.putString("email", String.valueOf(((EditText) loginFragment
//                        .getView()
//                        .findViewById(R.id.editTextTextEmailAddress))
//                        .getText()));
//                linearFragment.setArguments(bundle);
//                ft
//                        .replace(R.id.fragment_container_view, linearFragment);
//                break;
//            }
//            case R.id.addApartmentBtn: {
//                ft
//                        .replace(R.id.fragment_container_view, relativeFragment);
//                break;
//            }
//            case R.id.regBtnNew: {
//                Log.d("regBtnNew","click");
//                linearFragment.clickRegBtnNew();
//                ft
//                        .replace(R.id.fragment_container_view,loginFragment);
//                break;
//            }
//        }
//        ft.addToBackStack(null).commit();
//    }
}