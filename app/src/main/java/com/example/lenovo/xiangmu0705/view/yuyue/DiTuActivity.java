package com.example.lenovo.xiangmu0705.view.yuyue;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

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
import com.example.lenovo.xiangmu0705.view.MainActivity;

public class DiTuActivity extends AppCompatActivity implements AMap.OnMyLocationChangeListener,GeocodeSearch.OnGeocodeSearchListener {
    MapView mMapView = null;
    private static final String TAG = "DiTuActivity-------";
    private GeocodeSearch geocoderSearch;
    private ImageView fanhui;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }
        setContentView(R.layout.activity_di_tu);
        fanhui = (ImageView)findViewById(R.id.fanhui);
        //获取地图控件引用
        mMapView = (MapView) findViewById(R.id.map);
        //在activity执行onCreate时执行mMapView.onCreate(savedInstanceState)，创建地图
        mMapView.onCreate(savedInstanceState);
        //初始化地图控制器对象
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
        //逆地理编码
        geocoderSearch = new GeocodeSearch(this);
        geocoderSearch.setOnGeocodeSearchListener(this);
        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DiTuActivity.this, MainActivity.class);
                intent.putExtra("id",1);
                startActivity(intent);
                finish();
            }

        });

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestroy()，销毁地图
        mMapView.onDestroy();
    }
    @Override
    protected void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView.onResume ()，重新绘制加载地图
        mMapView.onResume();
    }
    @Override
    protected void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView.onPause ()，暂停地图的绘制
        mMapView.onPause();
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //在activity执行onSaveInstanceState时执行mMapView.onSaveInstanceState (outState)，保存地图当前的状态
        mMapView.onSaveInstanceState(outState);
    }

    //小蓝点定位的当前位置
    @Override
    public void onMyLocationChange(Location location) {
        //经纬度
        Log.d(TAG, "onMyLocationChange: "+location.getLatitude()+"--"+location.getLongitude());
        // 第一个参数表示一个Latlng，第二参数表示范围多少米，第三个参数表示是火系坐标系还是GPS原生坐标系
        LatLonPoint latLonPoint = new LatLonPoint(location.getLatitude(),location.getLongitude());
        RegeocodeQuery query = new RegeocodeQuery(latLonPoint, 200,GeocodeSearch.AMAP);

        geocoderSearch.getFromLocationAsyn(query);
    }
    //逆地理编码
    @Override
    public void onRegeocodeSearched(RegeocodeResult regeocodeResult, int i) {
        //解析result获取地址描述信息
        Log.d(TAG, "onRegeocodeSearched: "+regeocodeResult.getRegeocodeAddress());
        RegeocodeAddress address = regeocodeResult.getRegeocodeAddress();
        Log.d(TAG, "省/市/县: "+address.getProvince()+"--"+address.getCity()+"--"+address.getTownship());
        Log.d(TAG, "街道/建筑 "+address.getDistrict());
    }

    @Override
    public void onGeocodeSearched(GeocodeResult geocodeResult, int i) {

    }
}
