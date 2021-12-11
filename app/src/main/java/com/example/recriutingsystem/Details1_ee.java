package com.example.recriutingsystem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Details1_ee extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_ee);
        Bundle bundle1=getIntent().getExtras();
        String job=bundle1.getString("job");
        String salary =bundle1.getString("salary");
        String exe =bundle1.getString("exe");
        String degree =bundle1.getString("degree");
        String cname=bundle1.getString("cname");
        String location =bundle1.getString("location");
        TextView tv1 =(TextView)findViewById(R.id.job);
        TextView tv2 =(TextView)findViewById(R.id.salary);
        TextView tv3 =(TextView)findViewById(R.id.exe);
        TextView tv4 =(TextView)findViewById(R.id.degree);
        TextView tv5 =(TextView)findViewById(R.id.cname);
        TextView tv6 =(TextView)findViewById(R.id.location);
        tv1.setText(job);
        tv2.setText(salary);
        tv3.setText(exe);
        tv4.setText(degree);
        tv5.setText(cname);
        tv6.setText(location);
        Button btn =(Button)findViewById(R.id.communicate);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle =new Bundle();
                bundle.putString("name",cname);
                Intent intent =new Intent();
                intent.putExtras(bundle);
                intent.setClass(Details1_ee.this,MsgPage.class);
                startActivity(intent);
            }
        });
    }
}
