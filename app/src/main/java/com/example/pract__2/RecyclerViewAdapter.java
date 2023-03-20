package com.example.pract__2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private final LayoutInflater inflater;
    private final OnStateClickListener onClickListener;
    private final List<Apartment> apartments;
    public RecyclerViewAdapter(Context context, List<Apartment> apartments, OnStateClickListener onClickListener) {
        this.inflater =LayoutInflater.from(context);
        this.onClickListener = onClickListener;
        this.apartments = apartments;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapter.ViewHolder holder, int position) {
        Apartment apartment = apartments.get(position);
        holder.imageView.setImageResource(apartment.getImageID());
        holder.apartmentID.setText(String.valueOf(apartment.getApartmentID()));
        holder.apartmentName.setText(String.valueOf(apartment.getApartmentName()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickListener.onStateClick(apartment, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return apartments.size();
    }

    interface OnStateClickListener {
        void onStateClick(Apartment apartment, int position);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        final ImageView imageView;
        final TextView apartmentName, apartmentID;

        ViewHolder(View view) {
            super(view);
            imageView = view.findViewById(R.id.ImageViewList);
            apartmentName = view.findViewById(R.id.apartmentName);
            apartmentID = view.findViewById(R.id.apartmentID);

        }

    }
}
