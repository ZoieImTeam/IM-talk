package com.example.administrator.im_talk.IMTalk;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.administrator.im_talk.BaseActivity;
import com.example.administrator.im_talk.R;
import com.hyphenate.chat.EMConversation;
import com.hyphenate.easeui.ui.EaseConversationListFragment;

/**
 * Created by Zoi.
 * E-mail：KyluZoi@gmail.com
 * 2016/6/17
 */
public class IMMesListAct extends BaseActivity implements EaseConversationListFragment.EaseConversationListItemClickListener {
    @Override
    protected void initGetIntent() {

    }

    public static void newInstance(Activity activity) {
        Intent intent =new Intent(activity,IMMesListAct.class);
        activity.startActivity(intent);
    }

    @Override
    public int getLayoutId() {
        return R.layout.act_imchat;
    }

    @Override
    public void initView() {

        EaseConversationListFragment conversationListView =new EaseConversationListFragment();
        conversationListView.setConversationListItemClickListener(this);
        getSupportFragmentManager().beginTransaction().add(R.id.flyt_chat,conversationListView).commit();

    }

    @Override
    public void initData() {

    }

    @Override
    public void refreshData() {

    }

    @Override
    public void onListItemClicked(EMConversation conversation) {
        Toast.makeText(this, conversation.getUserName(), Toast.LENGTH_SHORT).show();
    }
}
