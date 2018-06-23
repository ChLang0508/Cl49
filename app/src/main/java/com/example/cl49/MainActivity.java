package com.example.cl49;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public  class MainActivity extends AppCompatActivity{
    private long clinkTime = 0;
    private BottomNavigationBar bottomNavigationBar;
    FrameLayout fram1;
    RelativeLayout R1;
    public RelativeLayout r_hotel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fram1= findViewById(R.id.fram1);
        R1=findViewById(R.id.R11);
        r_hotel=findViewById(R.id.r_hotel_1);



        SliderLayout mDemoSlider = findViewById(R.id.slider);
        SliderLayout hotel_sider=findViewById(R.id.hotel_slider);

        HashMap<String, Integer> urlMaps = new HashMap<>();
        urlMaps.put("1", R.drawable.indicator_corner_bg);
        urlMaps.put("2", R.drawable.indicator_corner_bg);
        urlMaps.put("3", R.drawable.indicator_corner_bg);

        HashMap<String, Integer> hotelMaps = new HashMap<>();
        hotelMaps.put("4", R.drawable.timg1);
        hotelMaps.put("5", R.drawable.indicator_corner_bg);
        hotelMaps.put("6", R.drawable.indicator_corner_bg);


       sider s1=new sider(MainActivity.this,mDemoSlider,urlMaps);
       s1.set_sider();

       sider s_hotel=new sider(MainActivity.this,hotel_sider,hotelMaps);
       s_hotel.set_sider();


    //底部导航栏
        bottomNavigationBar =findViewById(R.id.bottom_navigation_bar);

        /** 添加导航按钮 */
        HashMap<String,Integer> bottmap = new HashMap<>();
        bottmap.put("主页",R.drawable.indicator_corner_bg);
        bottmap.put( "景点",R.drawable.indicator_corner_bg);
        bottmap.put( "美食",R.drawable.indicator_corner_bg);
        bottmap.put( "酒店",R.drawable.indicator_corner_bg);
        bottmap.put( "个人",R.drawable.indicator_corner_bg);
        ArrayList<String> botmapname=new ArrayList<String>(){{add("主页");add("景点");add("美食");add("酒店");add("个人");}};

        bottomnavigationbar b1=new bottomnavigationbar(bottomNavigationBar,botmapname,bottmap,fram1,R1,r_hotel);
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
}
