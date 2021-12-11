package com.example.recriutingsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ChangePsd_er extends AppCompatActivity {
    private EditText et_now,et_new,et_new2;
    private Button btn_update;
    private String psd_now,psd_new,psd_new2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_password_er);
        Button btn_cancle=(Button)findViewById(R.id.btn_cancel);
        Button btn1=(Button)findViewById(R.id.btn_update_password) ;
        EditText psdOld =(EditText)findViewById(R.id.psd_old);
        EditText psdNew =(EditText)findViewById(R.id.psd_new);
        EditText psdNew2=(EditText)findViewById(R.id.psd_new2);
        btn_cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startMine=new Intent(ChangePsd_er.this,mainPage_er.class);
                startActivity(startMine);
            }
        });
       btn1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

           }
       });

    }


}
