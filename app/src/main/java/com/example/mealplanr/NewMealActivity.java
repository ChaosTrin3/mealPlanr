package com.example.mealplanr;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NewMealActivity extends Activity {

    public List<String> ingredientList = new ArrayList<>();
    public TableLayout i_tl;
    public EditText ingredientName;
    public Spinner qty;
    public Spinner unit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_meal);

        final HashMap<String, ArrayList<String>> ingredientMap = new HashMap<>();

        i_tl = findViewById(R.id.ingredientTableLayout);
        ingredientName = findViewById(R.id.newIngredient);
        qty = findViewById(R.id.qtySpinner);
        unit = findViewById(R.id.unitsSpinner);

        final TableRow ingredient = new TableRow(this);
        ingredient.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));

        TextView tv = new TextView(this);
        tv.setText("New Data!");

        ingredient.addView(tv,0);
        ingredient.addView(tv, 1);

        Button addBtn = findViewById(R.id.addIngredientBtn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> ingredientInfo = new ArrayList<>();

                ingredientList.add(ingredientName.getText().toString());
                ingredientInfo.add(qty.getSelectedItem().toString());
                ingredientInfo.add(unit.getSelectedItem().toString());

                ingredientMap.put(ingredientName.getText().toString(), ingredientInfo);

                i_tl.addView(ingredient, new TableLayout.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

                ingredientName.setText("");
                qty.setSelection(0);
                unit.setSelection(0);
            }
        });
    }
}
