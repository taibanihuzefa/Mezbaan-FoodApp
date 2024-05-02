package com.example.mezbaan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ViewFoodItemCategory extends AppCompatActivity {

    TextView viewcategoryname, viewcategorydesc;
    ListView viewfoodcategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_food_item_category);

        viewfoodcategory = findViewById(R.id.ViewFoodCategory);

        DbHelper helper = new DbHelper(ViewFoodItemCategory.this);

        helper.open();

        Cursor c = helper.displayFoodItemCategory();

        ArrayList<String> list = new ArrayList<>();
        while (c.moveToNext()){
            list.add(c.getString(0)+"||" + c.getString(1) + "||" + c.getString(2));
        }
        c.close();
        helper.close();
        ArrayAdapter<String> arr = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,list);
        viewfoodcategory.setAdapter(arr);

    }
}