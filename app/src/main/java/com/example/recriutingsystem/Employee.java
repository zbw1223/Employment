package com.example.recriutingsystem;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.speech.RecognitionService;
import android.text.InputFilter;
import android.text.InputType;
import android.text.Spanned;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class Employee extends AppCompatActivity {
    private EditText birthday;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employee_register);
        UserService userService=UserService.getUserService();
        EditText edName=findViewById(R.id.name);
        EditText edSex=findViewById(R.id.sex);
        EditText edDegree=findViewById(R.id.degree);
        EditText edSchool=findViewById(R.id.school);
        EditText edExe=findViewById(R.id.exp);
        EditText edInter=findViewById(R.id.inter);
        EditText edCity=findViewById(R.id.city);
        EditText edSalary=findViewById(R.id.salary);
        EditText edMajor =findViewById(R.id.major);
        EditText edEmail =findViewById(R.id.email);
        Bundle bundle1=getIntent().getExtras();
        String userName =bundle1.getString("UseName");
        Button finishee=(Button)findViewById(R.id.finishee);
        birthday =(EditText)findViewById(R.id.bir);
        birthday.setInputType(InputType.TYPE_NULL);

//        ImageButton ibtn=(ImageButton)findViewById(R.id.back);
//        ibtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent =new Intent(Employee.this,Selecting.class);
//                startActivity(intent);
//            }
//        });
        finishee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=edName.getText().toString().trim();
                String sex=edSex.getText().toString().trim();
                String degree=(String)edDegree.getText().toString().trim();
                String school=edSchool.getText().toString().trim();
                String exe=edExe.getText().toString().trim();
                String inter=(String)edInter.getText().toString().trim();
                String city=edCity.getText().toString().trim();
                String salary=edSalary.getText().toString().trim();
                String major =edMajor.getText().toString().trim();
                String bir= birthday.getText().toString().trim();
                String email =edEmail.getText().toString().trim();
                int uid=bundle1.getInt("uid");
                userService.regSeeker(uid,name,sex,bir,exe,degree,school,major,inter,city,salary,email);
                startActivity(new Intent(Employee.this,MainActivity.class));
            }
        });
        birthday.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                // TODO Auto-generated method stub
                if(hasFocus){
                    showDatePickerDialog();
                }
            }
        });

        birthday.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                showDatePickerDialog();
            }
        });



    }

    /**
     * 展示日期选择对话框
     */

    private void showDatePickerDialog() {
        Calendar c = Calendar.getInstance();
        new DatePickerDialog(Employee.this, new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                // TODO Auto-generated method stub
                birthday.setText(year+"/"+(monthOfYear+1)+"/"+dayOfMonth);
            }
        }, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH)).show();

    }

}
