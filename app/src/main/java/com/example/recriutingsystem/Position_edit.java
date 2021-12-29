package com.example.recriutingsystem;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.recriutingsystem.entity.Recruit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Position_edit extends AppCompatActivity {
    private UserService userService;
    private String []Job={"123","123","1234"};
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.position_edit);
        userService=UserService.getUserService();
        ListView listview = (ListView) findViewById(R.id.position);
        PositionEditAdapter adapter = new PositionEditAdapter(this,getData(),R.layout.position_edit_listview,
                new String[]{ "position_name","position_delete"},
                new int[]{ R.id.position_name, R.id.position_delete});
        listview.setAdapter(adapter);
//        listview.setOnItemClickListener(new AdapterView.OnItemClickListener(){
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Bundle bundle = new Bundle();
//                List<Recruit> rList=userService.getRecruitList();
//                bundle.putString("job",rList.get(i).getJobName());
//                Log.d("name",Job[i]);
//                Intent intent =new Intent();
//                intent.putExtras(bundle);
//                intent.setClass(Position_edit.this,ChangeRecruit.class);
//                startActivity(intent);
//            }
//        });
        ImageButton imageButton=(ImageButton)findViewById(R.id.edit_back);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Position_edit.this,mainPage_er.class);
                startActivity(intent);
            }
        });
    }
    public List<Map<String, Object>> getData(){
        List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();
        List<Recruit> rList=userService.getRecruitList();

        for (int i = 0; i <rList.size(); i++) {
            Map<String, Object> map=new HashMap<String, Object>();
            Log.d("list","job="+rList.get(i).getJobName());
            map.put("position_name", rList.get(i).getJobName());
            list.add(map);
        }
        return list;
    }

}
