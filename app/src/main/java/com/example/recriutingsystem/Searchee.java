package com.example.recriutingsystem;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.recriutingsystem.entity.Recruit;

import java.util.List;

public class Searchee extends AppCompatActivity {
    private String[] job1={"Java工程师","后端开发","前端开发","游戏设计","pyhton工程师","产品经理","移动开发","项目管理"};
    private String[] salary1={"1800元","2000","3000","4000","5000","6000","8000","10000"};
    //图片集合
    private String[] exe1={"3年","5年","4年","2年","1年","6年","4年","7年"};
    private String[] degree1={"本科","硕士","博士","博士","硕士","博士","本科","博士"};
    //private String[] cname1={"狮子","企鹅","老虎","大象","蛇","龙","熊","鹰"};
    private String[] location1={"大连","重庆","北京","上海","天津","重庆","广州","深圳"};

    UserService userService;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_ee);
        userService=UserService.getUserService();
        Bundle receivedBundle=getIntent().getExtras();
        Log.d("received",receivedBundle.getString("content"));
        String context=receivedBundle.getString("content");
        List<Recruit> list = userService.search0(context);
        ListView listView=findViewById(R.id.search_listview);
        job1=new String[list.size()];
        salary1=new String[list.size()];
        exe1=new String[list.size()];
        degree1=new String[list.size()];
        //cname1=new String[list.size()];
        location1=new String[list.size()];
        for(int i=0;i<list.size();i++)
        {
            job1[i]=list.get(i).getJobName();
            salary1[i]=list.get(i).getSalaryOffer();
            exe1[i]=list.get(i).getExpRequire();
            degree1[i]=list.get(i).getDegree();
            //cname1=list.get(i).get();
            location1[i]=list.get(i).getWorkCity();
        }
        //创建一个Adapter的实例
        MyBaseAdapter mAdapter=new MyBaseAdapter();
        //设置Adapter
        listView.setAdapter(mAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Bundle bundle = new Bundle();
                bundle.putString("job",job1[i]);
                bundle.putString("salary",salary1[i]);
                bundle.putString("exe",exe1[i]);
                bundle.putString("degree",degree1[i]);
                //bundle.putString("cname",cname1[i]);
                bundle.putString("location",location1[i]);
                Intent intent =new Intent();
                intent.putExtras(bundle);
                intent.setClass(Searchee.this,Details1_ee.class);
                startActivity(intent);
            }
        });
    }
    class ViewHolder{
        public TextView job1;
        public TextView salary1;
        public TextView exe1;
        public TextView degree1;
        //public TextView cname1;
        public TextView location1;
    }
    class MyBaseAdapter extends BaseAdapter {

        @Override
        public int getCount(){       //得到item的总数
            return job1.length;    //返回ListView Item条目代表的对象
        }

        @Override
        public Object getItem(int position){
            return salary1[position]; //返回item的数据对象
        }
        @Override
        public long getItemId(int position){
            return position;         //返回item的id
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent){//获取item中的View视图
            ViewHolder holder;
            if(convertView==null){
                convertView= View.inflate(Searchee.this,R.layout.search_listview, null);
                holder=new ViewHolder();
                holder.job1=convertView.findViewById(R.id.job1);
                holder.salary1=convertView.findViewById(R.id.salary1);
                holder.exe1=convertView.findViewById(R.id.exe1);
                holder.degree1=convertView.findViewById(R.id.degree1);
                //holder.cname1=convertView.findViewById(R.id.cname1);
                holder.location1=convertView.findViewById(R.id.location1);
                convertView.setTag(holder);
            }else{
                holder=(ViewHolder)convertView.getTag();
            }
            holder.job1.setText(job1[position]);
            holder.salary1.setText(salary1[position]);
            holder.exe1.setText(exe1[position]);
            holder.degree1.setText(degree1[position]);
            //holder.cname1.setText(cname1[position]);
            holder.location1.setText(location1[position]);
            return convertView;
        }
    }

}
