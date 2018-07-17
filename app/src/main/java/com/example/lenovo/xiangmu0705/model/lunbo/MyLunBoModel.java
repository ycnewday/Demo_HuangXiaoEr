package com.example.lenovo.xiangmu0705.model.lunbo;

import android.util.Log;

import com.example.lenovo.xiangmu0705.bean.LenBoBean;
import com.example.lenovo.xiangmu0705.http.MyApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by lenovo on 2018/7/6.
 */

public class MyLunBoModel implements LunBoModel{
    private static final String TAG = "MyLunBoModel";

    @Override
    public void getLunBoData(final LunBoListener lunBoListener) {
        Call<LenBoBean> getlun = MyApi.request.getlun();
        getlun.enqueue(new Callback<LenBoBean>() {
            @Override
            public void onResponse(Call<LenBoBean> call, Response<LenBoBean> response) {
                LenBoBean bean = response.body();
                lunBoListener.LunBoSuccess(bean);
            }

            @Override
            public void onFailure(Call<LenBoBean> call, Throwable t) {
                 lunBoListener.lunBoError(new Exception(""+t));
            }
        });
    }
}
