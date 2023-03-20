package com.example.pract__2;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

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

        RecyclerViewAdapter.OnStateClickListener onClickListener = (state, position) -> {
            Toast.makeText(getContext(), state.getApartmentName(),
                    Toast.LENGTH_SHORT).show();
            Log.d("RecyclerView", state.getApartmentName());
        };

        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(), apartments, onClickListener);
        RecyclerView recyclerView = view.findViewById(R.id.RecyclerViewCity);
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_main_menu, container, false);

        Bundle bundle = getArguments();
        if (bundle != null) {
            TextView textView = (TextView) view.findViewById(R.id.emailName);
            textView.setText(bundle.getString("email"));
        }
        return view;
    }
}