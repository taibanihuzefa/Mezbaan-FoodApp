package com.example.mezbaan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AddFoodItemCategory extends AppCompatActivity {

    EditText categoryname, categorydesc;
    TextView txtresult;
    Button btnaddfoodcategory, viewcategorybtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food_item_category);

        categoryname = findViewById(R.id.CategoryName);
        categorydesc = findViewById(R.id.CategoryDesc);
        btnaddfoodcategory = findViewById(R.id.btnAddFoodCategory);
        viewcategorybtn = findViewById(R.id.btnViewFoodCategory);
        txtresult = findViewById(R.id.txtresult);



        btnaddfoodcategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = categoryname.getText().toString();
                String desc = categorydesc.getText().toString();
                validateFoodItemCategory(name, desc);



            }
        });

        viewcategorybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddFoodItemCategory.this, ViewFoodItemCategory.class);
                startActivity(intent);
            }
        });


    }
    private boolean validateFoodItemCategory(String cname, String cdesc) {

        if (cname.length() == 0) {
            categoryname.requestFocus();
            categoryname.setError("Field Cannot Be empty");
            return false;
        } else if (!cname.matches("[a-zA-Z ]+$")) {
            categoryname.requestFocus();
            categoryname.setError("Enter Only Alphabetical Character");
            return false;
        } else if (cdesc.length() == 0) {
            categorydesc.requestFocus();
            categorydesc.setError("Field Cannot Be empty");
            return false;
        } else if (!cdesc.matches("[a-zA-Z ]+$")) {
            categorydesc.requestFocus();
            categorydesc.setError("Enter Only Alphabetical Character");
            return false;
        } else {

            DbHelper helper = new DbHelper(AddFoodItemCategory.this);
            helper.open();
            helper.addFoodItemCategory(new String[]{categoryname.getText().toString(), categorydesc.getText().toString()});
            helper.close();

            Toast.makeText(AddFoodItemCategory.this, "Food Item Category Added Sucessfully", Toast.LENGTH_SHORT).show();
            viewcategorybtn.setVisibility(View.VISIBLE);
            return true;
        }
    }
}