package com.example.lenovo.xiangmu0705.model.lunbo;

import com.example.lenovo.xiangmu0705.bean.LenBoBean;

/**
 * Created by lenovo on 2018/7/6.
 */

public interface LunBoListener {
    //成功时调用
    void LunBoSuccess(LenBoBean bean);
    //失败时调用
    void lunBoError(Exception error);
}
