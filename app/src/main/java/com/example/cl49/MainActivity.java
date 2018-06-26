package com.example.cl49;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.daimajia.slider.library.SliderLayout;
import java.util.ArrayList;
import java.util.HashMap;

public  class MainActivity extends AppCompatActivity{
    private long clinkTime = 0;
    private BottomNavigationBar bottomNavigationBar;
    private FrameLayout fram1;
    private RelativeLayout R1;
    private RelativeLayout r_hotel;
    private RelativeLayout spot;
    private RelativeLayout per;
    private int loginstate=0;
    private Button gr;
    private TextView textView;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        fram1= findViewById(R.id.fram1);
        R1=findViewById(R.id.R11);
        r_hotel=findViewById(R.id.r_hotel_1);
        spot=findViewById(R.id.r_spot);
        per=findViewById(R.id.r_per);
        SliderLayout mDemoSlider = findViewById(R.id.slider);
        SliderLayout hotel_sider=findViewById(R.id.hotel_slider);
        ImageView shopimage=findViewById(R.id.shop_image);
        gr=findViewById(R.id.geren);
        Button xg=findViewById(R.id.xiugai);
        Button el=findViewById(R.id.exitlogin);
        Button ea=findViewById(R.id.exitapp);
        textView=findViewById(R.id.persion_text);


        context=MainActivity.this;
        //context=getApplicationContext();



//        Intent intent;
//        intent=getIntent();
//        loginstate=intent.getIntExtra("loginstat",0);

        if(loginstate==0) {
            gr.setText("登录");
            textView.setText("未登录");
        }
        else {
            gr.setText("个人信息");
            textView.setText("已登录");
        }
        gr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(loginstate==0){
                    startActivityForResult(new Intent(MainActivity.this,LoginActivity.class), 1);
                }
                else {
                    startActivity(new Intent(MainActivity.this,Per_massage_Activity.class));
                }
            }
        });
        xg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Sign_in_Activity.class));
            }
        });
        el.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginstate=0;
                gr.setText("登录");
                textView.setText("未登录");
            }
        });
        ea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog builder = new AlertDialog.Builder(MainActivity.this)
                        .setMessage("真的要退？")
                        .setTitle("提示框")
                        .setIcon(android.R.drawable.ic_lock_power_off)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface arg0, int arg1) {
                                System.exit(0);
                            }
                        }).setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface arg0, int arg1) {
                            }
                        })
                        .show();
            }
        });

        shopimage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Shop_homepage_Activity.class);
                startActivity(intent);
            }
        });


        HashMap<String, Integer> urlMaps = new HashMap<>();
        urlMaps.put("1", R.drawable.home);
        urlMaps.put("2", R.drawable.home);
        urlMaps.put("3", R.drawable.home);

        HashMap<String, Integer> hotelMaps = new HashMap<>();
        hotelMaps.put("4", R.drawable.home);
        hotelMaps.put("5", R.drawable.home);
        hotelMaps.put("6", R.drawable.home);


       sider s1=new sider(MainActivity.this,mDemoSlider,urlMaps);
       s1.set_sider();

       sider s_hotel=new sider(MainActivity.this,hotel_sider,hotelMaps);
       s_hotel.set_sider();


    //底部导航栏
        bottomNavigationBar =findViewById(R.id.bottom_navigation_bar);

        /** 添加导航按钮 */
        HashMap<String,Integer> bottmap = new HashMap<>();
        bottmap.put("主页",R.drawable.all);
        bottmap.put( "景点",R.drawable.spot);
        bottmap.put( "酒店",R.drawable.hotel);
        bottmap.put( "个人",R.drawable.account);
        ArrayList<String> botmapname=new ArrayList<String>(){{add("主页");add("景点");add("酒店");add("个人");}};

        bottomnavigationbar b1=new bottomnavigationbar(MainActivity.this,bottomNavigationBar,botmapname,bottmap,fram1,R1,r_hotel,spot,per);
        b1.set_bottomnavigationbar();
    }

        //返回键监听重写
        @Override
        public void onBackPressed () {
            if ((System.currentTimeMillis() - clinkTime) < 2000) {
                System.exit(0);

            } else {
                Toast.makeText(MainActivity.this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                clinkTime = System.currentTimeMillis();
            }
        }

    @Override
    protected void onActivityResult(int requstCode, int resultCode, Intent data){
        switch (requstCode){   //请求码
            case 1:
                if(resultCode==RESULT_OK) {
                    loginstate = data.getIntExtra("loginstate", 0);
                    gr.setText("个人信息");
                    textView.setText("已登录");
                }
                break;
        }
    }


}
