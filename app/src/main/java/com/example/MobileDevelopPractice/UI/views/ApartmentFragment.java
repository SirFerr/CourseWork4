package com.example.MobileDevelopPractice.UI.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.MobileDevelopPractice.UI.viewmodels.ApartmentVM;
import com.example.MobileDevolopPractice.R;

public class ApartmentFragment extends Fragment {

    View view;

    @Override
    public void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_apartment, container, false);
        ApartmentVM apartmentVM = new ViewModelProvider(this).get(ApartmentVM.class);
        Bundle bundle = getArguments();
        if (bundle != null) {
            TextView textView = view.findViewById(R.id.IdAppartment);

            textView.setText(bundle.getString("id"));
            TextView textView2 = view.findViewById(R.id.NameApartment);
            textView2.setText(bundle.getString("name"));
            Button delete = view.findViewById(R.id.deleteApartment);
            delete.setOnClickListener(v -> {
                Navigation.findNavController(view).popBackStack();
                apartmentVM.deleteByID(Integer.parseInt(bundle.getString("id")));
            });
        }


        return view;
    }
}