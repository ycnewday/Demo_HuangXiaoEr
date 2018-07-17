package com.example.lenovo.xiangmu0705.model.denglu;

import com.example.lenovo.xiangmu0705.bean.LoginBean;

/**
 * Created by lenovo on 2018/7/6.
 */

public interface LoginListener {
    //成功时调用
    void loginSuccess(LoginBean bean);
    //失败时调用
    void loginError(Exception error);
}
