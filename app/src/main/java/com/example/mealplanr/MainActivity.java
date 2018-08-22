package com.example.mealplanr;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<ArrayList<String>> mealList = new ArrayList<>();

        ArrayList<String> recipe1 = new ArrayList<>();

        String s1 = "Meal Name!";
        String s2 = "Ingredient 1";
        String s3 = "Ingredient 2";
        String s4 = "etc...";

        recipe1.add(s1);
        recipe1.add(s2);
        recipe1.add(s3);
        recipe1.add(s4);

        mealList.add(recipe1);

        Spinner s = findViewById(R.id.sunSpinner);
        ArrayAdapter<ArrayList<String>> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, mealList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);
    }
}
