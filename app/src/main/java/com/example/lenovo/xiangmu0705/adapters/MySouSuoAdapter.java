package com.example.lenovo.xiangmu0705.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lenovo.xiangmu0705.R;
import com.example.lenovo.xiangmu0705.bean.YuYueBean;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by lenovo on 2018/7/11.
 */

public class MySouSuoAdapter extends RecyclerView.Adapter<MySouSuoAdapter.MyViewHolder>{
    private Context context;
    private List<YuYueBean.DataBean> list;

    public MySouSuoAdapter(Context context, List<YuYueBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_yuyue, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setUri(list.get(position).getImages())
                .setOldController(holder.yuyue_pic.getController())//内存优化  
                .setAutoPlayAnimations(true)
                .build();
        holder.yuyue_pic.setController(controller);
        holder.yuyue_title.setText(list.get(position).getTitle());
        holder.yuyue_yueshou.setText("月售"+list.get(position).getSalenum()+"单     "+"评分"+list.get(position).getPscid());
        holder.yuyue_qian.setText(list.get(position).getPrice()+"");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView yuyue_title,yuyue_yueshou,yuyue_qian;
        private SimpleDraweeView yuyue_pic;
        public MyViewHolder(View itemView) {
            super(itemView);
            yuyue_pic = (SimpleDraweeView)itemView.findViewById(R.id.yuyue_pic);
            yuyue_title = (TextView)itemView.findViewById(R.id.yuyue_title);
            yuyue_yueshou = (TextView)itemView.findViewById(R.id.yuyue_yueshou);
            yuyue_qian = (TextView)itemView.findViewById(R.id.yuyue_qian);
        }

        public MyViewHolder(View itemView, TextView yuyue_title, TextView yuyue_yueshou, TextView yuyue_qian, SimpleDraweeView yuyue_pic) {
            super(itemView);
            this.yuyue_title = yuyue_title;
            this.yuyue_yueshou = yuyue_yueshou;
            this.yuyue_qian = yuyue_qian;
            this.yuyue_pic = yuyue_pic;
        }
    }
}
