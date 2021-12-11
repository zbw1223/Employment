package com.example.recriutingsystem;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class information_er_change extends AppCompatActivity {
    private UserService userService;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.information_er_change);
        userService = UserService.userService;
        Button finisher=(Button)findViewById(R.id.finisher);
        ImageButton ibtn=(ImageButton)findViewById(R.id.btn_back);

        EditText etBname=(EditText)findViewById(R.id.bName);
        EditText etCity=(EditText)findViewById(R.id.city);
        EditText etIntroduce =(EditText)findViewById(R.id.introduce);
        EditText etEmail =(EditText)findViewById(R.id.email);
        etCity.setText(userService.theBusiness.getCity().trim());
        etBname.setText(userService.theBusiness.getBusinessName().trim());
        Log.d("Email",userService.theBusiness.getBusinessName());
        Log.d("Email",userService.theBusiness.getCity());
        Log.d("Email",userService.theBusiness.getIntroduce());
        etIntroduce.setText(userService.theBusiness.getIntroduce().trim());
        Log.d("Email",userService.theBusiness.getEmail());
        etEmail.setText(userService.theBusiness.getEmail().trim());
        ibtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(information_er_change.this,mainPage_er.class);
                startActivity(intent);
            }
        });
        finisher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String bName=etBname.getText().toString().trim();
                String city=etCity.getText().toString().trim();
                String introduce=etIntroduce.getText().toString().trim();
                String email=etEmail.getText().toString().trim();
                int uid=userService.theBusiness.getUid();
                userService.alterBusiness(uid,bName,city,introduce,email);
                Toast.makeText(information_er_change.this,"修改成功",Toast.LENGTH_LONG).show();
                startActivity(new Intent(information_er_change.this,mainPage_er.class));
            }
        });
    }
}
