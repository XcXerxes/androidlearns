package com.example.xiacan.android_learns;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class FActivity extends AppCompatActivity {
    private Button firstBtn;
    private Button sBtn;
    private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.facitivity);
        /**
         * 通过点击 firstBtn 实现页面之间的跳转
         * 1、startActivity 的方式跳转
         * 1> 初始化Intent
         */
        mContext = this;
        firstBtn = (Button)findViewById(R.id.firstBtn);
        // 注册点击事件
        firstBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                * 第一个参数：上下文对象 this
                * 第二参数：目标文件
                * */
                Intent intent = new Intent(FActivity.this, SAcivity.class);
                startActivity(intent);
            }
        });

        sBtn = (Button)findViewById(R.id.secondBtn);

        /**
         * 通过startActivityForresult 来实现页面的跳转
         */
        sBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, SAcivity.class);
                /**
                 * 第一个参数是Intent对象
                 * 第二参数是 请求的一个标识
                 */
                startActivityForResult(intent, 1);
            }
        });
    }

    /**
     * 通过startActivityForresult 跳转，接受返回数据
     * requestCode: 请求的标识
     * resultCode 第二个页面返回的标识
     * Intent data 第二个页面回传的数据
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1 && resultCode == 2) {
           String content = data.getStringExtra("data");
        }
    }
}
