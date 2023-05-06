package com.example.MobileDevelopPractice.UI.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.MobileDevelopPractice.UI.viewmodels.ApartmentVM;
import com.example.MobileDevelopPractice.data.ApartmentDB.Apartment;
import com.example.MobileDevolopPractice.R;

public class AddApartmentFragment extends Fragment {
    View view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ApartmentVM apartmentVM = new ViewModelProvider(this).get(ApartmentVM.class);
        view = inflater.inflate(R.layout.fragment_add_apartment, container, false);
        view.findViewById(R.id.continueNewApartment).setOnClickListener(v -> {
            if (!String.valueOf(((EditText) view.findViewById(R.id.addApartmentName)).getText()).equals("")) {
                Bundle bundle = getArguments();
                if (bundle != null) {
                    apartmentVM.insert(new Apartment(
                            bundle.getInt("UserID"),
                            String.valueOf(((EditText) view.findViewById(R.id.addApartmentName)).getText()),
                            String.valueOf(((EditText) view.findViewById(R.id.apartmentAddress)).getText()),
                            String.valueOf(((EditText) view.findViewById(R.id.apartmentNumber)).getText()),
                            String.valueOf(((EditText) view.findViewById(R.id.payerСode)).getText()),
                            String.valueOf(((EditText) view.findViewById(R.id.energyCode)).getText()),
                            String.valueOf(((EditText) view.findViewById(R.id.energyDeviceCode)).getText())
                    ));

                }
            }
            Navigation.findNavController(view).popBackStack();
        });
        return view;
    }
}