package com.example.MobileDevelopPractice.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.MobileDevelopPractice.model.Apartment;
import com.example.MobileDevelopPractice.viewmodels.ViewModel;
import com.example.MobileDevolopPractice.R;

import java.util.ArrayList;
import java.util.List;

public class MainMenuFragment extends Fragment {
    View view;

    @Nullable
    @Override
    public View getView() {
        return view;
    }


    @Override
    public void onResume() {
        super.onResume();

        List<Apartment> apartments = new ArrayList<Apartment>();
        ViewModel model = new ViewModelProvider(this).get(ViewModel.class);
        for (int i = 1; i < 10; i++) {
            apartments.add(new Apartment(String.valueOf(i), String.valueOf(i + 1)));
        }

        model.addApartment("id", "name");
        model.getApartmentUI().observe(this, apartmentUI -> {
            apartments.add(apartmentUI.getApartment());
        });

        RecyclerViewMainMenuAdapter.OnStateClickListener onClickListener = (state, position) -> {
            Toast.makeText(getContext(), state.getApartmentName(),
                    Toast.LENGTH_SHORT).show();
            Bundle bundle1 = new Bundle();
            bundle1.putString("apartmentId", (state.getApartmentID()));
            bundle1.putString("apartmentName", (state.getApartmentName()));
            Navigation.findNavController(view).navigate(R.id.action_mainMenuFragment_to_apartmentFragment, bundle1);
        };

        RecyclerViewMainMenuAdapter recyclerViewMainMenuAdapter = new RecyclerViewMainMenuAdapter(getContext(), apartments, onClickListener);
        RecyclerView recyclerView = view.findViewById(R.id.RecyclerViewCity);
        recyclerView.setAdapter(recyclerViewMainMenuAdapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_main_menu, container, false);

        Bundle bundle = getArguments();
        if (bundle != null) {
            TextView textView = view.findViewById(R.id.emailName);
            textView.setText(bundle.getString("email"));
        }

        view.findViewById(R.id.addApartmentBtn).setOnClickListener(
                v -> Navigation.findNavController(view).navigate(R.id.action_mainMenuFragment_to_addApartmentFragment));

        return view;
    }
}