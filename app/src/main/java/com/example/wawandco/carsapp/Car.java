package com.example.wawandco.carsapp;

public class Car {
    private int photo;
    private String plate;
    private int brand;
    private int model;
    private int color;
    private String price;

    public Car(int photo, String plate, int brand, int model, int color, String price) {
        this.photo = photo;
        this.plate = plate;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.price = price;
    }


    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public int getBrand() {
        return brand;
    }

    public void setBrand(int brand) {
        this.brand = brand;
    }

    public int getModel() {
        return model;
    }

    public void setModel(int model) {
        this.model = model;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void save(){
        Datos.add(this);
    }

}
