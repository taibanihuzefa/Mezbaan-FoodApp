package com.example.mezbaan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PlaceOrderOption extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_order_option);
    }


    public void PlaceOrder(View view) {
        Intent placeorder = new Intent(getApplicationContext(), PlaceOrderInfo.class);
        startActivity(placeorder);
    }

    public void GenerateBill(View view) {
        Intent generatebill = new Intent(getApplicationContext(), PlaceOrderInfo.class);
        startActivity(generatebill);
    }
}