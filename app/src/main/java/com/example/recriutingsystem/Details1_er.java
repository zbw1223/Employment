package com.example.recriutingsystem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Details1_er extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_er);
        Bundle bundle1=getIntent().getExtras();
        String name_seeker=bundle1.getString("name_seeker");
        String salary1 =bundle1.getString("salary1");
        String exp =bundle1.getString("exp");
        String degree1 =bundle1.getString("degree1");
        String name_job=bundle1.getString("name_job");
        String location1 =bundle1.getString("location1");
        TextView tv1 =(TextView)findViewById(R.id.name_seeker);
        TextView tv2 =(TextView)findViewById(R.id.salary1);
        TextView tv3 =(TextView)findViewById(R.id.exp);
        TextView tv4 =(TextView)findViewById(R.id.degree1);
        TextView tv5 =(TextView)findViewById(R.id.name_job);
        TextView tv6 =(TextView)findViewById(R.id.location1);
        tv1.setText(name_seeker);
        tv2.setText(salary1);
        tv3.setText(exp);
        tv4.setText(degree1);
        tv5.setText(name_job);
        tv6.setText(location1);
        Button btn =(Button)findViewById(R.id.communicate);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle =new Bundle();
                bundle.putString("name",name_job);
                Intent intent =new Intent();
                intent.putExtras(bundle);
                intent.setClass(Details1_er.this,MsgPage.class);
                startActivity(intent);
            }
        });
    }
}