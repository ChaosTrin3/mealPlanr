package com.example.mealplanr;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> mealList = new ArrayList<>();

        String mealTitle1 = "Brisket, potatoes, and broccoli";
        String mealTitle2 = "Salmon and Brussels over rice";
        String mealTitle3 = "Chicken tray";

        mealList.add(mealTitle1);
        mealList.add(mealTitle2);
        mealList.add(mealTitle3);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, mealList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner sun_s = findViewById(R.id.sunSpinner);
        Spinner mon_s = findViewById(R.id.monSpinner);
        Spinner tue_s = findViewById(R.id.tueSpinner);
        Spinner wed_s = findViewById(R.id.wedSpinner);
        Spinner thu_s = findViewById(R.id.thuSpinner);
        Spinner fri_s = findViewById(R.id.friSpinner);
        Spinner sat_s = findViewById(R.id.satSpinner);
        sun_s.setAdapter(adapter);
        mon_s.setAdapter(adapter);
        tue_s.setAdapter(adapter);
        wed_s.setAdapter(adapter);
        thu_s.setAdapter(adapter);
        fri_s.setAdapter(adapter);
        sat_s.setAdapter(adapter);


    }
    /** Launches new Activity to customize a meal **/
    public void generateNewMeal(View view){
        Intent intent = new Intent(this, NewMealActivity.class);
        startActivity(intent);
    }
}

