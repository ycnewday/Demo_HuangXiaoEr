package com.example.lenovo.xiangmu0705.view.saomiao.fenlei;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.lenovo.xiangmu0705.R;
import com.example.lenovo.xiangmu0705.adapters.MyAdapter1;
import com.example.lenovo.xiangmu0705.adapters.MyAdapter2;
import com.example.lenovo.xiangmu0705.bean.LeftBean;
import com.example.lenovo.xiangmu0705.bean.RightBean;
import com.example.lenovo.xiangmu0705.model.lunbo.fenlei.ModelFenLeiImpl;
import com.example.lenovo.xiangmu0705.presenter.lunbo.fenlei.FenLeiPresenter;

import java.util.List;

public class FenLeiActivity extends AppCompatActivity implements IFenLeiView{

    private RecyclerView left_listview,right_listview;
    private String cid="2";
    private FenLeiPresenter presenter;
    private static final String TAG = "FenLeiActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }
        setContentView(R.layout.activity_fen_lei);
        initView();
        initData();
    }

    private void initData() {
        presenter = new FenLeiPresenter();
        presenter.showLeftToView(new ModelFenLeiImpl(),this);
    }

    private void initView() {
        left_listview =(RecyclerView)findViewById(R.id.left_listview);
        LinearLayoutManager linearLayout1 = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        left_listview.setLayoutManager(linearLayout1);
        right_listview =(RecyclerView)findViewById(R.id.right_listview);
        LinearLayoutManager linearLayout = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false); right_listview.setLayoutManager(linearLayout);
    }

    private OnItemClickListener mClickListener = new OnItemClickListener() { @Override public void onItemClickListener(View v, int position) { //这里的view就是我们点击的view position就是点击的position
         Toast.makeText(FenLeiActivity.this, " 点击了 " + position, Toast.LENGTH_SHORT).show();
        cid = position+""; initData(); } };

    @Override
    public void leftSuccess(LeftBean bean) {
        List<LeftBean.DataBean> data = bean.getData();
        MyAdapter1 myAdapter1 = new MyAdapter1(mClickListener,this,data);
        left_listview.setAdapter(myAdapter1);
        presenter.showRightToView(new ModelFenLeiImpl(),this);
    }

    @Override
    public void rightSuccess(RightBean bean) {
        List<RightBean.DataBean> data = bean.getData();
        right_listview.setAdapter(new MyAdapter2(this,data));
    }

    @Override
    public void fenLeiError(Exception e) {
        Log.d(TAG, "fenLeiError: "+e);
    }

    @Override
    public String getCid() {
        return this.cid;
    }
}
