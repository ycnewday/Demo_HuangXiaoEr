package com.example.lenovo.xiangmu0705.view.saomiao;

import com.example.lenovo.xiangmu0705.bean.LenBoBean;

/**
 * Created by lenovo on 2018/7/8.
 */

public interface ILunBoView {
    //成功
    void lunBoSuccess(LenBoBean bean);
    //失败
    void lunBoError(Exception e);
}
