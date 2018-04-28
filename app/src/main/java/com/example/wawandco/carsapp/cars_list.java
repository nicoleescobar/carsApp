package com.example.wawandco.carsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class cars_list extends AppCompatActivity {
    private RecyclerView carsList;
    private Intent i;
    private ArrayList<Car> cars;
    private CarAdapter adapter;
    private LinearLayoutManager llm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cars_list);

        carsList = findViewById(R.id.carsListUI);
        cars = Datos.get();

        llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        adapter = new CarAdapter(cars);
        carsList.setLayoutManager(llm);
        carsList.setAdapter(adapter);
    }
}
