package com.example.lenovo.xiangmu0705.model.lunbo.fenlei;

import java.util.Map;

/**
 * Created by lenovo on 2018/7/12.
 */

public interface IFenLeiModel {
    void getLeftList(Map<String,String> map, GetLeftListener getLeftListener);
    //获取右侧列表数据
    void getRightList(Map<String,String> map,GetRightListener getRightListener);
}
