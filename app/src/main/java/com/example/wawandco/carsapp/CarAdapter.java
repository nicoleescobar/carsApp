package com.example.wawandco.carsapp;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.CarViewHolder>{
    private ArrayList<Car> cars;

    public CarAdapter(ArrayList<Car> cars){
        this.cars=cars;
    }

    @Override
    public CarViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_cars,parent,false);
        return new CarViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CarViewHolder holder, int position) {
        Resources res = holder.itemView.getContext().getResources();
        Car c = cars.get(position);

        holder.photo.setImageResource(c.getPhoto());
        holder.plate.setText(c.getPlate());
        holder.brand.setText(res.getStringArray(R.array.brands)[c.getBrand()]);
        holder.model.setText(res.getStringArray(R.array.years)[c.getModel()]);
        holder.price.setText(c.getPrice());
    }

    @Override
    public int getItemCount() {
        return cars.size();
    }

    public static class CarViewHolder extends RecyclerView.ViewHolder{
        private ImageView photo;
        private TextView plate;
        private TextView brand;
        private TextView model;
        private TextView price;
        private View v;
        public CarViewHolder(View itemView) {
            super(itemView);
            v = itemView;
            photo = v.findViewById(R.id.imgFoto);
            plate = v.findViewById(R.id.lblPlate);
            brand = v.findViewById(R.id.lblBrand);
            model = v.findViewById(R.id.lblModel);
            price = v.findViewById(R.id.lblPrice);
        }
    }
}
