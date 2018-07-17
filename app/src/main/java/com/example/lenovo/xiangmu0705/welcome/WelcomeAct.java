package com.example.lenovo.xiangmu0705.welcome;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.lenovo.xiangmu0705.R;
import com.example.lenovo.xiangmu0705.view.denglu.DengLuActivity;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

public class WelcomeAct extends AppCompatActivity {

    private SimpleDraweeView pic;
    private boolean isFirstIn = false;
    private ImageView pic_tiao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        //获取一个Layout参数，设置为全屏
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        pic = (SimpleDraweeView) findViewById(R.id.huan_pic);
        pic_tiao = (ImageView) findViewById(R.id.huan_tiao);
        //Uri uri = Uri.parse("http://p0.ifengimg.com/pmop/2018/0211/34BB8479C0B68ADA393B11E0FFA12AFA73C41CC4_size330_w423_h236.gif");

        //加载GIF图片
        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setUri("res://com.example.lenovo.xiangmu0705/" + R.mipmap.shanpin)
                .setOldController(pic.getController())//内存优化  
                .setAutoPlayAnimations(true)
                .build();
        pic.setController(controller);
        pic_tiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                init();
            }
        });
    }

    private void init() {
        SharedPreferences preferences = getSharedPreferences("myWelcome", MODE_PRIVATE);
        isFirstIn = preferences.getBoolean("isFirstIn", true);
        if (!isFirstIn) {
            Intent i = new Intent(WelcomeAct.this, DengLuActivity.class);
            startActivity(i);
            finish();
        } else {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("isFirstIn", false);
            editor.apply();
            Intent i = new Intent(WelcomeAct.this, GuideActivity.class);
            startActivity(i);
            finish();

        }
    }
}
