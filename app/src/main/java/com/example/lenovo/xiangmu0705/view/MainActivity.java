package com.example.lenovo.xiangmu0705.view;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import com.example.lenovo.xiangmu0705.R;
import com.example.lenovo.xiangmu0705.view.saomiao.SaoMiaoFragment;
import com.example.lenovo.xiangmu0705.view.wode.WoDeFragment;
import com.example.lenovo.xiangmu0705.view.yuyue.ShouYeFragment;
import com.hjm.bottomtabbar.BottomTabBar;

public class MainActivity extends AppCompatActivity {

    private BottomTabBar bottomTabBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null){
             getSupportActionBar().hide();
        }
        setContentView(R.layout.activity_main);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        initView();
        initData();
    }

    private void initData() {
        bottomTabBar.init(getSupportFragmentManager())
                .setImgSize(50, 50)      //图片大小
                .setFontSize(12)                       //字体大小
                .setTabPadding(4, 6, 10)//选项卡的间距
                .setChangeColor(Color.YELLOW, Color.BLACK)     //选项卡的选择颜色
                .addTabItem("首页", R.mipmap.shouye, ShouYeFragment.class)
                .addTabItem("扫描", R.mipmap.sao_dian, SaoMiaoFragment.class)
                .addTabItem("我的", R.mipmap.wode1, WoDeFragment.class)
                .isShowDivider(true)    //是否包含分割线
                .setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
                    @Override
                    public void onTabChange(int position, String name) {

                    }
                });
        int id = getIntent().getIntExtra("id", 0);
        if (id == 1) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.bottom_tab_bar, new ShouYeFragment())
                    .addToBackStack(null)
                    .commit();
        }


    }

    private void initView() {
        bottomTabBar = (BottomTabBar) findViewById(R.id.bottom_tab_bar);
    }
}
