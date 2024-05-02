package com.example.mezbaan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PlaceOrderInfo extends AppCompatActivity {

    Button placeorder;
    EditText custname, add, city, cont, email, foodcategory, itmname, itmqty, itmprice, amt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_order_info);

        custname = findViewById(R.id.CustomerName);
        add = findViewById(R.id.Address);
        city = findViewById(R.id.City);
        cont = findViewById(R.id.ContactNo);
        email = findViewById(R.id.EmailId);
        foodcategory = findViewById(R.id.FoodItemCategory);
        itmname = findViewById(R.id.ItemName);
        itmqty = findViewById(R.id.ItemQuantity);
        itmprice = findViewById(R.id.ItemPrice);
        amt = findViewById(R.id.TtlPayableAmt);

        placeorder = findViewById(R.id.PlaceOrder);

        placeorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent placeord = new Intent(PlaceOrderInfo.this, ViewPlaceOrderInfo.class);

                String ccustname = custname.getText().toString();
                String cadd = add.getText().toString();
                String ccity = city.getText().toString();
                String ccont = cont.getText().toString();
                String cemail = email.getText().toString();
                String fcategory = foodcategory.getText().toString();
                String fitname = itmname.getText().toString();
                String fitqty = itmqty.getText().toString();
                String fitprice = itmprice.getText().toString();
                String tamt = amt.getText().toString();

                placeord.putExtra("Ccustname",ccustname);
                placeord.putExtra("Cadd",cadd);
                placeord.putExtra("Ccity",ccity);
                placeord.putExtra("Ccont",ccont);
                placeord.putExtra("Cemail",cemail);
                placeord.putExtra("Fcategory",fcategory);
                placeord.putExtra("Fitname",fitname);
                placeord.putExtra("Fitqty",fitqty);
                placeord.putExtra("Fitprice",fitprice);
                placeord.putExtra("Tamt",tamt);

                startActivity(placeord);

            }
        });


    }

}