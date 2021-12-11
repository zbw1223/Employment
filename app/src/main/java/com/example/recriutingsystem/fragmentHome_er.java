package com.example.recriutingsystem;


import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;


import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class fragmentHome_er extends Fragment {
    private UserService userService;
    private List<JobSeeker> jList;
    private static fragmentHome_er mf;
    private ListView listView;

    private void init()
    {
        userService=UserService.getUserService();
        jList=userService.getJobSeekerList();
    }

    public static fragmentHome_er getMessageFragment()
    {
        if(mf == null){
            mf = new fragmentHome_er();
        }
        return mf;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.home_main_er, container, false);
        listView = (ListView)view.findViewById(R.id.listViewHome);
        init();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ImageButton btn =(ImageButton)view.findViewById(R.id.search_er);
        List<Map<String, Object>> list=getData();
        listView.setAdapter(new mainPage_er.HomeListAdapter(getActivity(), list));
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainPage_er mainActivity =(mainPage_er)getActivity();
                startActivity(new Intent(mainActivity,Searcher.class));
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Bundle bundle = new Bundle();
                bundle.putString("name_seeker",jList.get(i).getName().trim());
                bundle.putString("salary1",jList.get(i).getSalary().trim());
                bundle.putString("exp",jList.get(i).getExp().trim());
                bundle.putString("degree1",jList.get(i).getDegree().trim());
                bundle.putString("name_job",jList.get(i).getJob().trim());
                bundle.putString("location1",jList.get(i).getCity().trim());
                Intent intent =new Intent();
                intent.putExtras(bundle);
                mainPage_er mcontext =(mainPage_er)getActivity();
                intent.setClass(mcontext,Details_er.class);
                startActivity(intent);
            }
        });
        return view;
    }
    public List<Map<String, Object>> getData(){
        List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();
        for (int i = 0; i <jList.size(); i++) {
            Map<String, Object> map=new HashMap<String, Object>();
            map.put("name_seeker",jList.get(i).getName().trim());
            map.put("salary1", jList.get(i).getSalary().trim());
            map.put("location1",jList.get(i).getCity().trim());
            map.put("name_job",jList.get(i).getJob().trim());
            map.put("exp",jList.get(i).getExp().trim());
            map.put("degree1",jList.get(i).getDegree().trim());
            list.add(map);
        }
        return list;
    }
}

