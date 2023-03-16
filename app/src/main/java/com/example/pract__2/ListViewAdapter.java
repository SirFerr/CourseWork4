package com.example.pract__2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ListViewAdapter extends ArrayAdapter<Apartment> {
    private LayoutInflater inflater;
    private int layout;
    private List<Apartment> apartment;

    public ListViewAdapter(Context context, int resource,
                           List<Apartment> items) {
        super(context, resource, items);
        this.apartment = items;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = inflater.inflate(this.layout, parent, false);
        TextView textView = view.findViewById(R.id.apartmentID);
        TextView nameOfApartment = view.findViewById(R.id.apartmentName);
        ImageView imageView = view.findViewById(R.id.ImageViewList);
        Apartment item = apartment.get(position);
        textView.setText(String.valueOf(item.getApartmentID()));
        imageView.setImageResource(item.getImageID());
        nameOfApartment.setText(item.getApartmentName());
        return view;
    }
}
