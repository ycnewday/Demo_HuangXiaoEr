package com.example.lenovo.xiangmu0705.model.yuyue;

import com.example.lenovo.xiangmu0705.bean.YuYueBean;
import com.example.lenovo.xiangmu0705.http.MyApi;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by lenovo on 2018/7/10.
 */

public class MyYuYueModel implements IYuYueModel{

    @Override
    public void getYuYueListData(Map<String, String> map, final GetYuYueListener getYuYueListener) {
        Call<YuYueBean> getyuyue = MyApi.request.getyuyue(map);
        getyuyue.enqueue(new Callback<YuYueBean>() {
            @Override
            public void onResponse(Call<YuYueBean> call, Response<YuYueBean> response) {
                YuYueBean body = response.body();
                if(body.getCode().equals("0")) {
                    getYuYueListener.getSuccess(body);
                }else {
                    getYuYueListener.getError(new Exception(""));
                }
            }

            @Override
            public void onFailure(Call<YuYueBean> call, Throwable t) {
                getYuYueListener.getError(new Exception(""));
            }
        });
    }
}
