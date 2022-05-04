package com.example.onlinepostoffice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    Button btnDynamicState;

    // TODO 添加自动改变“邮政动态”内容
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnDynamicState=(Button) findViewById(R.id.btnDynamicState);
        String[] dynamicState = {"关于2022年5月新飞行纪特邮票预售安排的公告",
                "4月上新日【江山邮画】",
                "关于调整《中墨建交五十周年》邮票预售自提相关时限",
                "4月优选日【邮古说今】",
                "中国古典文学名著--《红楼梦》（全张邮票折）摇号",
                "关于2022年4月新发型纪特邮票预售安排的公告"};
        btnDynamicState.setText(dynamicState[0]);

    }
}
