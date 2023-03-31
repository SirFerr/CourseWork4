package com.example.MobileDevelopPractice.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.MobileDevelopPractice.model.Apartment;
import com.example.MobileDevolopPractice.R;

import java.util.List;

public class RecyclerViewMainMenuAdapter extends RecyclerView.Adapter<RecyclerViewMainMenuAdapter.ViewHolder> {

    private final LayoutInflater inflater;
    private final OnStateClickListener onClickListener;
    private final List<Apartment> apartments;

    public RecyclerViewMainMenuAdapter(Context context, List<Apartment> apartments, OnStateClickListener onClickListener) {
        this.inflater = LayoutInflater.from(context);
        this.onClickListener = onClickListener;
        this.apartments = apartments;
    }

    @NonNull
    @Override
    public RecyclerViewMainMenuAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item_main_menu, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerViewMainMenuAdapter.ViewHolder holder, int position) {
        Apartment apartment = apartments.get(position);
        holder.apartmentID.setText(String.valueOf(apartment.getApartmentID()));
        holder.apartmentName.setText(String.valueOf(apartment.getApartmentName()));

        holder.itemView.setOnClickListener(v -> onClickListener.onStateClick(apartment, position));
    }

    @Override
    public int getItemCount() {
        return apartments.size();
    }

    interface OnStateClickListener {
        void onStateClick(Apartment apartment, int position);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        final TextView apartmentName, apartmentID;

        ViewHolder(View view) {
            super(view);
            apartmentName = view.findViewById(R.id.apartmentName);
            apartmentID = view.findViewById(R.id.apartmentID);
        }

    }
}
