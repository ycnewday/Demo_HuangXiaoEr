package com.example.lenovo.xiangmu0705.view.saomiao.shangjia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.widget.LinearLayout;

import com.example.lenovo.xiangmu0705.R;

public class DetailActivity extends AppCompatActivity {

    //private static final String TAG = "DetailActivity----------";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }
        setContentView(R.layout.activity_detail);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
       // Log.d(TAG, "onCreate:========= " + url); /*List<Bean.DataBean> list=new ArrayList<>(); for (int i = 0 ; i<list.size();i++) { String url1 = list.get(i).getUrl(); //Toast.makeText(DetailActivity.this,url1, Toast.LENGTH_LONG).show();// Log.d() }*/
        WebView wv = (WebView) findViewById(R.id.wv);
        wv.getSettings().setJavaScriptEnabled(true);
        wv.loadUrl(url);
    }
}
