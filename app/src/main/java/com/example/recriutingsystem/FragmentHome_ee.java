package com.example.recriutingsystem;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.recriutingsystem.entity.Business;
import com.example.recriutingsystem.entity.Recruit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class FragmentHome_ee extends Fragment {
    private List<Recruit> rList;
    private List<Business> bList;
    private List<String> nameList;
    private List<String> cityList;
    private UserService userService;
    private static FragmentHome_ee mf;
    private ListView listView;
    private void init()
    {
        userService=UserService.getUserService();
        rList=userService.getRecruitList();
        bList=userService.getBusinessList();
        nameList=new ArrayList<String>();
        cityList=new ArrayList<String>();
        Log.d("BlistSize",Integer.toString(bList.size()));
        Log.d("RlistSize",Integer.toString(rList.size()));
        for(int i=0;i<rList.size();i++)
        {
            for(int j=0;j<bList.size();j++){
                if(rList.get(i).getUid()==bList.get(j).getUid())
                {
                    Log.d("Bname",bList.get(j).getBusinessName().trim());
                    nameList.add(bList.get(j).getBusinessName().trim());
                    cityList.add(bList.get(j).getCity().trim());
                    break;
                }
            }
        }


    }
    public static FragmentHome_ee getMessageFragment()
    {
        if(mf == null){
            mf = new FragmentHome_ee();
        }
        return mf;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        /*View view = inflater.inflate(R.layout.home_index ,container, false);
        return view;*/
            View view= inflater.inflate(R.layout.home_main_ee, container, false);
            init();
            listView = (ListView)view.findViewById(R.id.my_list);
            ImageButton btn =(ImageButton)view.findViewById(R.id.search_ee);
        EditText etContext=(EditText) view.findViewById(R.id.context);
        Log.d("message",etContext.getText().toString().trim());
        List<Map<String, Object>> list=getData();
        listView.setAdapter(new mainPage_ee.HomeListViewAdapter(getActivity(), list));
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle=new Bundle();
                Log.d("BundleSend",etContext.getText().toString().trim());
                bundle.putString("content",etContext.getText().toString().trim());
                mainPage_ee mainActivity =(mainPage_ee)getActivity();
                Intent intent =new Intent();
                intent.setClass(mainActivity,Searchee.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Bundle bundle = new Bundle();
                bundle.putString("job",rList.get(i).getJobName());
                bundle.putString("salary",rList.get(i).getSalaryOffer());
                bundle.putString("exe",rList.get(i).getExpRequire());
                bundle.putString("degree",rList.get(i).getDegree());
                bundle.putString("cname",nameList.get(i));
                bundle.putString("location",cityList.get(i));
                Intent intent =new Intent();
                intent.putExtras(bundle);
                mainPage_ee mcontext =(mainPage_ee)getActivity();
                intent.setClass(mcontext,Details_ee.class);
                startActivity(intent);
            }
        });

            return view;
    }
    public List<Map<String, Object>> getData(){
        List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();
        for (int i = 0; i <rList.size(); i++) {
            Map<String, Object> map=new HashMap<String, Object>();
            map.put("job",rList.get(i).getJobName().trim());
            map.put("salary",rList.get(i).getSalaryOffer().trim());
            map.put("exe",rList.get(i).getExpRequire().trim());
            map.put("degree", rList.get(i).getDegree().trim());
            map.put("cname", nameList.get(i).trim());
            map.put("location", cityList.get(i).trim());
            list.add(map);
        }
        return list;
    }


}
