package com.example.MobileDevelopPractice.UI.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.MobileDevolopPractice.R;


public class LoginFragment extends Fragment {
    private static final int NOTIFY_ID = 0;
    private final String CHANNEL_ID = String.valueOf(R.string.default_notification_channel_id);

    View view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_login, container, false);

        EditText email = view.findViewById(R.id.editTextTextEmailAddress);
        EditText password = view.findViewById(R.id.editTextTextPassword);

        Bundle bundle = getArguments();
        if (bundle != null) {
            ((EditText) view.findViewById(R.id.editTextTextEmailAddress)).setText(bundle.getString("email"));
        }
        view.findViewById(R.id.continueBtn).setOnClickListener(v -> {

            if (!String.valueOf(email.getText()).equals("")) {
                if ("2".equals(String.valueOf(password.getText())) && String.valueOf(email.getText()).equals("2")) {
                    Bundle bundle12 = new Bundle();
                    bundle12.putInt("UserID", 2);
                    bundle12.putString("email", String.valueOf(((EditText) view
                            .findViewById(R.id.editTextTextEmailAddress))
                            .getText()));

                    Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_mainMenuFragment, bundle12);
                } else if ("3".equals(String.valueOf(password.getText())) && String.valueOf(email.getText()).equals("3")) {
                    Bundle bundle12 = new Bundle();
                    bundle12.putInt("UserID", 3);
                    bundle12.putString("email", String.valueOf(((EditText) view
                            .findViewById(R.id.editTextTextEmailAddress))
                            .getText()));

                    Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_mainMenuFragment, bundle12);
                } else Toast.makeText(getContext(), "Wrong password", Toast.LENGTH_SHORT).show();
            }
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