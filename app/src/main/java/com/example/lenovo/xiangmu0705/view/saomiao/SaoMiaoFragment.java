package com.example.lenovo.xiangmu0705.view.saomiao;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.lenovo.xiangmu0705.R;
import com.example.lenovo.xiangmu0705.adapters.MyZhuXiaAdapter;
import com.example.lenovo.xiangmu0705.bean.LenBoBean;
import com.example.lenovo.xiangmu0705.model.lunbo.MyLunBoModel;
import com.example.lenovo.xiangmu0705.presenter.lunbo.LunBoPresenter;
import com.example.lenovo.xiangmu0705.qrcode.CaptureActivity;
import com.example.lenovo.xiangmu0705.view.saomiao.fenlei.FenLeiActivity;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by lenovo on 2018/7/4.
 */

public class SaoMiaoFragment extends Fragment implements ILunBoView{
    private View view;
    private ImageView saoma;
    private static final String TAG = "SaoMiaoFragment----";
    private MyBanner myBanner;
    private LunBoPresenter lunBoPresenter;
    private String url;
    private RecyclerView xia_recy;
    private ImageView biaoge;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.saomiao_layout, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        initData();
    }

    private void initView() {
        biaoge = (ImageView)view.findViewById(R.id.saomiao_biaoge);
        saoma = (ImageView)view.findViewById(R.id.saoma);
        myBanner = (MyBanner) view.findViewById(R.id.banner);
        xia_recy = (RecyclerView)view.findViewById(R.id.xiarecy);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2);
        xia_recy.setLayoutManager(gridLayoutManager);
    }

    private void initData() {
        saoma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getContext(), CaptureActivity.class);
                startActivityForResult(in,0);
            }
        });
        biaoge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(getContext(), FenLeiActivity.class);
                startActivity(in);
            }
        });
        lunBoPresenter = new LunBoPresenter();
        lunBoPresenter.lunBoPresenter(new MyLunBoModel(),this);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d(TAG, "onActivityResult: ");  
    }

    @Override
    public void lunBoSuccess(LenBoBean bean) {
        List<LenBoBean.TuijianBean.ListBean> tuijian = bean.getTuijian().getList();
        MyZhuXiaAdapter myZhuXiaAdapter = new MyZhuXiaAdapter(tuijian,getContext());
        xia_recy.setAdapter(myZhuXiaAdapter);

        List<LenBoBean.DataBean> list = bean.getData();
        List<ImageView> images = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            int type = list.get(i).getType();
            if (type == 0) {
                url = list.get(i).getUrl();
            }
            Log.d(TAG, "handleMessage:-------------------******** " + url);
            String icon = list.get(i).getIcon();
            ImageView imageView = new ImageView(getContext());
            Glide.with(getContext()).load(icon).into(imageView);
            images.add(imageView);
        }
        //Log.d(TAG, "handleMessage:------******-------------******** "+urlStr);
        for (int i = 0; i < images.size(); i++) {
            Log.d(TAG, "lunBoSuccess: "+images.get(i).toString());
        }
        myBanner.setMyAdapter(getContext(), images, url);
        myBanner.startPlay();
    }

    @Override
    public void lunBoError(Exception e) {
        Log.d(TAG, "lunBoError: "+e);
    }
}
