package com.example.lenovo.xiangmu0705.presenter.lunbo;

import android.util.Log;

import com.example.lenovo.xiangmu0705.bean.LenBoBean;
import com.example.lenovo.xiangmu0705.model.lunbo.LunBoListener;
import com.example.lenovo.xiangmu0705.model.lunbo.LunBoModel;
import com.example.lenovo.xiangmu0705.view.saomiao.ILunBoView;

/**
 * Created by lenovo on 2018/7/8.
 */

public class LunBoPresenter implements ILunBoPresenter{
    private static final String TAG = "LunBoPresenter--------";
    @Override
    public void lunBoPresenter(LunBoModel lunBoModel, final ILunBoView iLunBoView) {
         lunBoModel.getLunBoData(new LunBoListener() {
             @Override
             public void LunBoSuccess(LenBoBean bean) {
                 iLunBoView.lunBoSuccess(bean);
             }

             @Override
             public void lunBoError(Exception error) {
                 iLunBoView.lunBoError(new Exception(error+""));
             }
         });

    }
}
