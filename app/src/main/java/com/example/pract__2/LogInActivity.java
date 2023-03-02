package com.example.pract__2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class LogInActivity extends AppCompatActivity {
    MainMenuFragment mainMenuFragment =new MainMenuFragment();
    LinearFragment linearFragment = new LinearFragment();

    RelativeFragment relativeFragment  = new RelativeFragment();
    LoginFragment loginFragment = new LoginFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportFragmentManager().beginTransaction()
                .setReorderingAllowed(true)
                .add(R.id.fragment_container_view,loginFragment)
                .commit();
    }

    public void onLogInBtnClick(View view){
        getSupportFragmentManager().beginTransaction()
                .setReorderingAllowed(true)
                .add(R.id.fragment_container_view,mainMenuFragment)
                .hide(loginFragment)
                .commit();

//        Intent intent = new Intent(this,MainMenu.class);
////        EditText editText = (EditText) view.findViewById(R.id.editTextTextEmailAddress);
////        intent.putExtra("email",editText.getText().toString());
//        startActivity(intent);
    }

    public void onRegBtnClick(View view){
        getSupportFragmentManager().beginTransaction()
                .setReorderingAllowed(true)
                .replace(R.id.fragment_container_view,linearFragment)
                .commit();
    }
}