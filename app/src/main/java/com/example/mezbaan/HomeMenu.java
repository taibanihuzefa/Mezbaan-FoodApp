package com.example.mezbaan;

import android.app.Activity;
import android.content.Intent;
import android.view.MenuItem;

import androidx.annotation.NonNull;

public class HomeMenu extends Activity {

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

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
        }else if (id == R.id.Setting) {
            Intent s = new Intent(getApplicationContext(), Index.class);
            //startActivity(s);
        }else if (id == R.id.placeorder) {
            Intent p = new Intent(getApplicationContext(), PlaceOrderInfo.class);
            startActivity(p);
        } else if (id == R.id.Logout) {
            Intent l = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(l);
        }
        return super.onOptionsItemSelected(item);
    }

}
