package com.example.lenovo.xiangmu0705.view.saomiao.fenlei;

import com.example.lenovo.xiangmu0705.bean.LeftBean;
import com.example.lenovo.xiangmu0705.bean.RightBean;

/**
 * Created by lenovo on 2018/7/12.
 */

public interface IFenLeiView {
    //成功
    void leftSuccess(LeftBean bean);

    void rightSuccess(RightBean bean);
    //失败
    void fenLeiError(Exception e);
    //获取id
    String getCid();
}
