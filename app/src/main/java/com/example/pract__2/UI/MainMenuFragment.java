package com.example.pract__2.UI;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pract__2.R;
import com.example.pract__2.data.Apartment;

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
        for (int i = 1; i < 200; i++) {
            apartments.add(new Apartment(String.valueOf(i), R.drawable.cabinetlog, String.valueOf(i + 1)));
        }

        RecyclerViewMainMenuAdapter.OnStateClickListener onClickListener = (state, position) -> {
            Toast.makeText(getContext(), state.getApartmentName(),
                    Toast.LENGTH_SHORT).show();
            Log.d("RecyclerView", state.getApartmentName());
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

        view.findViewById(R.id.addApartmentBtn).setOnClickListener(v -> Navigation.findNavController(view).navigate(R.id.action_mainMenuFragment_to_relativeFragment));

        return view;
    }
}