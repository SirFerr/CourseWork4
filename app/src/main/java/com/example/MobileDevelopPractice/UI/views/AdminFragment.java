package com.example.MobileDevelopPractice.UI.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.MobileDevelopPractice.UI.viewmodels.UserVM;
import com.example.MobileDevolopPractice.R;


public class AdminFragment extends Fragment {

    View view;

    @Override
    public void onResume() {
        super.onResume();
        EditText id = view.findViewById(R.id.adminEditText);
        Button ban = view.findViewById(R.id.ban);
        Button unban = view.findViewById(R.id.unban);
        UserVM userVM = new ViewModelProvider(this).get(UserVM.class);

        ban.setOnClickListener(v ->
                userVM.updateRole(Integer.parseInt(String.valueOf(id.getText())), 2)
        );
        unban.setOnClickListener(v ->
                userVM.updateRole(Integer.parseInt(String.valueOf(id.getText())), 0)
        );

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_admin, container, false);

        return view;
    }
}