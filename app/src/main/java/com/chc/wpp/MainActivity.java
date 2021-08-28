package com.chc.wpp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Pattern;


public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedPref;
    Button btn_login;
    private EditText email;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        sharedPref = getSharedPreferences("languagePref",Context.MODE_PRIVATE);
        String defaultValue = getResources().getString(R.string.defautllanguage);
        String language = sharedPref.getString(getString(R.string.language), defaultValue);
        super.onCreate(savedInstanceState);
        if(language.equals("pashto")){
            setContentView(R.layout.pashto_activity_main);
        }else if (language.equals("dari")){
            setContentView(R.layout.dari_activity_main);
        }
        else{
            setContentView(R.layout.english_activity_main);

        }


        email = findViewById(R.id.username);
        password = findViewById(R.id.password);
        btn_login = findViewById(R.id.btn_login);
        btn_login.setEnabled(false);
        //password = findViewById(R.id.password);



      /*  final EditText emailValidate = findViewById(R.id.username);
        String email = emailValidate.getText().toString().trim();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        Pattern pattern = Pattern.compile(emailPattern,Pattern.CASE_INSENSITIVE);



        emailValidate .addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {

                if (pattern.matcher(s).matches() && s.length() > 0)
                {

                    //Toast.makeText(getApplicationContext(),"valid email address",Toast.LENGTH_SHORT).show();
                    emailValidate.setError(null);
                    emailValidate.setFocusable(true);
                    btn_login.setEnabled(true);
                }
                else
                {
                    btn_login.setEnabled(false);
                   // Toast.makeText(getApplicationContext(),"Invalid email address",Toast.LENGTH_SHORT).show();
                    //or
                    emailValidate.setError("Please Enter a valid Email.");
                }
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // other stuffs
            }
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // other stuffs
            }
        });


        final EditText passwordValidate = findViewById(R.id.password);
        String password = emailValidate.getText().toString().trim();
        String passwordPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        Pattern patternPass = Pattern.compile(passwordPattern,Pattern.CASE_INSENSITIVE);



        emailValidate .addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {

                if (pattern.matcher(s).matches() && s.length() > 0)
                {

                    //Toast.makeText(getApplicationContext(),"valid email address",Toast.LENGTH_SHORT).show();
                    emailValidate.setError(null);
                    emailValidate.setFocusable(true);
                    btn_login.setEnabled(true);
                }
                else
                {
                    btn_login.setEnabled(false);
                    // Toast.makeText(getApplicationContext(),"Invalid email address",Toast.LENGTH_SHORT).show();
                    //or
                    emailValidate.setError("Please Enter a valid Email.");
                }
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // other stuffs
            }
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // other stuffs
            }
        });*/


        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                validateEmail();
            }
        });
        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
            validatePassword();
            if(validatePassword() && validateEmail()){
                btn_login.setEnabled(true);
            }

            }
        });


    }
    // defining our own password pattern
    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    "(?=.*[@#$%^&+=])" +     // at least 1 special character
                    "(?=\\S+$)" +            // no white spaces
                    ".{4,}" +                // at least 4 characters
                    "$");


    // Referencing email and password



    private boolean validateEmail() {

        // Extract input from EditText
        String emailInput = email.getText().toString().trim();

        // if the email input field is empty
        if (emailInput.isEmpty()) {
            email.setError("Field can not be empty");
            return false;
        }

        // Matching the input email to a predefined email pattern
        else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            email.setError("Please enter a valid email address");
            return false;
        } else {
            email.setError(null);
            return true;
        }
    }

    private boolean validatePassword() {
        String passwordInput = password.getText().toString().trim();
        // if password field is empty
        // it will display error message "Field can not be empty"
        if (passwordInput.isEmpty()) {
            password.setError("Field can not be empty");
            return false;
        }

        // if password does not matches to the pattern
        // it will display an error message "Password is too weak"
        /*else if (!PASSWORD_PATTERN.matcher(passwordInput).matches()) {
            password.setError("Password is too weak");
            return false;
        }*/ else {
            password.setError(null);
            return true;
        }
    }

    public void confirmInput(View v) {
        if (!validateEmail() | !validatePassword()) {
            return;
        }

        // if the email and password matches, a toast message
        // with email and password is displayed
        /*String input = "Email: " + email.getText().toString();
        input += "\n";
        input += "Password: " + password.getText().toString();
        Toast.makeText(this, input, Toast.LENGTH_SHORT).show();*/
    }





    public void login(View view) {
       Intent intent = new Intent(MainActivity.this,NewsActivity.class);
        startActivity(intent);
    }

    public void openSignUp(View view) {
        Intent intent = new Intent(MainActivity.this,SignUpActivity.class);
        startActivity(intent);
    }

    public void pashtoAsLanguage(View view) {
        sharedPref = getSharedPreferences("languagePref",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(getString(R.string.language), "pashto");
        editor.apply();
        editor.commit();
       Intent intent = new Intent(MainActivity.this,MainActivity.class);
       startActivity(intent);
       finish();
    }

    public void dariAsLanaguage(View view) {
        sharedPref = getSharedPreferences("languagePref",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(getString(R.string.language), "dari");
        editor.apply();
        editor.commit();
        Intent intent = new Intent(MainActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void englishAsLanguage(View view) {
        sharedPref = getSharedPreferences("languagePref",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(getString(R.string.language),"english" );
        editor.apply();
        editor.commit();
        Intent intent = new Intent(MainActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void openFogetPasswordActivity(View view) {
        Intent intent = new Intent(MainActivity.this,ForgetPasswordActivity.class);
        startActivity(intent);
    }
}