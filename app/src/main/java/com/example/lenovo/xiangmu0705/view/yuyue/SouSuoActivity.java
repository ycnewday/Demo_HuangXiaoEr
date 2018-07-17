package com.example.lenovo.xiangmu0705.view.yuyue;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.lenovo.xiangmu0705.R;
import com.example.lenovo.xiangmu0705.adapters.MySouSuoAdapter;
import com.example.lenovo.xiangmu0705.bean.YuYueBean;
import com.example.lenovo.xiangmu0705.model.yuyue.MyYuYueModel;
import com.example.lenovo.xiangmu0705.presenter.yuyue.YuYuePresenter;

import java.util.List;

public class SouSuoActivity extends AppCompatActivity implements IYuYueView,View.OnClickListener{

    private RecyclerView recyclerView;
    private MySearchView mysearch;
    private TextView sousuo;
    private YuYuePresenter yuyuePresenter;
    private static final String TAG = "SouSuoActivity---------";
    private Button jisuan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }
        setContentView(R.layout.activity_sou_suo);
        initView();
        initData();
    }

    private void initData() {
        yuyuePresenter = new YuYuePresenter();
        yuyuePresenter.yuYuePresenter(new MyYuYueModel(),this);
    }

    private void initView() {
        recyclerView = (RecyclerView)findViewById(R.id.sousuo_recy);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mysearch = (MySearchView)findViewById(R.id.sousuo_search);
        sousuo = (TextView)findViewById(R.id.yuyue_sousuo);
        jisuan = (Button)findViewById(R.id.jiesuan);
        //jisuan.setOnClickListener(this);
        sousuo.setOnClickListener(this);
    }

    @Override
    public String getContent() {
        String content = mysearch.getContent();
          if (TextUtils.isEmpty(content)) {
         content = "笔记本";
  }
    return content;
    }

    @Override
    public void yuYueSuccess(YuYueBean bean) {
        List<YuYueBean.DataBean> data = bean.getData();
        MySouSuoAdapter myAdapter = new MySouSuoAdapter(SouSuoActivity.this,data);
        recyclerView.setAdapter(myAdapter);
    }

    @Override
    public void yuYueError(Throwable code) {
        Log.d(TAG, "yuYueError: "+code);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.yuyue_sousuo:
                yuyuePresenter.yuYuePresenter(new MyYuYueModel(),this);
                break;
//            case R.id.jiesuan:
//                break;
        }
    }
}
