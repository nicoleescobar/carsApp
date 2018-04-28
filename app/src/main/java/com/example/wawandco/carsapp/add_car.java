package com.example.wawandco.carsapp;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class add_car extends AppCompatActivity {
    private EditText price, plate;
    private Spinner brand, model, color;
    private Resources resources;
    private String brands[], colors[], models[];
    private ArrayList<Integer> photos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_car);

        resources = this.getResources();
        price = findViewById(R.id.txtPrice);
        plate = findViewById(R.id.txtPlate);

        brand = findViewById(R.id.spinnerBrand);
        model = findViewById(R.id.spinnerModel);
        color = findViewById(R.id.spinnerColor);

        brands = resources.getStringArray(R.array.brands);
        colors= resources.getStringArray(R.array.colors);
        models = resources.getStringArray(R.array.years);

        ArrayAdapter<String> BrandAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, brands);
        brand.setAdapter(BrandAdapter);

        ArrayAdapter<String> ColorAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, colors);
        color.setAdapter(ColorAdapter);

        ArrayAdapter<String> ModelAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, models);
        model.setAdapter(ModelAdapter);

        photos = new ArrayList<Integer>();
        photos.add(R.drawable.d1);
        photos.add(R.drawable.d2);
        photos.add(R.drawable.d3);
        photos.add(R.drawable.d4);
        photos.add(R.drawable.d5);
    }

    public void saveCar(View v){
        String plateVal, priceVal;
        int modelVal, brandVal, colorVal, photo;

        photo = Metodos.fotoAleatoria(photos);
        plateVal = plate.getText().toString();
        priceVal = price.getText().toString();
        modelVal = model.getSelectedItemPosition();
        brandVal = brand.getSelectedItemPosition();
        colorVal = color.getSelectedItemPosition();

        if(validate()){

            Car c = new Car(photo, plateVal, brandVal, modelVal, colorVal, priceVal);
            c.save();

            Context context = getApplicationContext();
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, "Ok", duration);
            toast.show();

            clear();
        }else {
            if (plateVal.trim().length() <= 0 ) {
                plate.setError("Error");
            } else {
                price.setError("Error");
            }
        }

    }

    public void  clear (){
        plate.setText("");
        price.setText("");
        model.setSelection(0);
        color.setSelection(0);
        brand.setSelection(0);
        plate.requestFocus();
    }

    public void clean(View v){
        clear();
    }


    public boolean validate(){
        String plateVal = plate.getText().toString();
        String priceVal = price.getText().toString();

        plate.setError(null);
        price.setError(null);

        if (plateVal.trim().length() > 0 && priceVal.trim().length() > 0  ) {
            return true;
        }
        return false;
    }
}
