package com.example.lenovo.xiangmu0705.model.lunbo.fenlei;

import com.example.lenovo.xiangmu0705.bean.LeftBean;
import com.example.lenovo.xiangmu0705.bean.RightBean;
import com.example.lenovo.xiangmu0705.http.MyApi;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by lenovo on 2018/7/12.
 */

public class ModelFenLeiImpl implements IFenLeiModel{
    @Override
    public void getLeftList(Map<String, String> map, final GetLeftListener getLeftListener) {
        Call<LeftBean> getleft = MyApi.request.getleft(map);
        getleft.enqueue(new Callback<LeftBean>() {
            @Override
            public void onResponse(Call<LeftBean> call, Response<LeftBean> response) {
                LeftBean bean = response.body();
                if(bean.getCode().equals("0")) {
                   getLeftListener.getLeftSuccess(bean);
                }else {
                   getLeftListener.getLeftError(new Exception(""));
                }
            }

            @Override
            public void onFailure(Call<LeftBean> call, Throwable t) {
                getLeftListener.getLeftError(new Exception(""));
            }
        });
    }

    @Override
    public void getRightList(Map<String, String> map, final GetRightListener getRightListener) {
        Call<RightBean> getright = MyApi.request.getright(map);
        getright.enqueue(new Callback<RightBean>() {
            @Override
            public void onResponse(Call<RightBean> call, Response<RightBean> response) {
                RightBean bean = response.body();
                if(bean.getCode().equals("0")) {
                      getRightListener.getRightSuccess(bean);
                }else {
                      getRightListener.getRightError(new Exception(""));
                }

            }

            @Override
            public void onFailure(Call<RightBean> call, Throwable t) {
                getRightListener.getRightError(new Exception(""));
            }
        });
    }
}
