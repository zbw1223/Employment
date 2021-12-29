package com.example.recriutingsystem;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recriutingsystem.entity.Msg;

import java.util.ArrayList;
import java.util.List;

public class MsgPage extends AppCompatActivity{
    private List<Msg> msgList = new ArrayList<Msg>();
    private UserService userService;
    private EditText inputText;

    private Button send;

    private RecyclerView msgRecyclerView;

    private MsgAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message_page);
        userService=UserService.getUserService();
        initMsgs(); // 初始化消息数据
        inputText = (EditText) findViewById(R.id.input_text);
        send = (Button) findViewById(R.id.send);
        msgRecyclerView = (RecyclerView) findViewById(R.id.msg_recycle_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        TextView textView=(TextView)findViewById(R.id.Mname) ;
        Bundle bundle =getIntent().getExtras();
        String Mname =bundle.getString("name");
        textView.setText(Mname);
        msgRecyclerView.setLayoutManager(layoutManager);
        adapter = new MsgAdapter(msgList);
        msgRecyclerView.setAdapter(adapter);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = inputText.getText().toString();
                if (!"".equals(content)) {
                    Msg msg = new Msg(userService.getUid(),7,null,content);
                    userService.sendMessage(userService.getUid(),7,content);
                    msgList.add(msg);
                    // 当有新消息时，刷新ListView中的显示
                    adapter.notifyItemInserted(msgList.size() - 1);
                    // 将ListView定位到最后一行
                    msgRecyclerView.scrollToPosition(msgList.size() - 1);
                    // 清空输入框中的内容
                    inputText.setText("");
                }
            }
        });
    }

    /**
     * 初始化聊天消息
     */
    private void initMsgs() {
        int uid=userService.getUid();
        msgList=userService.getChat(uid);
//        Msg msg1 = new Msg("Hello guy.", Msg.TYPE_RECEIVED);
//        msgList.add(msg1);
//        Msg msg2 = new Msg("Hello. Who is that?", Msg.TYPE_SENT);
//        msgList.add(msg2);
//        Msg msg3 = new Msg("This is Tom. Nice talking to you. ", Msg.TYPE_RECEIVED);
//        msgList.add(msg3);
    }
}
