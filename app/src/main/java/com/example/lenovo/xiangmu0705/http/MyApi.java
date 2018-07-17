package com.example.lenovo.xiangmu0705.http;

import android.app.Application;

import com.example.lenovo.xiangmu0705.api.Api;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.tencent.bugly.crashreport.CrashReport;


import cn.jpush.android.api.JPushInterface;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by lenovo on 2018/7/6.
 */

public class MyApi extends Application{
    public static GetDataInterface request;
    private static OkHttpClient client;

//    {
//        PlatformConfig.setWeixin("wxdc1e388c3822c80b", "3baf1193c85774b3fd9d18447d76cab0");
//        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
//    }

    @Override
    public void onCreate() {
        super.onCreate();
        //腾讯bugly
        CrashReport.initCrashReport(getApplicationContext(), "19c2361c92", true);
        //fresco的图片
        Fresco.initialize(this);
        //极光推送
        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);
        //第三方登录
//        UMConfigure.init(this,"5a12384aa40fa3551f0001d1"
//                ,"umeng",UMConfigure.DEVICE_TYPE_PHONE,"");//58edcfeb310c93091c000be2 5965ee00734be40b580001a0
        //拦截器
        if (client == null) {
            synchronized (OkHttpClient.class){
                if (client == null){
                    HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
                    logging.getLevel();
                    client = new OkHttpClient.Builder()
                            .addInterceptor(logging)
                            .build();
                }
            }
        }

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.HOST)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build();
        request = retrofit.create(GetDataInterface.class);
    }
}
