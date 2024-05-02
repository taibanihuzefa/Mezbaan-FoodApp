package com.example.mezbaan;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.Calendar;

public class RegisterActivity extends AppCompatActivity {

    EditText fullNameedt, emailedt, contactNumberedt, passwordetd, confirmPasswordedt, dobedt;
    RadioGroup genderRadioGroup;
    RadioButton maleRadioButton, femaleRadioButton;
    Button registerButton, resetButton;
    ImageView btndate;
    int mDay, mMonth, mYear;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        fullNameedt = findViewById(R.id.RegisFullname);
        emailedt = findViewById(R.id.RegisEmail);
        contactNumberedt = findViewById(R.id.RegisContNo);
        passwordetd = findViewById(R.id.RegisPassword);
        confirmPasswordedt = findViewById(R.id.RegisCpassword);
        dobedt = findViewById(R.id.RegisDOB);

        genderRadioGroup = findViewById(R.id.RegisRadioGroup);

        maleRadioButton = findViewById(R.id.RGValueMale);
        femaleRadioButton = findViewById(R.id.RGValueFemale);

        registerButton = findViewById(R.id.btnRegister);
        resetButton = findViewById(R.id.btnReset);

        btndate = findViewById(R.id.btnDate);


        //date picker control click listner
        btndate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar c = Calendar.getInstance();
                mDay = c.get(Calendar.DAY_OF_MONTH);
                mMonth = c.get(Calendar.MONTH);
                mYear = c.get(Calendar.YEAR);
                DatePickerDialog datePickerDialog = new DatePickerDialog(RegisterActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                        dobedt.setText(year + "-" + (month + 1) + "-" + dayOfMonth);
                    }
                }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });


        //reset buuton click control start
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fullNameedt.setText("");
                emailedt.setText("");
                contactNumberedt.setText("");
                maleRadioButton.setChecked(false);
                dobedt.setText("");
                passwordetd.setText("");
                confirmPasswordedt.setText("");
            }
        });


        //click listner of register button start
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Fname = fullNameedt.getText().toString();
                String Email = emailedt.getText().toString();
                String ContactNum = contactNumberedt.getText().toString();
                String Date = dobedt.getText().toString();
                String Pass = passwordetd.getText().toString();
                String ConPass = confirmPasswordedt.getText().toString();
                int Gender = genderRadioGroup.getCheckedRadioButtonId();
                validateinfo(Gender, Fname, Email, ContactNum, Date, Pass, ConPass);
            }
        }); //click listner of register button end


    } // on create method close


    // VALIDATION CODE START:
    private Boolean validateinfo(int Gender, String fname, String email, String ContactNum, String Date, String pass, String conPass) {


        if (fname.length() == 0) {
            fullNameedt.requestFocus();
            fullNameedt.setError("Field Cannot Be empty");
            return false;
        } else if (!fname.matches("[a-zA-Z ]+$")) {
            fullNameedt.requestFocus();
            fullNameedt.setError("Enter Only Alphabetical Character");
            return false;
        }

        if (email.length() == 0) {
            emailedt.requestFocus();
            emailedt.setError("Field Cannot Be Empty");
            return false;
        } else if (!email.matches("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+")) {
            emailedt.requestFocus();
            emailedt.setError("Enter Proper Email ID like 'XYZ@gmail.com' ");
            return false;
        }

        if (ContactNum.length() == 0) {
            contactNumberedt.requestFocus();
            contactNumberedt.setError("Please Enter Phone Number");
            return false;
        } else if (!ContactNum.matches("^[0-9]{10}$")) {
            contactNumberedt.requestFocus();
            contactNumberedt.setError("Please Enter Valid Phone Number");
            return false;
        }

        if (Gender == -1) {
            Toast.makeText(RegisterActivity.this, "Please Select Gender", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (Date.length() == 0) {
            dobedt.requestFocus();
            dobedt.setError("Please Select Date");
            return false;
        }

        if (pass.length() == 0) {
            passwordetd.requestFocus();
            passwordetd.setError("Enter Password");
            return false;
        } else if (!pass.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$")) {
            passwordetd.requestFocus();
            passwordetd.setError("Password Must Have At Least One Uppercase letter, One Lowercase Letter, One Digit, And Be At Least 8 characters long");
            return false;
        }

        if (conPass.length() == 0) {
            confirmPasswordedt.requestFocus();
            confirmPasswordedt.setError("Please Enter Confirm Password");
            return false;

        } else if (!conPass.equals(pass)) {
            confirmPasswordedt.requestFocus();
            confirmPasswordedt.setError("Password Not Matched");
            return false;
        } else {
            Intent RClick = new Intent(RegisterActivity.this, LoginActivity.class);
            RClick.putExtra("contact", ContactNum);
            RClick.putExtra("password", pass);
            startActivity(RClick);
            Toast.makeText(RegisterActivity.this, "Registration Successful", Toast.LENGTH_LONG).show();

            return true;
        }
    }// VALIDATION CODE END:

    public void SignInNow(View view) {
        Intent signinR = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(signinR);
    }


}












