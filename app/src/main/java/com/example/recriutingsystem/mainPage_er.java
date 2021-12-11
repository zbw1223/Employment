package com.example.recriutingsystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

public class mainPage_er extends AppCompatActivity {
    private RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainpage_er);


        rg=findViewById(R.id.main_bottom_tabs);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                for (int i = 0;i<rg.getChildCount();i++){
                    RadioButton rb = (RadioButton)group.getChildAt(i);
                    if(rb.isChecked()){
                        setIndexSelected(i);
                        break;
                    }
                }
            }
        });
        setIndexSelected(0);
    }

    //开启事务，加载fragment布局
    private void changeFragment(Fragment fragment)
    {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.main_content , fragment);
        transaction.commit();
    }

    //通过index判断当前加载哪个界面
    public void setIndexSelected(int index)
    {
        switch (index)
        {
            case 0:
                changeFragment(new fragmentHome_er());
                break;
            case 1:
                changeFragment(new fragmentChat_er());
                break;
            case 2:
                changeFragment(new fragmentMine_er());
                break;
            default:
                break;
        }
    }

    //主页listview布局
    static class HomeListAdapter extends BaseAdapter{
        private List<Map<String, Object>> data;
        private LayoutInflater layoutInflater;
        private Context context;
        public HomeListAdapter(Context context,List<Map<String, Object>> data){
            this.context=context;
            this.data=data;
            this.layoutInflater=LayoutInflater.from(context);
        }

        /**
         * 组件集合，对应list.xml中的控件
         */
        public final class Zujian{
            public TextView name_seeker;

            public TextView salary1;
            public TextView exp;
            public TextView degree1;
            public TextView name_job;
            public TextView location1;
        }

        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public Object getItem(int position) {
            return data.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Zujian zujian=null;
            if(convertView==null){
                zujian=new Zujian();
                //获得组件，实例化组件
                convertView=layoutInflater.inflate(R.layout.homelistview_er, null);
                zujian.name_seeker=(TextView)convertView.findViewById(R.id.name_seeker) ;
                zujian.degree1=(TextView)convertView.findViewById(R.id.degree1);
                zujian.exp=(TextView) convertView.findViewById(R.id.exp);
                zujian.salary1=(TextView)convertView.findViewById(R.id.salary1);
                zujian.name_job=(TextView)convertView.findViewById(R.id.name_job);
                zujian.location1=(TextView)convertView.findViewById(R.id.location1);
                convertView.setTag(zujian);
            }else{
                zujian=(Zujian)convertView.getTag();
            }
            //绑定数据
            zujian.name_seeker.setText((String)data.get(position).get("name_seeker"));
            zujian.degree1.setText((String)data.get(position).get("degree1"));
            zujian.exp.setText((String)data.get(position).get("exp"));
            zujian.salary1.setText((String)data.get(position).get("salary1"));
            zujian.name_job.setText((String)data.get(position).get("name_job"));
            zujian.location1.setText((String)data.get(position).get("location1"));
            return convertView;
        }
    }
    //聊天listview布局
    static class ChatListAdapter extends BaseAdapter{
        private List<Map<String, Object>> data;
        private LayoutInflater layoutInflater;
        private Context context;
        public ChatListAdapter(Context context,List<Map<String, Object>> data){
            this.context=context;
            this.data=data;
            this.layoutInflater=LayoutInflater.from(context);
        }

        /**
         * 组件集合，对应list.xml中的控件
         */
        public final class Zujian{
            public TextView title;
            public TextView time;
        }

        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public Object getItem(int position) {
            return data.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Zujian zujian=null;
            if(convertView==null){
                zujian=new Zujian();
                //获得组件，实例化组件
                convertView=layoutInflater.inflate(R.layout.chatlistview_er, null);
                zujian.title=(TextView)convertView.findViewById(R.id.title);
                zujian.time=(TextView)convertView.findViewById(R.id.time);
                convertView.setTag(zujian);
            }else{
                zujian=(Zujian)convertView.getTag();
            }
            //绑定数据
            zujian.title.setText((String)data.get(position).get("title"));
            zujian.time.setText((String)data.get(position).get("time"));
            return convertView;
        }
    }
}


