package com.example.lenovo.xiangmu0705.presenter.wode;

import com.example.lenovo.xiangmu0705.bean.UserBean;
import com.example.lenovo.xiangmu0705.model.wode.IUserPersonModel;
import com.example.lenovo.xiangmu0705.model.wode.UserListener;
import com.example.lenovo.xiangmu0705.view.wode.IUserView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lenovo on 2018/7/9.
 */

public class UserPresenter implements IUserPresenter{
    private static final String TAG = "UserPresenter";
    @Override
    public void userPresenter(IUserPersonModel iUserPersonModel, final IUserView iUserView) {
        Map<String, String> map = new HashMap<>();
        map.put("uid","71");
        iUserPersonModel.getUserData(map, new UserListener() {
            @Override
            public void success(UserBean userBean) {
                iUserView.userSuccess(userBean);
                    
            }

            @Override
            public void failed(Throwable code) {
                 iUserView.userError(code);
            }
        });
    }
}
