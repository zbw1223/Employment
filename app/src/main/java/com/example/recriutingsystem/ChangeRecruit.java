/*package com.example.recriutingsystem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class ChangeRecruit   extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.changerecuit);
        Bundle bundle=getIntent().getExtras();
        String jobname=bundle.getString("job");
        ImageButton ibtn =(ImageButton)findViewById(R.id.btn_back);
        Button change =(Button)findViewById(R.id.change);
        EditText edjobName=(EditText)findViewById(R.id.jobName);
        EditText edjobDescription=(EditText)findViewById(R.id.jobDescription);
        EditText edWorkcity=(EditText)findViewById(R.id.workCity);
        EditText edDegree =(EditText)findViewById(R.id.degree);
        EditText edexpRequire=(EditText)findViewById(R.id.expRequire);
        EditText edsalary=(EditText)findViewById(R.id.salary) ;
        EditText edNumber =(EditText)findViewById(R.id.number);
        EditText edEmail=(EditText)findViewById(R.id.email);
        edjobName.setText(jobname);
        change.setOnClickListener(new View.OnClickListener() {
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
            }
        });
        ibtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChangeRecruit.this,mainPage_er.class));
            }
        });
    }
}
*/