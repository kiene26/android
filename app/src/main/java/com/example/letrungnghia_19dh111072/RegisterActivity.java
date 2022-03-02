package com.example.letrungnghia_19dh111072;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.regex.*;
public class RegisterActivity extends AppCompatActivity {

    EditText edtEmail, edtUsername, edtPassword, edtConfirm;
    Button btnSignIn, btnCancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        edtEmail = findViewById(R.id.editText);
        edtUsername = findViewById(R.id.editText2);
        edtPassword = findViewById(R.id.editText3);
        edtConfirm = findViewById(R.id.editText4);
        btnSignIn = findViewById(R.id.btnLogin);
        btnCancel = findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isValid(edtEmail.getText().toString())){
                    edtEmail.setError("Invalid Email Address");
                    return;
                }
                if(edtUsername.getText().toString().isEmpty()){
                    edtUsername.setError("Username cannot be null ");
                    return;
                }
                if(edtPassword.getText().toString().isEmpty()){
                    edtPassword.setError("Password required");
                    return;
                }
                if(edtConfirm.getText().toString().isEmpty()){
                    edtConfirm.setError("Password required");
                    return;
                }

                if(edtPassword.getText().toString().equals(edtConfirm.getText().toString()))
                {
                    SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putString("username",edtUsername.getText().toString());
                    editor.putString("password",edtPassword.getText().toString());
                    editor.apply();
                    Intent intent = new Intent(RegisterActivity.this,
                            LoginActivity.class);
                    intent.putExtra("username", edtUsername.getText().toString());
                    intent.putExtra("password", edtPassword.getText().toString());
                    intent.putExtra("email", edtEmail.getText().toString());
                    setResult(101, intent);
                    //startActivity(intent);
                    finish();
                }else {
                    edtPassword.setError("Password and confirm password does not match");
                            edtConfirm.setText("");
                    return;
                }
            }
        });
    }
    public static boolean isValid(String email)
    {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";
        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }
}