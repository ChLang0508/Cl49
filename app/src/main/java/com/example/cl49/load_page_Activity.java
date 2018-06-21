package com.example.cl49;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowAnimationFrameStats;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
/***************
 * author：成浪*
 *    主页面   *
 ***************/

public class load_page_Activity extends AppCompatActivity {
    ImageView load_image=null;
    @Override

    protected void onCreate(Bundle savedInstanceState) {

        //设置加载页面全屏
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_page_);

        load_image=findViewById(R.id.imageView);
        //设置过渡动画
        AlphaAnimation animation=new AlphaAnimation(0.1f,1.0f);
        animation.setDuration(3000);
        load_image.setAnimation(animation);
        //设置动画播放监听
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                load_image.setBackgroundResource(R.drawable.timg1);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                startActivity(new Intent(load_page_Activity.this,MainActivity.class));
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }
}
