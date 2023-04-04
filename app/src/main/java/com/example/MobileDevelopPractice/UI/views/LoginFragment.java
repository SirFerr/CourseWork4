package com.example.MobileDevelopPractice.UI.views;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.MobileDevelopPractice.UI.viewmodels.ViewModel;
import com.example.MobileDevolopPractice.R;


public class LoginFragment extends Fragment {
    private static final int NOTIFY_ID = 0;
    private final String CHANNEL_ID = String.valueOf(R.string.default_notification_channel_id);
    View view;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        Toast.makeText(getActivity(), "onCreate", Toast.LENGTH_SHORT).show();
        Log.d("onCreate", "onCreate");

        super.onCreate(savedInstanceState);

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