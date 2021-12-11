package com.example.recriutingsystem;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.List;
import java.util.Map;


public class PositionEditAdapter extends SimpleAdapter {
    Context context;

    public PositionEditAdapter(Context context, List<? extends Map<String, ?>> data, int resource, String[] from, int[] to) {
        super(context, data, resource, from, to);
        this.context = context;
    }

    @Override
    public View getView(final int i, View convertView, ViewGroup viewGroup) {
        View view = super.getView(i, convertView, viewGroup);
        final Button btn1 = (Button) view.findViewById(R.id.position_change);
        final Button btn2=(Button)view.findViewById(R.id.position_delete);
       // btn1.setTag(i);//设置标签
        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(context.getApplicationContext(), "更改" , Toast.LENGTH_SHORT).show();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(context.getApplicationContext(), "删除" , Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}


