package com.example.recriutingsystem;



import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import static com.example.recriutingsystem.UserService.getUserService;
import static com.example.recriutingsystem.UserService.userService;


public class fragmentMine_er extends Fragment {
    private static fragmentMine_er mf;
    private UserService userService;
    public static fragmentMine_er getMessageFragment()
    {
        if(mf == null){
            mf = new fragmentMine_er();
        }
        return mf;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mine_main_er,container, false);
        //跳转职位管理
        userService=UserService.getUserService();
        TextView edBname=(TextView)view.findViewById(R.id.businessName);
        edBname.setText(userService.theBusiness.getBusinessName());
        Button button2=(Button)view.findViewById(R.id.mine_button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent startPositionEdit=new Intent(getActivity().getApplicationContext(),Position_edit.class);
               startActivity(startPositionEdit);
            }
        });
        //跳转更改密码
        Button button6=(Button)view.findViewById(R.id.mine_button6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle =new Bundle();
                bundle.putInt("type",1);
                Intent intent =new Intent();
                intent.putExtras(bundle);
                mainPage_er activity= (mainPage_er)getActivity();
                intent.setClass(activity,ChangePsd_ee.class);
                startActivity(intent);
            }
        });
        //退出登录
        Button button3=(Button)view.findViewById(R.id.mine_button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startLogin=new Intent(getActivity().getApplicationContext(),MainActivity.class);
                startActivity(startLogin);
            }
        });
        //   企业信息修改
        Button button4=(Button)view.findViewById(R.id.mine_button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startCompanyChange=new Intent(getActivity().getApplicationContext(),information_er_change.class);
                startActivity(startCompanyChange);
            }
        });
        //发布职位
        Button button1=(Button)view.findViewById(R.id.mine_button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startRecruit=new Intent(getActivity().getApplicationContext(),Recriuting.class);
                startActivity(startRecruit);

            }
        });

        return view;
    }
}
