package com.example.mezbaan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ViewFood extends AppCompatActivity {

    ListView viewFood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_food);


        viewFood = findViewById(R.id.ViewFood);

        registerForContextMenu(viewFood);

        DbHelper helper = new DbHelper(ViewFood.this);
        helper.open();
        Cursor c = helper.displayFoodItem();
        ArrayList<String> list = new ArrayList<>();
        while (c.moveToNext()){
            list.add(c.getString(0)+ "||" + c.getString(1) + "||" + c.getString(2)+ "||" + c.getString(3)+ "||" + c.getString(4));
        }
        c.close();
        helper.close();
        ArrayAdapter<String> arr = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,list);
        viewFood.setAdapter(arr);


    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu, menu);
    }
}


