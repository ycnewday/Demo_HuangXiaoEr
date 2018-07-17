package com.example.lenovo.xiangmu0705.view.wode;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.xiangmu0705.R;
import com.example.lenovo.xiangmu0705.api.CacheDataManager;

public class SetUpActivity extends AppCompatActivity {

    private TextView qing;

    private static final String TAG = "SetUpActivity------";
    private Handler handler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            switch (msg.what) {
                case 0:
                    Toast.makeText(SetUpActivity.this,"清理完成",Toast.LENGTH_SHORT).show();
                    try {
                        qing.setText(CacheDataManager.getTotalCacheSize(SetUpActivity.this));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
            }
        };
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        setContentView(R.layout.activity_set_up);
        initView();
    }


    private void initView() {
        qing =(TextView)findViewById(R.id.qing_huancun);
        try {
            qing.setText(CacheDataManager.getTotalCacheSize(this));
        } catch (Exception e) {
            e.printStackTrace();
        }
        qing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new clearCache()).start();
            }
        });
    }
    class clearCache implements Runnable {
        @Override
        public void run() {
            try {
                CacheDataManager.clearAllCache(SetUpActivity.this);
                Thread.sleep(3000);
                if (CacheDataManager.getTotalCacheSize(SetUpActivity.this).startsWith("0")) {
                    handler.sendEmptyMessage(0);
                }
            } catch (Exception e) {
                return;
            }
        }
    }


}
