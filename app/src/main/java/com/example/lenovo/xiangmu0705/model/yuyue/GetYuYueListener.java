package com.example.lenovo.xiangmu0705.model.yuyue;

import com.example.lenovo.xiangmu0705.bean.YuYueBean;

/**
 * Created by lenovo on 2018/7/10.
 */

public interface GetYuYueListener {
    void getSuccess(YuYueBean bean);
    void getError(Exception e);
}
