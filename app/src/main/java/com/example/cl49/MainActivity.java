package com.example.cl49;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private long clinkTime=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FrameLayout mainpage=findViewById(R.id.fram1);
        Button bt1=findViewById(R.id.button1);
        Button bt2=findViewById(R.id.button2);
        Button bt3=findViewById(R.id.button3);
        Button bt4=findViewById(R.id.button4);

        bt1.setText("景点");
        bt2.setText("美食");
        bt3.setText("酒店");
        bt4.setText("我的");


    }
    //返回键监听重写
    @Override
    public void onBackPressed() {
        if ((System.currentTimeMillis()-clinkTime)<2000) {
            System.exit(0);

        } else {
            Toast.makeText(MainActivity.this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
            clinkTime=System.currentTimeMillis();
        }
    }
}