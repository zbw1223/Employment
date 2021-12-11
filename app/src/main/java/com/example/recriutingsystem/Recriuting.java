package com.example.recriutingsystem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Recriuting extends AppCompatActivity {
    UserService userService;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recruiting);
        userService=UserService.getUserService();
        ImageButton ibtn =(ImageButton)findViewById(R.id.btn_back);
        Button put =(Button)findViewById(R.id.put);
        EditText edjobName=(EditText)findViewById(R.id.jobName);
        EditText edjobDescription=(EditText)findViewById(R.id.jobDescription);
        EditText edWorkcity=(EditText)findViewById(R.id.workCity);
        EditText edDegree =(EditText)findViewById(R.id.degree);
        EditText edexpRequire=(EditText)findViewById(R.id.expRequire);
        EditText edsalary=(EditText)findViewById(R.id.salary) ;
        EditText edNumber =(EditText)findViewById(R.id.number);
        EditText edEmail=(EditText)findViewById(R.id.email);
        put.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String jobName=edjobName.getText().toString().trim();
                String jobDescription=edjobDescription.getText().toString().trim();
                String workCity=edWorkcity.getText().toString().trim();
                String expRequire=edexpRequire.getText().toString().trim();
                String degree=edDegree.getText().toString().trim();
                String salary=edsalary.getText().toString().trim();
                String number=edNumber.getText().toString().trim();
                String email=edEmail.getText().toString().trim();
                int uid=userService.getUid();
                userService.postRecruit(uid,jobName,jobDescription,workCity,degree,expRequire,salary,number,email);
                startActivity(new Intent(Recriuting.this,mainPage_er.class));
            }
        });
        ibtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Recriuting.this,mainPage_er.class);
                startActivity(intent);
            }
        });
    }
    public void flush(View view) {
        finish();
        Intent intent = new Intent(this, Recriuting.class);
        startActivity(intent);
    }

}
