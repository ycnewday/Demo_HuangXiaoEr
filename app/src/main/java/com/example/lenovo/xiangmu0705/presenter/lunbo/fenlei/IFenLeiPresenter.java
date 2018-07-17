package com.example.lenovo.xiangmu0705.presenter.lunbo.fenlei;

import com.example.lenovo.xiangmu0705.model.lunbo.fenlei.IFenLeiModel;
import com.example.lenovo.xiangmu0705.view.saomiao.fenlei.IFenLeiView;

/**
 * Created by lenovo on 2018/7/12.
 */

public interface IFenLeiPresenter {
    //显示左侧列表
    void showLeftToView(IFenLeiModel iFenLeiModel, IFenLeiView iFenLeiView);
    //显示右侧列表
    void showRightToView(IFenLeiModel iFenLeiModel, IFenLeiView iFenLeiView);

}
