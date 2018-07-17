package com.example.lenovo.xiangmu0705.view.yuyue;

import com.example.lenovo.xiangmu0705.bean.YuYueBean;

/**
 * Created by lenovo on 2018/7/10.
 */

public interface IYuYueView {

    //获取输入框内容
     String getContent();
    //成功
    void yuYueSuccess(YuYueBean bean);
    //失败
    void yuYueError(Throwable code);
}
