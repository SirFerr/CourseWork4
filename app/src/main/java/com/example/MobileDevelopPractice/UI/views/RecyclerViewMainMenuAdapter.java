package com.example.MobileDevelopPractice.UI.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.MobileDevelopPractice.data.ApartmentDB.Apartment;
import com.example.MobileDevolopPractice.R;

import java.util.List;

public class RecyclerViewMainMenuAdapter extends RecyclerView.Adapter<RecyclerViewMainMenuAdapter.ViewHolder> {

    private final LayoutInflater inflater;
    private final OnStateClickListener onClickListener;
    private final List<Apartment> apartments;

    private final int UserID;

    public RecyclerViewMainMenuAdapter(Context context, List<Apartment> apartments, int UserID, OnStateClickListener onClickListener) {
        this.inflater = LayoutInflater.from(context);
        this.onClickListener = onClickListener;
        this.apartments = apartments;
        this.UserID = UserID;
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
        if (apartment.UserID == UserID) {
            holder.apartmentName.setText(String.valueOf(apartment.apartmentName));
            holder.itemView.setOnClickListener(v -> onClickListener.onStateClick(apartment, position));
        }

    }

    @Override
    public int getItemCount() {
        return apartments.size();
    }

    interface OnStateClickListener {
        void onStateClick(Apartment apartment, int position);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        final TextView apartmentName;

        ViewHolder(View view) {
            super(view);
            apartmentName = view.findViewById(R.id.apartmentName);
        }

    }
}
