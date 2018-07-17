package com.example.lenovo.xiangmu0705.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lenovo.xiangmu0705.R;
import com.example.lenovo.xiangmu0705.bean.RightBean;

import java.util.List;

/**
 * Created by lenovo on 2018/7/12.
 */

public class MyAdapter3 extends RecyclerView.Adapter<MyAdapter3.MyViewHolder2>{
    private Context context;
    private List<RightBean.DataBean.ListBean> list;

    public MyAdapter3(Context context, List<RightBean.DataBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyViewHolder2 onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.gv_item,parent,false);
        MyViewHolder2 myViewHolder = new MyViewHolder2(view);
        return myViewHolder;

    }

    @Override
    public void onBindViewHolder(MyViewHolder2 holder, int position) {
        Glide.with(context).load(list.get(position).getIcon()).into(holder.gv_pic);
        holder.gv_tv.setText(list.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    class MyViewHolder2 extends RecyclerView.ViewHolder {

        private ImageView gv_pic;
        private TextView gv_tv;
        public MyViewHolder2(View itemView) {
            super(itemView);
            gv_tv = (TextView) itemView.findViewById(R.id.gv_name);
            gv_pic = (ImageView) itemView.findViewById(R.id.gv_pic);
        }

        public MyViewHolder2(View itemView, ImageView gv_pic, TextView gv_tv) {
            super(itemView);
            this.gv_pic = gv_pic;
            this.gv_tv = gv_tv;
        }
    }
    }
