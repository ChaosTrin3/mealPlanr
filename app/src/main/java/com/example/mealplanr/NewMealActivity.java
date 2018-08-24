package com.example.mealplanr;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.Switch;

import java.util.ArrayList;
import java.util.List;

public class NewMealActivity extends Activity {

    public List<String> ingredientList_short = new ArrayList<>();
    public List<ArrayList<String>> ingredientList_long = new ArrayList<>();
    public ListView i_lv;
    public EditText ingredient;
    public Spinner qty;
    public Spinner unit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_meal);

        i_lv = findViewById(R.id.ingredientList);
        ingredient = findViewById(R.id.newIngredient);
        qty = findViewById(R.id.qtySpinner);
        unit = findViewById(R.id.unitsSpinner);

        Button addBtn = findViewById(R.id.addIngredientBtn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> newIngredient = new ArrayList<>();

                newIngredient.add(ingredient.getText().toString());
                newIngredient.add(qty.getSelectedItem().toString());
                newIngredient.add(unit.getSelectedItem().toString());

                ingredientList_short.add(newIngredient.get(0));
                ingredientList_long.add(newIngredient);

                ArrayAdapter<String> adapter = new ArrayAdapter<>(
                        NewMealActivity.this,
                        android.R.layout.simple_list_item_1,
                        ingredientList_short);
                i_lv.setAdapter(adapter);

                ingredient.setText("");
                qty.setSelection(0);
                unit.setSelection(0);
            }
        });

//        i_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                int index = i_lv.getSelectedItemPosition();
//                int unitIndex = 0;
//                String unitVal = ingredientList_long.get(index).get(2);
//
//                ingredient.setText(ingredientList_long.get(index).get(0));
//                qty.setSelection(Integer.parseInt(ingredientList_long.get(index).get(1))-1);
//                switch (unitVal){
//                    case "Items":
//                        unitIndex = 0;
//                        break;
//                    case "Lbs":
//                        unitIndex = 1;
//                        break;
//                }
//                unit.setSelection(unitIndex);
//            }
//        });
    }
}
