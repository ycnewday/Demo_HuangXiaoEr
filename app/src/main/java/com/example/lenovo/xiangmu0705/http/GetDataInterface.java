package com.example.lenovo.xiangmu0705.http;

import com.example.lenovo.xiangmu0705.api.Api;
import com.example.lenovo.xiangmu0705.bean.LeftBean;
import com.example.lenovo.xiangmu0705.bean.LenBoBean;
import com.example.lenovo.xiangmu0705.bean.LoginBean;
import com.example.lenovo.xiangmu0705.bean.RightBean;
import com.example.lenovo.xiangmu0705.bean.UserBean;
import com.example.lenovo.xiangmu0705.bean.YuYueBean;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by lenovo on 2018/7/6.
 */

public interface GetDataInterface {
    //登录
    @GET(Api.LOGIN)
    Call<LoginBean> get(@QueryMap Map<String,String> map);
    //主页
    @GET(Api.lunbo)
    Call<LenBoBean> getlun();
    //个人信息
    @GET(Api.user)
    Call<UserBean> person(@QueryMap Map<String,String> map);

    @GET(Api.yuyue_url)
    Call<YuYueBean> getyuyue(@QueryMap Map<String,String> map);

    //信息上传
    @POST("file/upload")
    @Multipart
    Observable<UserBean> uploadFile(@Query("uid") String uid, @Part MultipartBody.Part file);

    //左侧
    @GET(Api.left_url)
    Call<LeftBean> getleft(@QueryMap Map<String,String> map);

    //右侧
    @GET(Api.right_url)
    Call<RightBean> getright(@QueryMap Map<String,String> map);
//    @FormUrlEncoded
//    @POST(Api.LOGIN)
//    Call<LoginBean> post(@QueryMap Map<String,String> map);
}
