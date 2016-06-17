package com.example.administrator.im_talk.IMTalk;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.administrator.im_talk.BaseActivity;
import com.example.administrator.im_talk.R;
import com.hyphenate.chat.EMMessage;
import com.hyphenate.easeui.EaseConstant;
import com.hyphenate.easeui.ui.EaseChatFragment;
import com.hyphenate.easeui.widget.chatrow.EaseCustomChatRowProvider;

/**
 * Created by Zoi.
 * E-mail：KyluZoi@gmail.com
 * 2016/6/17
 */
public class IMChatActivity extends BaseActivity implements EaseChatFragment.EaseChatFragmentListener {
    @Override
    protected void initGetIntent() {

    }

    public static void newInstance(Activity activity) {
        Intent intent=new Intent(activity,IMChatActivity.class);
        activity.startActivity(intent);
    }

    @Override
    public int getLayoutId() {
        return R.layout.act_imchat;
    }

    @Override
    public void initView() {

        Bundle args=new Bundle();
        EaseChatFragment chatFragment=new EaseChatFragment();
        args.putInt(EaseConstant.EXTRA_CHAT_TYPE, EaseConstant.CHATTYPE_SINGLE);//传入chatType(会话类型)
        args.putString(EaseConstant.EXTRA_USER_ID,"zoi");
        chatFragment.setArguments(args);
        chatFragment.setChatFragmentListener(this);
        getSupportFragmentManager().beginTransaction().add(R.id.flyt_chat,chatFragment).commit();
    }

    @Override
    public void initData() {

    }

    @Override
    public void refreshData() {

    }

    @Override
    public void onSetMessageAttributes(EMMessage message) {

    }

    @Override
    public void onEnterToChatDetails() {

    }

    @Override
    public void onAvatarClick(String username) {

    }

    @Override
    public boolean onMessageBubbleClick(EMMessage message) {
        return false;
    }

    @Override
    public void onMessageBubbleLongClick(EMMessage message) {

    }

    @Override
    public boolean onExtendMenuItemClick(int itemId, View view) {
        return false;
    }

    @Override
    public EaseCustomChatRowProvider onSetCustomChatRowProvider() {
        return null;
    }
}
