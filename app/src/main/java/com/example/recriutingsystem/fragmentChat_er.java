package com.example.recriutingsystem;


import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class fragmentChat_er extends Fragment {
    private static fragmentChat_er mf;
    private ListView listView;
    private String[] name={"张三","李四","王五","赵六","钱七","秦八","周九","孙十"};
    private String[] time={"10:30","11:20","12:10","13:50","14:35","8:20","9:30","16:55"};

    public static fragmentChat_er getMessageFragment() {
        if (mf == null) {
            mf = new fragmentChat_er();
        }
        return mf;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.chat_main_er, container, false);
        listView = (ListView) view.findViewById(R.id.listViewChat);
        List<Map<String, Object>> list = getData();
        listView.setAdapter(new mainPage_er.ChatListAdapter(getActivity(), list));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Bundle bundle = new Bundle();
                bundle.putString("name",name[i]);
                bundle.putString("destination",Integer.toString(i));
                Intent intent =new Intent();
                intent.putExtras(bundle);
                mainPage_er mcontext =(mainPage_er)getActivity();
                intent.setClass(mcontext,MsgPage.class);
                startActivity(intent);
            }
        });

        return view;
    }


    public List<Map<String, Object>> getData() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        for (int i = 0; i <8; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            //  map.put("image",);
            map.put("title", name[i]);
            map.put("time", time[i]);
            list.add(map);
        }
        return list;
    }
}