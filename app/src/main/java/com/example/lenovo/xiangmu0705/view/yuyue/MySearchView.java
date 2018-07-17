package com.example.lenovo.xiangmu0705.view.yuyue;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.lenovo.xiangmu0705.R;

/**
 * Created by lenovo on 2018/7/10.
 */

public class MySearchView extends LinearLayout{
    private EditText search_content;

    public MySearchView(Context context) {
        this(context,null);
    }

    public MySearchView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MySearchView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View view = View.inflate(context, R.layout.layout_search, this);
        search_content = (EditText) view.findViewById(R.id.search_content);
    }

    //获取输入的内容
  public String getContent() {
  return search_content.getText().toString();
      }

}
