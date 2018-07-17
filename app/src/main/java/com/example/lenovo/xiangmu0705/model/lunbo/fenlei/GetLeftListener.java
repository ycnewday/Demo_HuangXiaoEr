package com.example.lenovo.xiangmu0705.model.lunbo.fenlei;

import com.example.lenovo.xiangmu0705.bean.LeftBean;

/**
 * Created by lenovo on 2018/7/12.
 */

public interface GetLeftListener {
    //成功时调用
    void getLeftSuccess(LeftBean bean);
    //失败时调用
    void getLeftError(Exception error);
}
