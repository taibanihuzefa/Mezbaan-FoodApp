package com.example.mezbaan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FoodItemCategory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_item_category);
    }

    public void AddFood(View view) {
        Intent addfoodcategory = new Intent(FoodItemCategory.this, AddFoodItemCategory.class);
        startActivity(addfoodcategory);
    }

    public void ViewFood(View view) {
        Intent viewfoodcategory = new Intent(FoodItemCategory.this, ViewFoodItemCategory.class);
        startActivity(viewfoodcategory);
    }
}