package com.example.lenovo.xiangmu0705.presenter.lunbo.fenlei;

import com.example.lenovo.xiangmu0705.bean.LeftBean;
import com.example.lenovo.xiangmu0705.bean.RightBean;
import com.example.lenovo.xiangmu0705.model.lunbo.fenlei.GetLeftListener;
import com.example.lenovo.xiangmu0705.model.lunbo.fenlei.GetRightListener;
import com.example.lenovo.xiangmu0705.model.lunbo.fenlei.IFenLeiModel;
import com.example.lenovo.xiangmu0705.view.saomiao.fenlei.IFenLeiView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lenovo on 2018/7/12.
 */

public class FenLeiPresenter implements IFenLeiPresenter{

    @Override
    public void showLeftToView(IFenLeiModel iFenLeiModel, final IFenLeiView iFenLeiView) {
        Map<String, String> map = new HashMap<>();
        iFenLeiModel.getLeftList(map, new GetLeftListener() {
            @Override
            public void getLeftSuccess(LeftBean bean) {
                  iFenLeiView.leftSuccess(bean);
            }

            @Override
            public void getLeftError(Exception error) {
                   iFenLeiView.fenLeiError(error);
            }
        });
    }

    @Override
    public void showRightToView(IFenLeiModel iFenLeiModel, final IFenLeiView iFenLeiView) {
        Map<String, String> map = new HashMap<>();
        map.put("cid",iFenLeiView.getCid());
        iFenLeiModel.getRightList(map, new GetRightListener() {
            @Override
            public void getRightSuccess(RightBean bean) {
                    iFenLeiView.rightSuccess(bean);
            }

            @Override
            public void getRightError(Exception error) {
                    iFenLeiView.fenLeiError(error);
            }
        });
    }
}
