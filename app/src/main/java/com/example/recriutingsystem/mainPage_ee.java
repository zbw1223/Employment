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
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.List;
import java.util.Map;


public class mainPage_ee extends AppCompatActivity {
    private RadioGroup rg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainpage_ee);
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
    private void changeFragment(Fragment fragment)
    {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.main_content , fragment);
        transaction.commit();
    }
    public void setIndexSelected(int index)
    {
        switch (index)
        {
            case 0:
                changeFragment(new FragmentHome_ee());
                break;
            case 1:
                changeFragment(new FragmentChat_ee());
                break;
            case 2:
                changeFragment(new FragmentMine_ee());
                break;
            default:
                break;
        }
    }
    static class HomeListViewAdapter extends BaseAdapter {
        private List<Map<String, Object>> data;
        private LayoutInflater layoutInflater;
        private Context context;
        public HomeListViewAdapter(Context context,List<Map<String, Object>> data){
            this.context=context;
            this.data=data;
            this.layoutInflater=LayoutInflater.from(context);
        }
        /**
         * 组件集合，对应list.xml中的控件
         * @author Administrator
         */
        public final class Zujian{
            ;
            public TextView job;

            public TextView salary;
            public TextView exe;
            public TextView degree;
            public TextView cname;
            public TextView location;
        }
        @Override
        public int getCount() {
            return data.size();
        }
        /**
         * 获得某一位置的数据
         */
        @Override
        public Object getItem(int position) {
            return data.get(position);
        }
        /**
         * 获得唯一标识
         */
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
                convertView=layoutInflater.inflate(R.layout.homelistview_ee, null);
                zujian.job=(TextView)convertView.findViewById(R.id.job);
                zujian.salary=(TextView)convertView.findViewById(R.id.salary);
                zujian.exe=(TextView)convertView.findViewById(R.id.exe);
                zujian.degree=(TextView)convertView.findViewById(R.id.degree);
                zujian.cname=(TextView)convertView.findViewById(R.id.cname);
                zujian.location=(TextView)convertView.findViewById(R.id.location);
                convertView.setTag(zujian);
            }else{
                zujian=(Zujian)convertView.getTag();
            }
            //绑定数据
            //zujian.image.setBackgroundResource((Integer)data.get(position).get("image"));
            zujian.job.setText((String)data.get(position).get("job"));
            zujian.salary.setText((String)data.get(position).get("salary"));
            zujian.exe.setText((String)data.get(position).get("exe"));
            zujian.degree.setText((String)data.get(position).get("degree"));
            zujian.cname.setText((String)data.get(position).get("cname"));
            zujian.location.setText((String)data.get(position).get("location"));
            return convertView;
        }

    }
    static class ChatListViewAdapter extends BaseAdapter{
        private List<Map<String, Object>> data;
        private LayoutInflater layoutInflater;
        private Context context;
        public ChatListViewAdapter(Context context,List<Map<String, Object>> data){
            this.context=context;
            this.data=data;
            this.layoutInflater=LayoutInflater.from(context);
        }

        /**
         * 组件集合，对应list.xml中的控件
         */
        public final class Zujian{
            public TextView title1;
            public TextView time1;
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
                convertView=layoutInflater.inflate(R.layout.chatlistview_ee, null);
                zujian.title1=(TextView)convertView.findViewById(R.id.title1);
                zujian.time1=(TextView)convertView.findViewById(R.id.time1);
                convertView.setTag(zujian);
            }else{
                zujian=(Zujian)convertView.getTag();
            }
            //绑定数据
            zujian.title1.setText((String)data.get(position).get("title1"));
            zujian.time1.setText((String)data.get(position).get("time1"));
            return convertView;
        }
    }



}

