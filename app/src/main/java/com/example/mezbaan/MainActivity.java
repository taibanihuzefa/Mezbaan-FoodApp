package com.example.mezbaan;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

public class MainActivity extends AppCompatActivity {

    Button signin, signup;

    SharedPreferences sharedPreferences;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signin = findViewById(R.id.Signinbtn);
        signup = findViewById(R.id.Signupbtn);

        sharedPreferences = getSharedPreferences("mypref", MODE_PRIVATE);

        if (sharedPreferences.contains("Scontact") && sharedPreferences.contains("Spassword")) {
            i = new Intent(MainActivity.this, Index.class);
            startActivity(i);
        }

        StringRequest stringRequest=new StringRequest(Request.Method.POST, "", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){

        };


    }
    public void btnsignin(View view) {

        Intent signin = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(signin);
    }

    public void btnsignup(View view) {
        Intent signup = new Intent(MainActivity.this, RegisterActivity.class);
        startActivity(signup);
    }
}


