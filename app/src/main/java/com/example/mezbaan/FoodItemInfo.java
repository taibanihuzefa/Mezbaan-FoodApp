package com.example.mezbaan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class FoodItemInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_item_info);
    }

    public void ViewFood(View view) {
        Intent viewfood = new Intent(FoodItemInfo.this, ViewFood.class);
        startActivity(viewfood);
    }

    public void AddFood(View view) {
        Intent addfood = new Intent(FoodItemInfo.this, AddFood.class);
        startActivity(addfood);
    }
}