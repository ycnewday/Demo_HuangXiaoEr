package com.example.lenovo.xiangmu0705.model.denglu;

import com.example.lenovo.xiangmu0705.bean.LoginBean;
import com.example.lenovo.xiangmu0705.http.MyApi;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by lenovo on 2018/7/6.
 */

public class MyModel implements ModelCallBack{

    private static final String TAG = "MyModel-----------";
    @Override
    public void onSuccess(Map<String, String> parmas, final LoginListener loginListener) {
        Call<LoginBean> call = MyApi.request.get(parmas);
       // Call<LoginBean> call = MyApi.request.post("18622335578","1234567");
        call.enqueue(new Callback<LoginBean>() {
            @Override
            public void onResponse(Call<LoginBean> call, Response<LoginBean> response) {
                LoginBean bean = response.body();
                if(bean.getCode().equals("0")) {
                    loginListener.loginSuccess(bean);
                }else {
                    loginListener.loginError(new Exception(""));
                }
            }

            @Override
            public void onFailure(Call<LoginBean> call, Throwable t) {
                 loginListener.loginError(new Exception(""));
            }
        });
    }
}
