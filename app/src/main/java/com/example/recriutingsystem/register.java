package com.example.recriutingsystem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class register extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        Button btn =(Button)findViewById(R.id.loginButton);
        Button btn1 =(Button)findViewById(R.id.next);
        EditText edUserName=findViewById(R.id.userName);
        EditText edUserPw=findViewById(R.id.password);
        EditText edUserRPw=findViewById(R.id.rPassword);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(register.this,MainActivity.class));
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName=edUserName.getText().toString().trim();
                String password=edUserPw.getText().toString().trim();
                String rPassword=edUserRPw.getText().toString().trim();
                if(!password.equals(rPassword))
                {
                    Toast toast=Toast.makeText(register.this,"两次输入密码不一致",Toast.LENGTH_SHORT);
                    toast.show();
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putString("userName",userName);
                bundle.putString("password",password);
                Intent intent =new Intent();
                intent.putExtras(bundle);
                intent.setClass(register.this,Selecting.class);
                startActivity(intent);
            }
        });
    }
}

