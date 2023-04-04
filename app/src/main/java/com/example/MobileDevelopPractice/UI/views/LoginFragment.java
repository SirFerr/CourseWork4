package com.example.MobileDevelopPractice.UI.views;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.room.Room;

import com.example.MobileDevelopPractice.UI.viewmodels.ViewModel;
import com.example.MobileDevelopPractice.data.ApartmentDB.AppDatabase;
import com.example.MobileDevolopPractice.R;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class LoginFragment extends Fragment {
    private static final int NOTIFY_ID = 0;
    private final String CHANNEL_ID = String.valueOf(R.string.default_notification_channel_id);
    View view;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        //appSpecificStorage
        try {
            String filename = "appSpecificStorage";
            File file = new File(getActivity().getFilesDir() + filename);
            Log.d(filename, String.valueOf(file.createNewFile()));
            file.delete();
        } catch (
                IOException e) {
            throw new RuntimeException(e);
        }


        //externalStorage
        try {
            String filename = "externalStorage";
            String str = "test data";
            FileOutputStream fOut = getActivity().openFileOutput(filename, Context.MODE_PRIVATE);
            fOut.write(str.getBytes());
            fOut.close();
            FileInputStream fin = getActivity().openFileInput(filename);
            int c;
            String temp = "";
            while ((c = fin.read()) != -1) {
                temp = temp + (char) c;
            }
            fin.close();
            Log.d(filename, temp);
        } catch (
                FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (
                IOException e) {
            throw new RuntimeException(e);
        }

        //SharedPreferences
        SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("test", "test data");
        editor.apply();
        Log.d("SharedPreferences", sharedPref.getString("test", ""));
        super.onCreate(savedInstanceState);

        //Room
        AppDatabase db = Room.databaseBuilder(getActivity().getApplicationContext(),
                AppDatabase.class, "apartments").allowMainThreadQueries().build();

        int id = 1000;
        if (db.apartmentDao().findById(id).apartmentName == null) {
            db.apartmentDao().insert(id, "name1");
        } else {
            db.apartmentDao().delete(id);
            db.apartmentDao().insert(id, "name2");
        }
        Log.d("activity", db.apartmentDao().findById(id).apartmentName);


        ViewModel userViewModel = new ViewModelProvider(this).get(ViewModel.class);
        userViewModel.addUser(getResources().getString(R.string.testEmail), "hello");
        userViewModel.getUserID().observe(this, userID -> {
            EditText editText = view.findViewById(R.id.editTextTextEmailAddress);
            editText.setText(userID.getUser().getEmail());
            EditText editText1 = view.findViewById(R.id.editTextTextPassword);
            editText1.setText(userID.getUser().getPassword());
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_login, container, false);

        EditText editText = view.findViewById(R.id.editTextTextEmailAddress);
        editText.setText(getResources().getString(R.string.testEmail));

        Bundle bundle = getArguments();
        if (bundle != null) {
            ((EditText) view.findViewById(R.id.editTextTextEmailAddress)).setText(bundle.getString("email"));
        }
        view.findViewById(R.id.continueBtn).setOnClickListener(v -> {

            Bundle bundle12 = new Bundle();
            bundle12.putString("email", String.valueOf(((EditText) view
                    .findViewById(R.id.editTextTextEmailAddress))
                    .getText()));

            Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_mainMenuFragment, bundle12);
        });
        view.findViewById(R.id.regBtn).setOnClickListener(v -> {
            Bundle bundle1 = new Bundle();
            bundle1.putString("email", String.valueOf(((EditText) view
                    .findViewById(R.id.editTextTextEmailAddress))
                    .getText()));
            Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_registrationFragment, bundle1);
        });


        return view;
    }

}