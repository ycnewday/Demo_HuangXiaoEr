package com.example.lenovo.xiangmu0705.adapters;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lenovo.xiangmu0705.R;
import com.example.lenovo.xiangmu0705.bean.RightBean;

import java.util.List;

/**
 * Created by lenovo on 2018/7/12.
 */

public class MyAdapter2 extends RecyclerView.Adapter<MyAdapter2.MyViewHolder1>{
    private Context context;
    private List<RightBean.DataBean> list;

    public MyAdapter2(Context context, List<RightBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyViewHolder1 onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.right_item,parent,false);
        MyAdapter2.MyViewHolder1 myViewHolder = new MyAdapter2.MyViewHolder1(view);
        return myViewHolder;

    }

    @Override
    public void onBindViewHolder(MyViewHolder1 holder, int position) {
        holder.right_tv.setText(list.get(position).getName());
        List<RightBean.DataBean.ListBean> list = this.list.get(position).getList();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context,2);
        holder.recyclerView.setLayoutManager(gridLayoutManager);
        holder.recyclerView.setAdapter(new MyAdapter3(context,list));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder1 extends RecyclerView.ViewHolder {

        private TextView right_tv;
        private RecyclerView recyclerView;
        public MyViewHolder1(View itemView) {
            super(itemView);
            right_tv = (TextView) itemView.findViewById(R.id.right_title);
            recyclerView = (RecyclerView) itemView.findViewById(R.id.right_gv);
        }

        public MyViewHolder1(View itemView, TextView right_tv, RecyclerView recyclerView) {
            super(itemView);
            this.right_tv = right_tv;
            this.recyclerView = recyclerView;
        }
    }
    }
