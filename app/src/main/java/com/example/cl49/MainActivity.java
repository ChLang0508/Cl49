package com.example.cl49;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
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



import java.util.HashMap;

public  class MainActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener{
    private long clinkTime = 0;
    private BottomNavigationBar bottomNavigationBar;
    int lastSelectedPosition = 0;
    FrameLayout fram1;
    RelativeLayout R1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fram1= findViewById(R.id.fram1);
        R1=findViewById(com.example.cl49.R.id.R11);


        LayoutInflater in1 = LayoutInflater.from(this);
        in1.inflate(R.layout.activity_jingdian, fram1, true);
        //调用外部模块设置图片轮播
        SliderLayout mDemoSlider = findViewById(R.id.slider);
        //设置轮播使用的资源
        HashMap<String, Integer> urlMaps = new HashMap<>();
        urlMaps.put("Hannibal", R.drawable.indicator_corner_bg);
        urlMaps.put("Big Bang Theory", R.drawable.indicator_corner_bg);
        urlMaps.put("House of Cards", R.drawable.indicator_corner_bg);

        for (String name : urlMaps.keySet()) {
            TextSliderView textSliderView = new TextSliderView(this);
            textSliderView
                    .description(name)//描述
                    .image(urlMaps.get(name))//image方法可以传入图片url、资源id、File
                    .setScaleType(BaseSliderView.ScaleType.Fit)//图片缩放类型
                    .setOnSliderClickListener(onSliderClickListener);//图片点击
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle().putString("extra", name);//传入参数
            mDemoSlider.addSlider(textSliderView);//添加一个滑动页面
        }

        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Accordion);//滑动动画
//        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);//默认指示器样式
        mDemoSlider.setCustomIndicator((PagerIndicator) findViewById(R.id.custom_indicator2));//自定义指示器
        mDemoSlider.setCustomAnimation(new DescriptionAnimation());//设置图片描述显示动画
        mDemoSlider.setDuration(4000);//设置滚动时间，也是计时器时间
        mDemoSlider.addOnPageChangeListener(onPageChangeListener);



    //底部导航栏
        bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);

        /** 导航基础设置 包括按钮选中效果 导航栏背景色等 */
        bottomNavigationBar
                .setTabSelectedListener(this)
                .setMode(BottomNavigationBar.MODE_SHIFTING)
                /**
                 *  setMode() 内的参数有三种模式类型：
                 *  MODE_DEFAULT 自动模式：导航栏Item的个数<=3 用 MODE_FIXED 模式，否则用 MODE_SHIFTING 模式
                 *  MODE_FIXED 固定模式：未选中的Item显示文字，无切换动画效果。
                 *  MODE_SHIFTING 切换模式：未选中的Item不显示文字，选中的显示文字，有切换动画效果。
                 */

                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC)
                /**
                 *  setBackgroundStyle() 内的参数有三种样式
                 *  BACKGROUND_STYLE_DEFAULT: 默认样式 如果设置的Mode为MODE_FIXED，将使用BACKGROUND_STYLE_STATIC
                 *                                    如果Mode为MODE_SHIFTING将使用BACKGROUND_STYLE_RIPPLE。
                 *  BACKGROUND_STYLE_STATIC: 静态样式 点击无波纹效果
                 *  BACKGROUND_STYLE_RIPPLE: 波纹样式 点击有波纹效果
                 */

                .setActiveColor("#CD950C") //选中颜色
                .setInActiveColor("#191970") //未选中颜色
                .setBarBackgroundColor("#00868B");//导航栏背景色

        /** 添加导航按钮 */
        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.indicator_corner_bg, "景点"))
                .addItem(new BottomNavigationItem(R.drawable.indicator_corner_bg, "美食"))
                .addItem(new BottomNavigationItem(R.drawable.indicator_corner_bg, "酒店"))
                .addItem(new BottomNavigationItem(R.drawable.indicator_corner_bg, "个人"))
                .setFirstSelectedPosition(lastSelectedPosition)
                .initialise(); //initialise 一定要放在 所有设置的最后一项

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


        //图片轮播事件监听
    //点击事件监听
        private BaseSliderView.OnSliderClickListener onSliderClickListener = new BaseSliderView.OnSliderClickListener() {
            @Override
            public void onSliderClick(BaseSliderView slider) {
                Toast.makeText(MainActivity.this, "123",
                        Toast.LENGTH_SHORT).show();
            }
        };
    //轮转事件监听
        private ViewPagerEx.OnPageChangeListener onPageChangeListener = new ViewPagerEx.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        };

    @Override
    public void onTabSelected(int position) {
        switch (position){
            case 0:
              fram1.bringChildToFront(R1);
        }
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }
}
