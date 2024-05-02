package com.example.mezbaan;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText contactedt, passwordetd;
    Button loginButton;
    ProgressDialog progressDialog;

    private int submitCount = 0;
    private boolean limitExceeded = false;

    SharedPreferences sharedPreferences;
    Intent i;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // get references to UI elements
        contactedt = findViewById(R.id.LoginContNo);
        passwordetd = findViewById(R.id.LoginPassword);
        loginButton = findViewById(R.id.Loginbtn);

        //parctical 7.B
        // this code works like session, it checks whether the contact & password is stored in the session or not
        sharedPreferences = getSharedPreferences("mypref", MODE_PRIVATE);

        Animation animation = new AnimationUtils().loadAnimation(getApplicationContext(), R.anim.myanim);
        animation.start();



        // Get the data passed from the previous activity
        Intent extras = getIntent();

        String contactR = extras.getStringExtra("contact");
        String passwordR = extras.getStringExtra("password");

        // Set the values in the EditText
        contactedt.setText(contactR);
        passwordetd.setText(passwordR);





        loginButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // check if limit is exceeded
                if (limitExceeded) {
                    Toast.makeText(LoginActivity.this, "Limit exceeded. Please try again after 10 seconds.", Toast.LENGTH_LONG).show();
                    return;
                }

                // get input values
                String contact = contactedt.getText().toString();
                String password = passwordetd.getText().toString();

                // check if input values are valid
                if (contact.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Please Enter Contact No.", Toast.LENGTH_SHORT).show();
                } else if (password.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Please Enter Password.", Toast.LENGTH_SHORT).show();
                } else {
                    // check if input values match the expected values
                    if (contact.equals(contactR) && password.equals(passwordR)) {

                        //practical 7.B
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("Scontact", contact);
                        editor.putString("Spassword", password);
                        editor.commit();

                        myPogressDialog();

                        Toast.makeText(LoginActivity.this, "Login successful!", Toast.LENGTH_SHORT).show();
                        submitCount = 0; // reset submit count
                        limitExceeded = false; // reset limit exceeded flag

                    } else if(contact.equals("7769922209") && password.equals("Huzefa123")){

                        //practical 7.B
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("Scontact", contact);
                        editor.putString("Spassword", password);
                        editor.commit();

                        myPogressDialog();

                        Toast.makeText(LoginActivity.this, "Login successful!", Toast.LENGTH_SHORT).show();
                        submitCount = 0; // reset submit count
                        limitExceeded = false; // reset limit exceeded flag
                    }else {
                        Toast.makeText(LoginActivity.this, "Incorrect username or password.", Toast.LENGTH_SHORT).show();
                        submitCount++; // increment submit count
                        if (submitCount >= 3) {
                            limitExceeded = true; // set limit exceeded flag
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    limitExceeded = false; // reset limit exceeded flag after 30 seconds
                                }
                            }, 10000); // set delay for 10000 millisecond (10 second)
                        }
                    }
                }
            }
        });


    } // on create method end

    public void myPogressDialog(){
        //practical 6.B
        progressDialog = new ProgressDialog(LoginActivity.this);
        progressDialog.show();
        progressDialog.setContentView(R.layout.progress_dialog);
        progressDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                progressDialog.dismiss();
                Intent intent = new Intent(LoginActivity.this, Index.class);
                startActivity(intent);
                finish();
            }
        }, 2000);
    }

    public void SignupNow(View view) {
        Intent signupR = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(signupR);
    }
}