package com.example.MobileDevelopPractice.UI.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.MobileDevelopPractice.UI.viewmodels.ApartmentVM;
import com.example.MobileDevelopPractice.data.ApartmentDB.Apartment;
import com.example.MobileDevolopPractice.R;

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
        ApartmentVM apartmentVM = new ViewModelProvider(this).get(ApartmentVM.class);

        Bundle bundle = getArguments();
        apartmentVM.getAllApartment().observe(this, apartments -> {
                    RecyclerViewMainMenuAdapter.OnStateClickListener onClickListener = (state, position) -> {
                        Bundle bundle1 = new Bundle();
                        Apartment temp = apartments.get(position);
                        bundle1.putString("id", String.valueOf(temp.apartmentId));
                        bundle1.putString("name", temp.apartmentName);
                        Navigation.findNavController(view).navigate(R.id.action_mainMenuFragment_to_apartmentFragment, bundle1);
                    };
                    ((RecyclerView) view.findViewById(R.id.RecyclerViewCity))
                            .setAdapter(new RecyclerViewMainMenuAdapter(getContext(), apartments, bundle.getInt("UserID"), onClickListener));
                }
        );

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

                v -> {
                    Navigation.findNavController(view).navigate(R.id.action_mainMenuFragment_to_addApartmentFragment, bundle);
                });
        return view;
    }
}