package com.example.recriutingsystem;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.recriutingsystem.entity.Msg;

import java.util.List;

class MsgAdapter extends RecyclerView.Adapter<MsgAdapter.ViewHolder> {


    private List<Msg> mMsgList;
    private UserService userService;
    static class ViewHolder extends RecyclerView.ViewHolder {

        LinearLayout leftLayout;

        LinearLayout rightLayout;

        TextView leftMsg;

        TextView rightMsg;

        // view表示父类的布局，用其获取子项
        public ViewHolder(View view) {
            super(view);
            leftLayout = (LinearLayout) view.findViewById(R.id.left_layout);
            rightLayout = (LinearLayout) view.findViewById(R.id.right_layout);
            leftMsg = (TextView) view.findViewById(R.id.left_msg);
            rightMsg = (TextView) view.findViewById(R.id.right_msg);
        }
    }

    public MsgAdapter(List<Msg> msgList) {

        mMsgList = msgList;
        userService=UserService.getUserService();
    }

    /**
     * 创建 ViewHolder 加载 RecycleView 子项的布局
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.msg_item, parent, false);
        return new ViewHolder(view);
    }

    /**
     * 为 RecycleView 子项赋值
     * 赋值通过 position 判断子项位置
     * 当子项进入界面时执行
     */
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Msg msg = mMsgList.get(position);
        int uid=userService.getUid();
        if (msg.getDestination()==uid) {
            // 如果是收到的消息，则显示左边的消息布局，将右边的消息布局隐藏
            holder.leftLayout.setVisibility(View.VISIBLE);
            holder.rightLayout.setVisibility(View.GONE);
            holder.leftMsg.setText(msg.getMessage());
        } else if (msg.getSource()==uid) {
            // 如果是发出的消息，则显示右边的消息布局，将左边的消息布局隐藏
            holder.rightLayout.setVisibility(View.VISIBLE);
            holder.leftLayout.setVisibility(View.GONE);
            holder.rightMsg.setText(msg.getMessage());
        }
    }

    @Override
    public int getItemCount() {
        return mMsgList.size();
    }
}

