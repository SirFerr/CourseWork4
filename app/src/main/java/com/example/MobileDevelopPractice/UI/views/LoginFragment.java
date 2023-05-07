package com.example.MobileDevelopPractice.UI.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.MobileDevelopPractice.UI.viewmodels.UserVM;
import com.example.MobileDevelopPractice.data.UserDB.User;
import com.example.MobileDevolopPractice.R;

import java.util.concurrent.ExecutionException;


public class LoginFragment extends Fragment {
    private static final int NOTIFY_ID = 0;
    private final String CHANNEL_ID = String.valueOf(R.string.default_notification_channel_id);

    View view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        EditText email = view.findViewById(R.id.logEmail);
        EditText password = view.findViewById(R.id.logPassword);

        UserVM userVM = new ViewModelProvider(this).get(UserVM.class);
        userVM.getAllUser().observe(this, users -> {
            view.findViewById(R.id.continueBtn).setOnClickListener(v -> {

                if (!String.valueOf(email.getText()).equals("")) {
                    User temp = null;
                    try {
                        temp = userVM.searchByEmail(String.valueOf(email.getText())).get();
                    } catch (ExecutionException | InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    if (temp != null) {
                        if (temp.password.equals(String.valueOf(password.getText()))) {
                            if (temp.role == 0) {
                                Bundle bundle12 = new Bundle();
                                bundle12.putInt("UserID", temp.UserID);
                                bundle12.putString("email", temp.email);
                                Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_mainMenuFragment, bundle12);
                                Toast.makeText(getContext(), "id: " + temp.UserID, Toast.LENGTH_SHORT).show();
                            }
                            if (temp.role == 1) {
                                Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_adminFragment);
                            }
                            if (temp.role == 2) {
                                Toast.makeText(getContext(), "You have been banned", Toast.LENGTH_SHORT).show();
                            }

                        } else
                            Toast.makeText(getContext(), "Wrong password", Toast.LENGTH_SHORT).show();
                    } else
                        Toast.makeText(getContext(), "User not find", Toast.LENGTH_SHORT).show();

                }
            });
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_login, container, false);

        EditText email = view.findViewById(R.id.logEmail);
        view.findViewById(R.id.regBtn).setOnClickListener(v -> {
            Bundle bundle1 = new Bundle();
            bundle1.putString("email", String.valueOf(email.getText()));
            Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_registrationFragment, bundle1);
        });


        return view;
    }

}