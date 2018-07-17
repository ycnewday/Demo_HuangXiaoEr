package com.example.lenovo.xiangmu0705.view.yuyue;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.amap.api.maps2d.AMap;
import com.amap.api.maps2d.MapView;
import com.amap.api.maps2d.model.MyLocationStyle;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.geocoder.GeocodeResult;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.amap.api.services.geocoder.RegeocodeAddress;
import com.amap.api.services.geocoder.RegeocodeQuery;
import com.amap.api.services.geocoder.RegeocodeResult;
import com.example.lenovo.xiangmu0705.R;
import com.example.lenovo.xiangmu0705.adapters.MyYuYueAdapter;
import com.example.lenovo.xiangmu0705.bean.YuYueBean;
import com.example.lenovo.xiangmu0705.model.yuyue.MyYuYueModel;
import com.example.lenovo.xiangmu0705.presenter.yuyue.YuYuePresenter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;


/**
 * Created by lenovo on 2018/7/4.
 */

public class ShouYeFragment extends Fragment implements IYuYueView,View.OnClickListener,GeocodeSearch.OnGeocodeSearchListener,AMap.OnMyLocationChangeListener{
    private View view;
    private XRecyclerView yuyue_xrecy;
    private MySearchView yuyue_search;
    private YuYuePresenter yuyuePresenter;
    private static final String TAG = "ShouYeFragment-------";
    private LinearLayout my_yuyue;
    private ImageView dingwei;
    private TextView weizhi;
    private GeocodeSearch geocoderSearch;
    private String province;
    private String city;
    private String district;
    private String building;
    private MapView mMapView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.shouye_layout, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //获取地图控件引用
        mMapView = (MapView) view.findViewById(R.id.yuyue_map);
        //在activity执行onCreate时执行mMapView.onCreate(savedInstanceState)，创建地图
        mMapView.onCreate(savedInstanceState);
            //初始化界面
            initViews();
            //初始化数据
            initDatas();
    }

    private void initDatas() {
        //逆地理编码
        geocoderSearch = new GeocodeSearch(getContext());
        geocoderSearch.setOnGeocodeSearchListener(this);
         yuyuePresenter = new YuYuePresenter();
        yuyuePresenter.yuYuePresenter(new MyYuYueModel(),this);
    }

    private void initViews() {
        dingwei = (ImageView)view.findViewById(R.id.yuyue_dingwei);
        weizhi = (TextView)view.findViewById(R.id.yuyue_weizhi);
        my_yuyue = (LinearLayout)view.findViewById(R.id.my_yuyue);
        yuyue_xrecy = (XRecyclerView)view.findViewById(R.id.yuyue_xrecy);
        yuyue_search = (MySearchView)view.findViewById(R.id.yuyue_search);
        yuyue_xrecy.setLayoutManager(new LinearLayoutManager(getContext()));
        my_yuyue.setOnClickListener(this);
        dingwei.setOnClickListener(this);


        AMap aMap = null;
        if (aMap == null) {
            aMap = mMapView.getMap();
        }
        MyLocationStyle myLocationStyle;
        myLocationStyle = new MyLocationStyle();//初始化定位蓝点样式类myLocationStyle.myLocationType(MyLocationStyle.LOCATION_TYPE_LOCATION_ROTATE);//连续定位、且将视角移动到地图中心点，定位点依照设备方向旋转，并且会跟随设备移动。（1秒1次定位）如果不设置myLocationType，默认也会执行此种模式。
        myLocationStyle.interval(2000); //设置连续定位模式下的定位间隔，只在连续定位模式下生效，单次定位模式下不会生效。单位为毫秒。
        aMap.setMyLocationStyle(myLocationStyle);//设置定位蓝点的Style
//aMap.getUiSettings().setMyLocationButtonEnabled(true);设置默认定位按钮是否显示，非必需设置。
        aMap.setMyLocationEnabled(true);// 设置为true表示启动显示定位蓝点，false表示隐藏定位蓝点并不进行定位，默认是false。

        myLocationStyle.myLocationType(MyLocationStyle.LOCATION_TYPE_FOLLOW) ;//连续定位、且将视角移动到地图中心点，定位蓝点跟随设备移动。（1秒1次定位）
        myLocationStyle.showMyLocation(true);
        //设置小蓝点位置监听
        aMap.setOnMyLocationChangeListener(this);
    }

    @Override
    public String getContent() {
        String content = yuyue_search.getContent();
        if (TextUtils.isEmpty(content)) {
          content = "笔记本";
        }
        return content;
    }

    @Override
    public void yuYueSuccess(YuYueBean bean) {
        List<YuYueBean.DataBean> data = bean.getData();
        MyYuYueAdapter myYuYueAdapter = new MyYuYueAdapter(getContext(),data);
        yuyue_xrecy.setAdapter(myYuYueAdapter);
    }

    @Override
    public void yuYueError(Throwable code) {
        Log.d(TAG, "yuYueError: "+code);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.my_yuyue:
                startActivity(new Intent(getContext(),SouSuoActivity.class));
                break;
            case R.id.yuyue_dingwei:
                startActivity(new Intent(getContext(),DiTuActivity.class));
                break;
        }
    }

    @Override
    public void onRegeocodeSearched(RegeocodeResult regeocodeResult, int i) {
        //解析result获取地址描述信息
        Log.d(TAG, "onRegeocodeSearched: "+regeocodeResult.getRegeocodeAddress());
        RegeocodeAddress address = regeocodeResult.getRegeocodeAddress();
        Log.d(TAG, "省/市/县: "+address.getProvince()+"--"+address.getCity()+"--"+address.getTownship());
        Log.d(TAG, "街道/建筑 "+address.getDistrict());
        province = address.getProvince();
        city = address.getCity();
        district = address.getDistrict();
        building = address.getTownship();
        weizhi.setText(building+"-"+district);
    }

    @Override
    public void onGeocodeSearched(GeocodeResult geocodeResult, int i) {

    }

    @Override
    public void onMyLocationChange(Location location) {
        // 第一个参数表示一个Latlng，第二参数表示范围多少米，第三个参数表示是火系坐标系还是GPS原生坐标系
        LatLonPoint latLonPoint = new LatLonPoint(location.getLatitude(),location.getLongitude());
        RegeocodeQuery query = new RegeocodeQuery(latLonPoint, 200,GeocodeSearch.AMAP);

        geocoderSearch.getFromLocationAsyn(query);
    }
}
