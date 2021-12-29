package com.example.recriutingsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.recriutingsystem.entity.Users;

public class MainActivity extends AppCompatActivity {
    UserService userService=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        userService=UserService.getUserService();

        Button register = (Button) findViewById(R.id.register);
        Button login = (Button) findViewById(R.id.loginButton);
        EditText username=(EditText)findViewById(R.id.userName);
        EditText password=(EditText)findViewById(R.id.password);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, register.class));
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user =username.getText().toString().trim();
                String pw=password.getText().toString().trim();
                Users u=userService.Login(user,pw);
                if(u==null){
                    Toast toast=Toast.makeText(getApplicationContext(),"账号与密码不匹配",Toast.LENGTH_SHORT);
                    toast.show();
                }
                else if(u.getuType()==0){
                    startActivity(new Intent(MainActivity.this,mainPage_ee.class));
                }
                else{
                    startActivity(new Intent(MainActivity.this,mainPage_er.class));
                }
            }
        });
    }
}