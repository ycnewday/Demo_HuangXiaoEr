package com.example.lenovo.xiangmu0705.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lenovo.xiangmu0705.R;
import com.example.lenovo.xiangmu0705.bean.LenBoBean;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by lenovo on 2018/7/9.
 */

public class MyZhuXiaAdapter extends RecyclerView.Adapter<MyZhuXiaAdapter.MyViewHolder> {

    private List<LenBoBean.TuijianBean.ListBean> list;
    private Context context;

    public MyZhuXiaAdapter(List<LenBoBean.TuijianBean.ListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_zhuxia, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setUri(list.get(position).getImages())
                .setOldController(holder.tu.getController())//内存优化  
                .setAutoPlayAnimations(true)
                .build();
        holder.tu.setController(controller);
        holder.title.setText(list.get(position).getTitle());
        holder.price.setText(list.get(position).getPrice()+"");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private SimpleDraweeView tu;
        private TextView title, price;
        private ImageView jia;

        public MyViewHolder(View itemView) {
            super(itemView);
            tu = (SimpleDraweeView) itemView.findViewById(R.id.zhu_xia_pic);
            jia = (ImageView) itemView.findViewById(R.id.zhu_xia_jia);
            title = (TextView) itemView.findViewById(R.id.zhu_xia_title);
            price = (TextView) itemView.findViewById(R.id.zhu_xia_price);
        }

        public MyViewHolder(View itemView, SimpleDraweeView tu, TextView title, TextView price, ImageView jia) {
            super(itemView);
            this.tu = tu;
            this.title = title;
            this.price = price;
            this.jia = jia;
        }
    }
}
