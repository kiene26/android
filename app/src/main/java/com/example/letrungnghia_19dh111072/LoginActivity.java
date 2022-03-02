package com.example.letrungnghia_19dh111072;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import java.util.regex.*;
import android.app.Dialog;
import androidx.annotation.Nullable;
public class LoginActivity extends AppCompatActivity {

    EditText edtUsername, edtPassword;
    String editEmail="";
    Button btnLogin, btnRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edtUsername = findViewById(R.id.editTextTextEmailAddress);
        edtPassword = findViewById(R.id.editTextTextPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtUsername.getText().toString().isEmpty() ||
                        edtPassword.getText().toString().isEmpty()){
                    Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                    startActivityForResult(intent,100);
                }else if(edtPassword.getText().toString().length() < 6){
                    edtPassword.setError("Minimum 6 number");
                }else if(!edtUsername.getText().toString().equals("admin"))
                {

                    edtUsername.setError("Invalid Username");
                }else if(!edtPassword.getText().toString().equals("123456"))
                {
                    edtPassword.setError("Invalid Password");
                }
                else
                {
                    Intent intent = new Intent(LoginActivity.this,
                            InfoActivity.class);
                    intent.putExtra("username", edtUsername.getText().toString());
                    intent.putExtra("password", edtPassword.getText().toString());
                    intent.putExtra("email", editEmail);
                    startActivity(intent);
                }

            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivityForResult(intent, 100);
            }
        });
    }
        @Override
        protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent
        data) {
            super.onActivityResult(requestCode, resultCode, data);
            if(requestCode == 100 && resultCode == 101){
                edtUsername.setText(data.getStringExtra("username"));
                edtPassword.setText(data.getStringExtra("password"));
                editEmail=data.getStringExtra("email");
            }

        }
}
