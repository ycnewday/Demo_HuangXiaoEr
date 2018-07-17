package com.example.lenovo.xiangmu0705.model.lunbo.fenlei;

import com.example.lenovo.xiangmu0705.bean.RightBean;

/**
 * Created by lenovo on 2018/7/12.
 */

public interface GetRightListener {
    //成功时调用
    void getRightSuccess(RightBean bean);
    //失败时调用
    void getRightError(Exception error);
}
