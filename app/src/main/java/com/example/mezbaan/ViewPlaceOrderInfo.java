package com.example.mezbaan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class ViewPlaceOrderInfo extends AppCompatActivity {

    TextView custname, add, city, cont, email, foodcategory, itmname, itmqty, itmprice, amt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_place_order_info);

        custname = findViewById(R.id.showCustomerName);
        add = findViewById(R.id.showAddress);
        city = findViewById(R.id.showCity);
        cont = findViewById(R.id.showContactNo);
        email = findViewById(R.id.showEmailId);
        foodcategory = findViewById(R.id.showFoodItemCategory);
        itmname = findViewById(R.id.showItemName);
        itmqty = findViewById(R.id.showItemQuantity);
        itmprice = findViewById(R.id.showItemPrice);
        amt = findViewById(R.id.showTlPayableAmt);

        Intent showdetails = getIntent();

        String ccustname = showdetails.getStringExtra("Ccustname");
        String cadd = showdetails.getStringExtra("Cadd");
        String ccity = showdetails.getStringExtra("Ccity");
        String ccont = showdetails.getStringExtra("Ccont");
        String cemail = showdetails.getStringExtra("Cemail");
        String fcategory = showdetails.getStringExtra("Fcategory");
        String fitname = showdetails.getStringExtra("Fitname");
        String fitqty = showdetails.getStringExtra("Fitqty");
        String fitprice = showdetails.getStringExtra("Fitprice");
        String tamt = showdetails.getStringExtra("Tamt");

        custname.setText(ccustname);
        add.setText(cadd);
        city.setText(ccity);
        cont.setText(ccont);
        email.setText(cemail);
        foodcategory.setText(fcategory);
        itmname.setText(fitname);
        itmqty.setText(fitqty);
        itmprice.setText(fitprice);
        amt.setText(tamt);

    }
}