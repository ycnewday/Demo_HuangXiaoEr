package com.example.lenovo.xiangmu0705.presenter.denglu;

import com.example.lenovo.xiangmu0705.bean.LoginBean;
import com.example.lenovo.xiangmu0705.model.denglu.LoginListener;
import com.example.lenovo.xiangmu0705.model.denglu.ModelCallBack;
import com.example.lenovo.xiangmu0705.view.denglu.IDengLuView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lenovo on 2018/7/6.
 */

public class Presenter implements Ipresenter {

    @Override
    public void loginPresenter(ModelCallBack modelCallBack, final IDengLuView iDengLuView) {
        Map<String, String> map = new HashMap<>();
        //将手机号与密码存入集合中
        map.put("mobile", iDengLuView.getMobile());
        map.put("password", iDengLuView.getPassword());
        modelCallBack.onSuccess(map, new LoginListener() {
            @Override
            public void loginSuccess(LoginBean bean) {
                iDengLuView.loginSuccess();
            }

            @Override
            public void loginError(Exception error) {
                 iDengLuView.loginError();
            }
        });
    }
}
