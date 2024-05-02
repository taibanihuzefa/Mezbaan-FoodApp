package com.example.mezbaan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Index extends AppCompatActivity {

    SharedPreferences preferences;
    Intent intent;
    TextView head;
    ImageView view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

        head = findViewById(R.id.HeadingTxt);
        view = findViewById(R.id.mainlogo);

        view.setBackgroundResource(R.drawable.indexanimation);
        AnimationDrawable animationDrawable = (AnimationDrawable) view.getBackground();
        animationDrawable.start();



        preferences = getSharedPreferences("mypref", MODE_PRIVATE);
        head.setText("Hello, " + preferences.getString("Scontact", null));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //HomeMenu hm = new HomeMenu();
        getMenuInflater().inflate(R.menu.home_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.Dashboard){
            Intent d = new Intent(getApplicationContext(), Index.class);
            //startActivity(d);
        }else if (id == R.id.userprofile) {
            Intent u = new Intent(getApplicationContext(), Index.class);
            //startActivity(u);
        }else if (id == R.id.fooditem) {
            Intent fi = new Intent(getApplicationContext(), ViewFood.class);
            startActivity(fi);
        }else if (id == R.id.foodcategory) {
            Intent fc = new Intent(getApplicationContext(), ViewFoodItemCategory.class);
            startActivity(fc);
        }else if (id == R.id.customer) {
            Intent c = new Intent(getApplicationContext(), Index.class);
            //startActivity(c);
        }else if (id == R.id.Report) {
            Intent r = new Intent(getApplicationContext(), Index.class);
            //startActivity(r);
        }
        else if (id == R.id.Setting) {
            Intent s = new Intent(getApplicationContext(), SettingPreference.class);
            startActivity(s);
        }
        else if (id == R.id.placeorder) {
            Intent p = new Intent(getApplicationContext(), PlaceOrderInfo.class);
            startActivity(p);
        } else if (id == R.id.Logout) {
            showLogoutConfirmationDialog();

        }
        return super.onOptionsItemSelected(item);
    }
    private void showLogoutConfirmationDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Logout");
        builder.setMessage("Are you sure you want to logout?");

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Perform logout action here
                dialog.dismiss();
                SharedPreferences.Editor editor = preferences.edit();
                editor.clear();
                editor.commit();
                Intent l = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(l);
            }
        });
        builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }



    public void Profile(View view) {
        Intent profile = new Intent(Index.this, Index.class);
        //startActivity(profile);

    }

    public void FoodItemCategory(View view) {
        Intent fooditemcategory = new Intent(Index.this, FoodItemCategory.class);
        startActivity(fooditemcategory);
    }

    public void FoodItem(View view) {
        Intent fooditem = new Intent(Index.this, FoodItemInfo.class);
        startActivity(fooditem);
    }

    public void PlaceOrder(View view) {
        Intent placeorder = new Intent(Index.this, PlaceOrderOption.class);
        startActivity(placeorder);
    }

    public void ViewCustomers(View view) {
        Intent viewcustomers = new Intent(Index.this, CustomersInfo.class);
        startActivity(viewcustomers);
    }

    public void Reports(View view) {
        Intent reports = new Intent(Index.this, Index.class);
        //startActivity(reports);
    }
}