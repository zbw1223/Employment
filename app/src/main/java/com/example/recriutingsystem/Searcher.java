package com.example.recriutingsystem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Searcher  extends AppCompatActivity {
    private String[] name_job={"Java工程师","后端开发","前端开发","游戏设计","pyhton工程师","产品经理","移动开发","项目管理"};
    private String[] salary1={"1800元","2000","3000","4000","5000","6000","8000","10000"};
    //图片集合
    private String[] exp={"3年","5年","4年","2年","1年","6年","4年","7年"};
    private String[] degree1={"本科","硕士","博士","博士","硕士","博士","本科","博士"};
    private String[] name_seeker={"狮子","企鹅","老虎","大象","蛇","龙","熊","鹰"};
    private String[] location1={"大连","重庆","北京","上海","天津","重庆","广州","深圳"};
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_er);
        ListView listView=findViewById(R.id.searcher_listview);
        //创建一个Adapter的实例
        MyBaseAdapter mAdapter=new MyBaseAdapter();
        //设置Adapter
        listView.setAdapter(mAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Bundle bundle = new Bundle();
                bundle.putString("name_job",name_job[i]);
                bundle.putString("salary1",salary1[i]);
                bundle.putString("exp",exp[i]);
                bundle.putString("degree1",degree1[i]);
                bundle.putString("name_seeker",name_seeker[i]);
                bundle.putString("location1",location1[i]);
                Intent intent =new Intent();
                intent.putExtras(bundle);
                intent.setClass(Searcher.this,Details1_er.class);
                startActivity(intent);
            }
        });
    }
    class ViewHolder{
        public TextView job1;
        public TextView salary1;
        public TextView exe1;
        public TextView degree1;
        public TextView cname1;
        public TextView location1;
    }
    class MyBaseAdapter extends BaseAdapter {

        @Override
        public int getCount(){       //得到item的总数
            return name_job.length;    //返回ListView Item条目代表的对象
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
                convertView= View.inflate(Searcher.this,R.layout.search_listview, null);
                holder=new ViewHolder();
                holder.job1=convertView.findViewById(R.id.job1);
                holder.salary1=convertView.findViewById(R.id.salary1);
                holder.exe1=convertView.findViewById(R.id.exe1);
                holder.degree1=convertView.findViewById(R.id.degree1);
                holder.cname1=convertView.findViewById(R.id.cname1);
                holder.location1=convertView.findViewById(R.id.location1);
                convertView.setTag(holder);
            }else{
                holder=(ViewHolder)convertView.getTag();
            }
            holder.job1.setText(name_job[position]);
            holder.salary1.setText(salary1[position]);
            holder.exe1.setText(exp[position]);
            holder.degree1.setText(degree1[position]);
            holder.cname1.setText(name_seeker[position]);
            holder.location1.setText(location1[position]);
            return convertView;
        }
    }

}
