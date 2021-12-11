package com.example.recriutingsystem;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class FragmentMine_ee extends Fragment {
    private static FragmentMine_ee mf;
    UserService userService;
    public static FragmentMine_ee getMessageFragment()
    {
        if(mf == null){
            mf = new FragmentMine_ee();
        }
        return mf;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mine_main_ee,container, false);
        userService=UserService.getUserService();
        Button button1=(Button)view.findViewById(R.id.mine_button1);
        TextView name =(TextView)view.findViewById(R.id.name);
        Log.d("Uid",Integer.toString(userService.getUid()));
        name.setText(userService.theJobSeeker.getName());

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainPage_ee mainactivity =(mainPage_ee) getActivity();
                startActivity(new Intent(mainactivity,Search_intention.class));
            }
        });
        Button button2=(Button)view.findViewById(R.id.mine_button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle =new Bundle();
                bundle.putInt("type",0);
                Intent intent =new Intent();
                intent.putExtras(bundle);
                mainPage_ee activity= (mainPage_ee)getActivity();
                intent.setClass(activity,ChangePsd_ee.class);
                startActivity(intent);
            }
        });
        Button button3=(Button)view.findViewById(R.id.mine_button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startLogin=new Intent(getActivity().getApplicationContext(),MainActivity.class);
                startActivity(startLogin);
            }
        });
        Button button4=(Button)view.findViewById(R.id.mine_button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity().getApplicationContext(),information_ee_change.class);
                startActivity(intent);
            }
        });
        return view;
    }

}
