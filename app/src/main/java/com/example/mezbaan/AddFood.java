package com.example.mezbaan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class AddFood extends AppCompatActivity {

    EditText foodname, foodprice, fooddesc;
    TextView txtresult;
    Button btnaddfood, viewfoodbtn;
    AutoCompleteTextView foodcategory;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food);


        foodname = findViewById(R.id.FoodName);
        foodcategory = findViewById(R.id.FoodCategory);
        foodprice = findViewById(R.id.FoodPrice);
        fooddesc = findViewById(R.id.FoodDesc);
        btnaddfood = findViewById(R.id.btnAddFood);
        viewfoodbtn = findViewById(R.id.btnViewFood);
        txtresult = findViewById(R.id.txtresult);

        DbHelper helper = new DbHelper(AddFood.this);
        helper.open();
        ArrayList<String> getFCat = helper.getFoodCategory();
        ArrayAdapter<String> list = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, getFCat);
        foodcategory.setAdapter(list);


        btnaddfood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DbHelper helper = new DbHelper(AddFood.this);
                helper.open();
                helper.addFoodItem(new String[]{foodname.getText().toString(), foodcategory.getText().toString(), foodprice.getText().toString(), fooddesc.getText().toString()});
                helper.close();

                Toast.makeText(AddFood.this, "Food Item Added Sucessfully", Toast.LENGTH_SHORT).show();
                viewfoodbtn.setVisibility(View.VISIBLE);

            }
        });

        viewfoodbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddFood.this, ViewFood.class);
                startActivity(intent);

            }
        });
    }


}