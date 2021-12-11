package com.example.recriutingsystem;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Employer extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employer_register);
        UserService userService=UserService.getUserService();
        Button finisher=(Button)findViewById(R.id.finisher);
        ImageButton ibtn=(ImageButton)findViewById(R.id.btn_back);
        EditText edBname=findViewById(R.id.bname);
        EditText edCity=findViewById(R.id.city);
        EditText edIntroduce=findViewById(R.id.introduce);
        EditText edEmail=findViewById(R.id.email);
        Bundle bundle1=getIntent().getExtras();
        int uid=bundle1.getInt("uid");
        ibtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Employer.this,Selecting.class);
                startActivity(intent);
            }
        });
        finisher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String bName=edBname.getText().toString().trim();
                String city=edCity.getText().toString().trim();
                String introduce=edIntroduce.getText().toString().trim();
                String email=edEmail.getText().toString().trim();
                userService.regBusiness(uid,bName,city,introduce,email);
                startActivity(new Intent(Employer.this,MainActivity.class));
            }
        });
    }
}
