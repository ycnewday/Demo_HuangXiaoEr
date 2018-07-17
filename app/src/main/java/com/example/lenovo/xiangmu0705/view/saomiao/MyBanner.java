package com.example.lenovo.xiangmu0705.view.saomiao;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.lenovo.xiangmu0705.R;
import com.example.lenovo.xiangmu0705.view.saomiao.shangjia.DetailActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2018/7/8.
 */

public class MyBanner extends RelativeLayout{

    private LinearLayout linearLayout;
    private ViewPager viewPager;
    private MyHandler myHandler = new MyHandler();
    private List<ImageView> points;
    private String url;
    private static final String TAG = "MyBanner----";

    public MyBanner(Context context) {
        this(context,null);
    }

    public MyBanner(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyBanner(final Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View view = View.inflate(context, R.layout.mybanner_layout, this);
        viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        linearLayout = (LinearLayout) view.findViewById(R.id.ll_points);
         viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
             @Override
             public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

             }

             @Override
             public void onPageSelected(int position) {
                 viewPager.setOnTouchListener(new View.OnTouchListener() {
                     @Override
                     public boolean onTouch(View v, MotionEvent event) {
                         Intent in = new Intent(context, DetailActivity.class);
                         in.putExtra("url", url);
                         context.startActivity(in);
                         return false;
                     }
                 });

                 position = position % points.size();
                 for (int i = 0; i < points.size(); i++) {
                     if (i == position) {
                         points.get(i).setSelected(true);
                     } else {
                         points.get(i).setSelected(false);
                     }
                 }

             }

             @Override
             public void onPageScrollStateChanged(int state) {

             }
         });
    }

    //设置适配器
    public void setMyAdapter(Context context, List<ImageView> list, String url) {
        this.url = url;
        Log.d(TAG, "setMyAdapter: ==============" + url);
        MyAdapter myAdapter = new MyAdapter(context, list);
        viewPager.setAdapter(myAdapter);
        //设置小圆点
        points = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            ImageView point = new ImageView(context);
            point.setImageResource(R.drawable.circle_selector);
            linearLayout.addView(point);
            points.add(point);
        }
        //默认第一个选中
        points.get(0).setSelected(true);
    }

    //开启自动轮播
    public void startPlay() {
        myHandler.sendEmptyMessageDelayed(0, 1000);
    }

    //关闭自动轮播
    public void stopPlay() {
        myHandler.removeCallbacksAndMessages(null);
    }

    class MyAdapter extends PagerAdapter {
        private Context context;
        private List<ImageView> list;

        public MyAdapter(Context context, List<ImageView> list) {
            this.context = context;
            this.list = list;
        }

        @Override
        public int getCount() {
            return Integer.MAX_VALUE;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            position = position % list.size();
            ImageView imageView = list.get(position);
            container.addView(imageView);
            return imageView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((ImageView) object);
        }
    }

    class MyHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            int currentItem = viewPager.getCurrentItem();
            currentItem++;
            viewPager.setCurrentItem(currentItem);
            myHandler.sendEmptyMessageDelayed(0, 1000);
        }
    }

}
