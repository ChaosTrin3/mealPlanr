package com.example.mealplanr;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;

public class NewMealActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_meal);

        Button addBtn = findViewById(R.id.addIngredientBtn);                    //Initialize add button
        addBtn.setOnClickListener(new View.OnClickListener() {                  //Overwrite the OnClickListener()
            @Override
            public void onClick(View v) {
                TableLayout tl = findViewById(R.id.ingredientTableLayout);      //Find the TableLayout view
                ArrayList<String> ingredient = new ArrayList<>();               //Create a new ArrayList
                EditText ingredient_name = findViewById(R.id.newIngredient);    //Find the view responsible for the ingredient name
                Spinner ingredient_qty = findViewById(R.id.qtySpinner);         //Find the view responsible for the qty of the ingredient
                Spinner ingredient_units = findViewById(R.id.unitsSpinner);     //Find the view responsible for the units of the qty
                ingredient.add(ingredient_name.getText().toString());           //Add the name to the ingredient ArrayList
                ingredient.add(ingredient_qty.getSelectedItem().toString());    //Add the qty to the ingredient ArrayList
                ingredient.add(ingredient_units.getSelectedItem().toString());  //Add the unit to the ingredient ArrayList
                TableRow ingredient_entry = newTableRow(ingredient);            //Generate a new TableRow for the ingredient
                tl.addView(ingredient_entry);                                   //Add the TableRow to the TableLayout
                ingredient_name.setText("");                                    //Reset the various inputs
                ingredient_qty.setSelection(0);                                 //--
                ingredient_units.setSelection(0);                               //--
            }
        });
    }
    public TableRow newTableRow(ArrayList<String> ingredientInfo){
        TableRow entry = new TableRow(this);                            //Create a new TableRow
        //Set LayoutParams()                                                //Define the TableRow LayoutParams()
        TextView ingredient_name = new TextView(this);                  //Create a new TextView for the ingredient name
        TextView ingredient_qty = new TextView(this);                   //Create a new TextView for the ingredient qty
        TextView ingredient_units = new TextView(this);                 //Create a new TextView for the ingredient unit
        ingredient_name.setWidth(800);                                      //Poorly managed LayoutParams workaround
        ingredient_name.setText(ingredientInfo.get(0));                     //Populate the TextView
        ingredient_qty.setWidth(80);                                        //Poorly managed LayoutParams workaround
        ingredient_qty.setText(ingredientInfo.get(1));                      //Populate the TextView
        ingredient_units.setWidth(200);                                     //Poorly managed LayoutParams workaround
        ingredient_units.setText(ingredientInfo.get(2));                    //Populate the TextView
        entry.addView(ingredient_name, 0);                              //Add the name to the TableRow
        entry.addView(ingredient_qty, 1);                               //Add the qty to the TableRow
        entry.addView(ingredient_units, 2);                             //Add the unit to the TableRow
        return entry;                                                       //Return the new TableRow
    }
    public void returnToMainViewWithMeal(View view){
        TableLayout tl = findViewById(R.id.ingredientTableLayout);
        ArrayList<TableRow> mealIngredients = new ArrayList<>();
        for(int i = 0, j = tl.getChildCount(); i < j; i++) {
            mealIngredients.add((TableRow) tl.getChildAt(i));
                }
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void returnToMainViewWithoutMeal(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
