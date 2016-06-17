package com.example.administrator.im_talk;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.im_talk.IMTalk.IMChatActivity;
import com.example.administrator.im_talk.IMTalk.IMMesListAct;
import com.hyphenate.EMCallBack;
import com.hyphenate.chat.EMClient;
import com.hyphenate.exceptions.HyphenateException;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class IMDemoActivity extends BaseActivity {

    @Bind(R.id.et_username)
    EditText etUsername;
    @Bind(R.id.et_psw)
    EditText etPsw;
    @Bind(R.id.btn_register)
    Button btnRegister;
    @Bind(R.id.btn_login)
    Button btnLogin;

    String username;
    String pwd;

    @Override
    protected void initGetIntent() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        ButterKnife.bind(this);

    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.btn_register, R.id.btn_login})
    public void onClick(View view) {
        username = etUsername.getText().toString();
        pwd = etPsw.getText().toString();
        switch (view.getId()) {
            case R.id.btn_register:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            EMClient.getInstance().createAccount(username, pwd);//同步方法
                        }
                        //注册失败会抛出HyphenateException
                        catch (HyphenateException e) {
                            Toast.makeText(IMDemoActivity.this, "注册失败", Toast.LENGTH_SHORT).show();
                            e.printStackTrace();
                        }
                    }
                }).start();


                break;
            case R.id.btn_login:
                Log.d("zoi", username);
                Log.d("zoi", pwd);
                //先清除里面的账号密码值（坑）
                EMClient.getInstance().logout(true);
                EMClient.getInstance().login(username, pwd, new EMCallBack() {//回调
                    @Override
                    public void onSuccess() {
//                                EMClient.getInstance().groupManager().loadAllGroups();
//                                EMClient.getInstance().chatManager().loadAllConversations();
//                        IMChatActivity.newInstance(IMDemoActivity.this);
                        IMMesListAct.newInstance(IMDemoActivity.this);
                        Log.d("main", "登录聊天服务器成功！");
                    }

                    @Override
                    public void onProgress(int progress, String status) {
                        Toast.makeText(IMDemoActivity.this, "登录中", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(int code, String message) {
                        Log.d("main", "登录聊天服务器失败！");
                    }
                });
                break;
        }
    }

    @Override
    public void refreshData() {

    }
}
