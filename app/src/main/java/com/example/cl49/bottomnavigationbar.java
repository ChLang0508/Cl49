package com.example.cl49;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

import java.util.ArrayList;
import java.util.HashMap;

public class bottomnavigationbar implements BottomNavigationBar.OnTabSelectedListener{
    private BottomNavigationBar bottomNavigationBar;
    private ArrayList<String>botmapname;
    private HashMap<String, Integer> bottmap;
    private static int lastSelectedPosition=0;
    private FrameLayout f1;
    private RelativeLayout r1;


    public bottomnavigationbar(BottomNavigationBar bottomNavigationBar, ArrayList<String> botmapname, HashMap<String, Integer> bottmap, FrameLayout f1, RelativeLayout r1){

        this.bottomNavigationBar=bottomNavigationBar;
        this.botmapname=botmapname;
        this.bottmap=bottmap;
        this.f1=f1;
        this.r1=r1;
    }

    public void set_bottomnavigationbar(){

        /** 导航基础设置 包括按钮选中效果 导航栏背景色等 */
        bottomNavigationBar
                .setTabSelectedListener(bottomnavigationbar.this)
                .setMode(BottomNavigationBar.MODE_SHIFTING)
                /**
                 *  setMode() 内的参数有三种模式类型：
                 *  MODE_DEFAULT 自动模式：导航栏Item的个数<=3 用 MODE_FIXED 模式，否则用 MODE_SHIFTING 模式
                 *  MODE_FIXED 固定模式：未选中的Item显示文字，无切换动画效果。
                 *  MODE_SHIFTING 切换模式：未选中的Item不显示文字，选中的显示文字，有切换动画效果。
                 */

                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_RIPPLE)
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

        for (int i=0;i<botmapname.size();i++){
            bottomNavigationBar
                    .addItem(new BottomNavigationItem(bottmap.get(botmapname.get(i)),botmapname.get(i)));
        }
        bottomNavigationBar
                .setFirstSelectedPosition(lastSelectedPosition)
                .initialise(); //initialise 一定要放在 所有设置的最后一项

    }

    @Override
    public void onTabSelected(int position) {
        switch (position){
            case 1:
                f1.bringChildToFront(r1);
                f1.invalidate();
                break;

        }
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }
}
