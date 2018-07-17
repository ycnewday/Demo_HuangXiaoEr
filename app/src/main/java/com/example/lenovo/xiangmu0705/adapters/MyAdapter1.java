package com.example.lenovo.xiangmu0705.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lenovo.xiangmu0705.R;
import com.example.lenovo.xiangmu0705.bean.LeftBean;
import com.example.lenovo.xiangmu0705.view.saomiao.fenlei.OnItemClickListener;

import java.util.List;

/**
 * Created by lenovo on 2018/7/12.
 */

public class MyAdapter1 extends RecyclerView.Adapter<MyAdapter1.MyViewHolder> implements View.OnClickListener{

    private OnItemClickListener mClickListener;
    private Context context;
    private List<LeftBean.DataBean> list;

    public MyAdapter1(OnItemClickListener mClickListener, Context context, List<LeftBean.DataBean> list) {
        this.mClickListener = mClickListener;
        this.context = context;
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.left_layout,parent,false);
        view.setOnClickListener(this);
        MyAdapter1.MyViewHolder myViewHolder = new MyAdapter1.MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.textView.setText(list.get(position).getName());
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onClick(View v) {
        mClickListener.onItemClickListener(v, ((int) v.getTag()));
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;
        public MyViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.left_item_tv);
        }

        public MyViewHolder(View itemView, TextView textView) {
            super(itemView);
            this.textView = textView;
        }
    }
    }
