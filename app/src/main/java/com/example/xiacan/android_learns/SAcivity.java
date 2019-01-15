package com.example.xiacan.android_learns;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class SAcivity extends AppCompatActivity {
    private Button btn1;
    private String content = "你好";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sacivity);
        /**
         * 第二个页面什么时候给第一个页面回传数据
         */
        btn1 = (Button)findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent data = new Intent();
                data.putExtra("data", content);
                setResult(2, data);
            }
        });
    }
}
