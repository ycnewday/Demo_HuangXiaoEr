package com.example.lenovo.xiangmu0705.view.wode;

import com.example.lenovo.xiangmu0705.bean.UserBean;

/**
 * Created by lenovo on 2018/7/9.
 */

public interface IUserView {
    //成功
    void userSuccess(UserBean bean);
    //失败
    void userError(Throwable code);
}
