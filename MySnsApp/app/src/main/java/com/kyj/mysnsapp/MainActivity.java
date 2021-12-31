package com.kyj.mysnsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView id_text, pwd_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        id_text = findViewById(R.id.id_text);
        pwd_text = findViewById(R.id.pwd_text);


        Intent intent = getIntent();
        String UserID = intent.getStringExtra("UserID");
        String UserPwd = intent.getStringExtra("UserPwd");

        id_text.setText(UserID);
        pwd_text.setText(UserPwd);

    }
}