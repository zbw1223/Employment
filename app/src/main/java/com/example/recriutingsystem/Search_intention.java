package com.example.recriutingsystem;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
public class Search_intention extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_intention);
        ImageButton ibtn =(ImageButton)findViewById(R.id.btn_back);
        TextView tv =(TextView)findViewById(R.id.save);
        ibtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Search_intention.this,mainPage_ee.class);
                startActivity(intent);
            }
        });
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flush(v);
            }
        });
    }
    public void flush(View view) {
        finish();
        Intent intent = new Intent(this, Search_intention.class);
        startActivity(intent);
    }
}
