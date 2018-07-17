package com.example.lenovo.xiangmu0705.view.denglu;

/**
 * Created by lenovo on 2018/7/6.
 */

public interface IDengLuView {
    //获取手机号
    String getMobile();
    //获取密码
    String getPassword();
    //登录成功
    void loginSuccess();
    //登录失败
    void loginError();
}
