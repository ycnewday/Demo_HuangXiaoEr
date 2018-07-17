package com.example.lenovo.xiangmu0705.view.wode;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lenovo.xiangmu0705.R;
import com.example.lenovo.xiangmu0705.bean.UserBean;
import com.example.lenovo.xiangmu0705.model.wode.MyUserModel;
import com.example.lenovo.xiangmu0705.presenter.wode.UserPresenter;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;


/**
 * Created by lenovo on 2018/7/4.
 */

public class WoDeFragment extends Fragment implements IUserView,View.OnClickListener{
    private View view;
    private static final String TAG = "WoDeFragment----------";
    private TextView wo_title,wo_mobile,wo_qian,wo_ding,wo_du;
    private SimpleDraweeView wo_pic;
    private UserPresenter userPresenter;
    private ImageView wo_ge;
    private ImageView wo_she;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.wode_layout, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        initData();
    }

    private void initData() {
        userPresenter = new UserPresenter();
        userPresenter.userPresenter(new MyUserModel(),this);
    }

    private void initView() {
        wo_title = (TextView)view.findViewById(R.id.wo_title);
        wo_mobile = (TextView)view.findViewById(R.id.wo_shouji);
        wo_qian = (TextView)view.findViewById(R.id.wo_qian);
        wo_ding = (TextView)view.findViewById(R.id.wo_ding);
        wo_du = (TextView)view.findViewById(R.id.wo_du);
        wo_pic = (SimpleDraweeView)view.findViewById(R.id.wode_user_pic);
        wo_ge = (ImageView)view.findViewById(R.id.woge);
        wo_she = (ImageView)view.findViewById(R.id.woshe);
    }

    @Override
    public void userSuccess(UserBean userBean) {
        final UserBean.DataBean data = userBean.getData();
        wo_title.setText(data.getUsername());
        wo_mobile.setText(data.getMobile());
        wo_qian.setText(data.getMoney()+"元"+"\n"+"我的钱包");
        wo_ding.setText(data.getFollow()+"个"+"\n"+"全部订单");
        wo_du.setText(data.getFans()+"条"+"\n"+"我的钱包");
        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setUri(data.getIcon())
                .setOldController(wo_pic.getController())//内存优化  
                .setAutoPlayAnimations(true)
                .build();
        wo_pic.setController(controller);
        wo_ge.setOnClickListener(this);
        wo_she.setOnClickListener(this);

    }

    @Override
    public void userError(Throwable code) {
        Log.d(TAG, "userError: "+code);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.woge:
                Intent in = new Intent(getContext(), PersonInfoActivity.class);
                startActivity(in);
                break;
            case R.id.woshe:
                Intent in1 = new Intent(getContext(), SetUpActivity.class);
                startActivity(in1);
                break;
        }
    }
}
