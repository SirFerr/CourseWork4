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

public class RegistrationFragment extends Fragment {
    View view;

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_registration, container, false);
        Bundle bundle = getArguments();
        if (bundle != null) {
            EditText email = view.findViewById(R.id.regEmail);
            email.setText(bundle.getString("email"));
        }
        view.findViewById(R.id.regBtnNew).setOnClickListener(v -> {
            Bundle result = new Bundle();
            String email = String.valueOf(((EditText) view.findViewById(R.id.regEmail)).getText());
            String password = String.valueOf(((EditText) view.findViewById(R.id.regPassword)).getText());
            String phone = String.valueOf(((EditText) view.findViewById(R.id.regPhone)).getText());

            UserVM userVM = new ViewModelProvider(this).get(UserVM.class);
            if (!email.equals("") || !password.equals("") || !phone.equals("")) {
                if (email.equals("admin") && password.equals("admin")) {
                    userVM.insert(new User(1, email, password, phone));
                } else
                    userVM.insert(new User(0, email, password, phone));
                Navigation.findNavController(view).popBackStack();
            } else Toast.makeText(getContext(), "Not complete", Toast.LENGTH_SHORT).show();
        });
        return view;
    }

}

