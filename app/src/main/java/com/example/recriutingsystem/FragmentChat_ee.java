package com.example.recriutingsystem;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import  android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FragmentChat_ee extends  Fragment{
    private static FragmentChat_ee mf;
    private ListView listView;
    private String[] company={"熊","鹰","龙","虎","豹","蛇","狗","虎"};
    private String[] time={"10:30","11:20","12:10","13:50","14:35","8:20","9:30","16:55"};
    public static FragmentChat_ee getMessageFragment()
    {
        if(mf == null){
            mf = new FragmentChat_ee();
        }
        return mf;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.chat_main_ee, container, false);
        listView = (ListView) view.findViewById(R.id.listViewChat1);
        List<Map<String, Object>> list = getData();
        listView.setAdapter(new mainPage_ee.ChatListViewAdapter(getActivity(), list));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Bundle bundle = new Bundle();
                bundle.putString("name",company[i]);
                Intent intent =new Intent();
                intent.putExtras(bundle);
                mainPage_ee mcontext =(mainPage_ee)getActivity();
                intent.setClass(mcontext,MsgPage.class);
                startActivity(intent);
            }
        });
        return view;
    }
    public List<Map<String, Object>> getData() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < 8; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            //  map.put("image",);
            map.put("title1",company[i]);
            map.put("time1",time[i]);
            list.add(map);
        }
        return list;
    }
}
