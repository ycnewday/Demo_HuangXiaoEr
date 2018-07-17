package com.example.lenovo.xiangmu0705.model.wode;

import com.example.lenovo.xiangmu0705.bean.UserBean;

/**
 * Created by lenovo on 2018/7/9.
 */

public interface UserListener {
    void success(UserBean userBean);
    void failed(Throwable code);
}
