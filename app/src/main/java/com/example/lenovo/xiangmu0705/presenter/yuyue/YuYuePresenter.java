package com.example.lenovo.xiangmu0705.presenter.yuyue;

import com.example.lenovo.xiangmu0705.bean.YuYueBean;
import com.example.lenovo.xiangmu0705.model.yuyue.GetYuYueListener;
import com.example.lenovo.xiangmu0705.model.yuyue.IYuYueModel;
import com.example.lenovo.xiangmu0705.view.yuyue.IYuYueView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lenovo on 2018/7/10.
 */

public class YuYuePresenter implements IYuYuePresenter{
    @Override
    public void yuYuePresenter(IYuYueModel iYuYueModel, final IYuYueView iYuYueView) {
        Map<String, String> map = new HashMap<>();
        map.put("keywords",iYuYueView.getContent());
        map.put("page","1");
        iYuYueModel.getYuYueListData(map, new GetYuYueListener() {
            @Override
            public void getSuccess(YuYueBean bean) {
                iYuYueView.yuYueSuccess(bean);
            }

            @Override
            public void getError(Exception e) {
                 iYuYueView.yuYueError(e);
            }
        });
    }
}
