package com.example.lenovo.xiangmu0705.model.wode;

import com.example.lenovo.xiangmu0705.bean.UserBean;
import com.example.lenovo.xiangmu0705.http.MyApi;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by lenovo on 2018/7/9.
 */

public class MyUserModel implements IUserPersonModel{
    private static final String TAG = "MyUserModel----------";
    @Override
    public void getUserData(Map<String, String> parmas, final UserListener userListener) {
        Call<UserBean> person = MyApi.request.person(parmas);
       person.enqueue(new Callback<UserBean>() {
           @Override
           public void onResponse(Call<UserBean> call, Response<UserBean> response) {
               UserBean body = response.body();
               userListener.success(body);
           }

           @Override
           public void onFailure(Call<UserBean> call, Throwable t) {
               userListener.failed(t);
           }
       });
    }
}
