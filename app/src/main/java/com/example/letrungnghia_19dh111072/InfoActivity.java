package com.example.letrungnghia_19dh111072;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.RadioGroup;

public class InfoActivity extends AppCompatActivity {
    EditText edtName, edtEmail, edtPass, edtUsername;
    RadioGroup rdbGender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        Intent intent = getIntent();
        edtEmail = findViewById(R.id.edtEmail);
        //edtEmail.setInputType(InputType.TYPE_NULL);edtEmail.setTextColor(Color.BLACK);
        edtUsername = findViewById(R.id.edtUsername);
        edtUsername.setInputType(InputType.TYPE_NULL);edtEmail.setTextColor(Color.BLACK);
        edtPass = findViewById(R.id.edtPass);
        edtPass.setInputType(InputType.TYPE_NULL);edtEmail.setTextColor(Color.BLACK);
        String username = intent.getStringExtra("username");
        String password = intent.getStringExtra("password");
        String email = intent.getStringExtra("email");
        getSupportActionBar().setTitle("Account Info");
        edtUsername.setText(username);
        edtEmail.setText(email);
        edtPass.setText(password);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.option_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
        public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.mnuSave){
        }
        return super.onOptionsItemSelected(item);
    }
}