package com.example.recriutingsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ChangePsd_ee extends AppCompatActivity {
    private EditText et_now,et_new,et_new2;
    private Button btn_update;
    private String psd_now,psd_new,psd_new2;
    private UserService userService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_password_ee);
        userService=UserService.getUserService();
        Bundle bundle =getIntent().getExtras();
        int type=bundle.getInt("type");
        Log.d("type",Integer.toString(type));
        Button btn_cancle=(Button)findViewById(R.id.btn_cancel);
        EditText psdOld =(EditText)findViewById(R.id.psd_old);
        EditText psdNew =(EditText)findViewById(R.id.psd_new);
        EditText psdNew2=(EditText)findViewById(R.id.psd_new2);
        Button btn1=(Button)findViewById(R.id.btn_update_password);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Psdold",psdOld.getText().toString());
                String PsdOld = psdOld.getText().toString().trim();
                String PsdNew = psdNew.getText().toString().trim();
                String PsdNew2 = psdNew2.getText().toString().trim();
                Log.d("User",Integer.toString(userService.getUid()));
                String corrPwd=userService.getPassword().trim();
                Log.d("corrold",corrPwd);
                if(!corrPwd.equals(PsdOld))
                {
                    Toast toast=Toast.makeText(ChangePsd_ee.this,"原密码不正确",Toast.LENGTH_SHORT);
                    toast.show();
                    return;
                }
                if(!PsdNew.equals(PsdNew2)){

                    Toast toast=Toast.makeText(ChangePsd_ee.this,"两次输入密码不一致",Toast.LENGTH_SHORT);
                    toast.show();
                    return;
                }
                userService.alterUser(userService.getUid(),PsdNew);
                Toast toast=Toast.makeText(ChangePsd_ee.this,"修改成功请重新登录",Toast.LENGTH_SHORT);
                toast.show();
                Intent startMine=new Intent(ChangePsd_ee.this,MainActivity.class);
                startActivity(startMine);


            }
        });
        btn_cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(type==0){
                startActivity(new Intent(ChangePsd_ee.this,mainPage_ee.class));
                }
                else{
                    startActivity(new Intent(ChangePsd_ee.this,mainPage_er.class));
                }
            }
        });

    }


}
