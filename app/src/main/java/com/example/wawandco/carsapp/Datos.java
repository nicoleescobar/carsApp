package com.example.wawandco.carsapp;

import java.util.ArrayList;

public class Datos {
    public static ArrayList<Car> cars = new ArrayList<>();

    public static void add(Car c){
        cars.add(c);
    }

    public static ArrayList<Car> get(){
        return cars;
    }
}
