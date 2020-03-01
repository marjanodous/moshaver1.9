package com.example.hoquqi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hoquqi.model.SharedPreferencesManager;
import com.example.hoquqi.model.userApp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class ActivitySignup extends AppCompatActivity {

    /*controls SharedPreferencesManager class*/
    userApp user = new userApp();

    /*create object for xml*/
    Button btnSingUp;
    EditText edtUName, edtPasword, emailValidate, edtPhone;
    TextView txtGoToLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        /* Get object from xml file*/
        btnSingUp = findViewById(R.id.ok_sing_up);
        edtUName = findViewById(R.id.edtunamesingup);
        edtPasword = findViewById(R.id.edtpnamesingup);
        emailValidate = findViewById(R.id.edtemailsingup);
        edtPhone = findViewById(R.id.edtphonesingup);
        txtGoToLogin = findViewById(R.id.txtgotologin);

        /*2.back to Activitylogin*/
        txtGoToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ActivitySignup.this, ActivityLogin.class));
                ActivitySignup.this.finish();
            }
        });

        /*click to save user data and go to ActivityMain*/
        btnSingUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /*1.set true first time to SharedPreferences*/
                final SharedPreferencesManager sharedPreferencesManager = new SharedPreferencesManager(getApplicationContext());
                user = sharedPreferencesManager.get_shared_preferences();
                user.setFirst_time_run(true);
                sharedPreferencesManager.set_false_first_time(user);

                /*3.get value user write to edit text*/
                String userName = edtUName.getText().toString();
                String password = edtPasword.getText().toString();
                String email = emailValidate.getText().toString();
                String phone = edtPhone.getText().toString();

                /*4.check edit text is empty or no*/
                if (!userName.equals("") && !password.equals("") && isEmailValid(email)==true && !phone.equals("")) {

                    /*5.Save UserName with SharedPreferences*/
                    SharedPreferences userDetails = getApplicationContext().getSharedPreferences("User", MODE_PRIVATE);
                    SharedPreferences.Editor edit = userDetails.edit();
                    edit.putString(userName, userName);
                    edit.putString(password, password);
                    edit.apply();

                    SharedPreferences userDetails2 = getApplicationContext().getSharedPreferences("TITLE", MODE_PRIVATE);
                    SharedPreferences.Editor edit2 = userDetails2.edit();
                    edit2.putString("title", userName);
                    edit2.apply();

                    /*6.open main activity*/
                    startActivity(new Intent(ActivitySignup.this, MainActivity.class));
                    ActivitySignup.this.finish();

                    /*7.set false More than once to SharedPreferences*/
                    user.setFirst_time_run(false);
                    sharedPreferencesManager.set_false_first_time(user);
                }
                else {
                    if (!isEmailValid(email)==true) {
                        Toast.makeText(getApplicationContext(), "الگوی ایمیل اشتباه است! ", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(ActivitySignup.this, "لطفا اطلاعات را کامل کنید!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
    /*method to return email is valid or no*/
    public static boolean isEmailValid(String email) {
        boolean isValid = false;
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        CharSequence inputStr = email;
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        if (matcher.matches()) {
            isValid = true;
        }
        return isValid;
    }
    //======================change font===============================
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
