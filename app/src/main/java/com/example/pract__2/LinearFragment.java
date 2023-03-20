package com.example.pract__2;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class LinearFragment extends Fragment {
    View view;

    @Override
    public void onResume() {
        super.onResume();
    }

    public void clickRegBtnNew() {
        Log.d("regBtnNew", "clicked0");
        Bundle result = new Bundle();
        result.putString("email", String.valueOf(((EditText) view.findViewById(R.id.editTextTextEmailAddress2)).getText()));
        if (String.valueOf(((EditText) view.findViewById(R.id.editTextTextPassword2)).getText()) != null)
            result.putString("passwd", String.valueOf(((EditText) view.findViewById(R.id.editTextTextPassword2)).getText()));
        getParentFragmentManager().setFragmentResult("requestKey", result);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_linear, container, false);
        Bundle bundle = getArguments();
        if (bundle != null) {
            TextView textView = (TextView) view.findViewById(R.id.editTextTextEmailAddress2);
            textView.setText(bundle.getString("email"));
        }
        return view;
    }

}

