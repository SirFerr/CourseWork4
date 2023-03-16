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
        for (int i = 0; i < 200; i++) {
            apartments.add(new Apartment(String.valueOf(i),R.drawable.cabinetlog,String.valueOf(i + 1)));
        }
        final ArrayAdapter<Apartment> listAdapter = new ListViewAdapter(getContext(), R.layout.list_item, apartments);

        ListView listView = view.findViewById(R.id.ListView);
        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View itemClicked, int position,
                                    long id) {
                Toast.makeText(getContext(), ((TextView) itemClicked.findViewById(R.id.apartmentName)).getText(),
                        Toast.LENGTH_SHORT).show();
                Log.d("ListView", (String) ((TextView) itemClicked.findViewById(R.id.apartmentName)).getText());
            }
        });
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