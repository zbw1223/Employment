package com.example.recriutingsystem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Selecting extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selecting);
        Button seek =(Button)findViewById(R.id.Seek);
        Button employ =(Button)findViewById(R.id.Employ);
        Bundle bundle1=getIntent().getExtras();
        UserService userService=UserService.getUserService();
        String userName=bundle1.getString("userName");
        String password =bundle1.getString("password");
        seek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int uid;
                uid=userService.register(userName,password,0);
                if(uid==0) {
                    Toast toast=Toast.makeText(Selecting.this,"账号已被注册！",Toast.LENGTH_SHORT);
                    toast.show();
                    return;
                }
                Bundle bundle =new Bundle();
                bundle.putString("userName",userName);
                bundle.putInt("uid",uid);
                Intent intent =new Intent();
                intent.putExtras(bundle);
                intent.setClass(Selecting.this,Employee.class);
                startActivity(intent);
            }
        });
        employ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int uid;
                uid=userService.register(userName,password,1);
                if(uid==0) {
                    Toast toast=Toast.makeText(Selecting.this,"账号已被注册！",Toast.LENGTH_SHORT);
                    toast.show();
                    return;
                }
                Bundle bundle =new Bundle();
                bundle.putString("userName",userName);
                bundle.putInt("uid",uid);
                Intent intent =new Intent();
                intent.putExtras(bundle);
                intent.setClass(Selecting.this,Employer.class);
                startActivity(intent);
            }
        });
        ImageButton back=(ImageButton) findViewById(R.id.btn_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Selecting.this,register.class);
                startActivity(intent);
            }
        });
    }
}
