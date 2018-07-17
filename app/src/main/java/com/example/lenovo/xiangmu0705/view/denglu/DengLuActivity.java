package com.example.lenovo.xiangmu0705.view.denglu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.lenovo.xiangmu0705.R;
import com.example.lenovo.xiangmu0705.model.denglu.MyModel;
import com.example.lenovo.xiangmu0705.presenter.denglu.Presenter;
import com.example.lenovo.xiangmu0705.view.MainActivity;

public class DengLuActivity extends AppCompatActivity implements IDengLuView, View.OnClickListener {

    private EditText mobile;
    private EditText password;
    private TextView gaibian;
    private EditText yanzheng;
    private LinearLayout pass_s1;
    private LinearLayout duan_s1;
    private ToggleButton mimass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_deng_lu);
        //初始化界面
        initViews();
//        initData();
    }

//    private void initData() {
//        if(Build.VERSION.SDK_INT>=23){
//            String[] mPermissionList = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.CALL_PHONE,Manifest.permission.READ_LOGS,Manifest.permission.READ_PHONE_STATE, Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.SET_DEBUG_APP,Manifest.permission.SYSTEM_ALERT_WINDOW,Manifest.permission.GET_ACCOUNTS,Manifest.permission.WRITE_APN_SETTINGS};
//            ActivityCompat.requestPermissions(this,mPermissionList,123);
//        }
//    }
    //权限回调
//    @Override
//    public void onRequestPermissionsResult(int requestCode,
//                                           String permissions[], int[] grantResults) {
//
//    }

    private void initViews() {
        //手机号id
        mobile = (EditText) findViewById(R.id.mobile);
        //密码id
        password = (EditText) findViewById(R.id.pwd);
        //登陆id
        Button login = (Button) findViewById(R.id.login);
        gaibian = (TextView)findViewById(R.id.login_gaibian);
        yanzheng = (EditText)findViewById(R.id.duanma);
        pass_s1 = (LinearLayout)findViewById(R.id.pass_s1);
        duan_s1 = (LinearLayout)findViewById(R.id.duan_s1);
        mimass = (ToggleButton)findViewById(R.id.mima_ss);
//        Button qqlogin = (Button) findViewById(R.id.qqLogin);
//        qqlogin.setOnClickListener(this);
        //注册id
        //登录点击事件
        login.setOnClickListener(this);
        gaibian.setOnClickListener(this);
        mimass.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    //如果选中，显示密码
                    password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    mimass.setBackgroundResource(R.mipmap.yinmi);
                } else {
                    //否则隐藏密码
                    password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    mimass.setBackgroundResource(R.mipmap.xianmi);
                }

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login:
                Presenter presenter = new Presenter();
                presenter.loginPresenter(new MyModel(), this);
                break;
            case R.id.login_gaibian:
                if(duan_s1.getVisibility() == View.GONE){
                    duan_s1.setVisibility(View.VISIBLE);
                    pass_s1.setVisibility(View.GONE);
                    gaibian.setText("使用常规登录方式");
                }else{
                    pass_s1.setVisibility(View.VISIBLE);
                    duan_s1.setVisibility(View.GONE);
                    gaibian.setText("使用短信验证方式");
                }
//            case R.id.qqLogin:
//                UMShareAPI.get(DengLuActivity.this).getPlatformInfo(DengLuActivity.this, SHARE_MEDIA.QQ, authListener);
//
//                break;
        }
    }

    @Override
    public String getMobile() {
        return mobile.getText().toString();
    }

    @Override
    public String getPassword() {
        return password.getText().toString();
    }

    @Override
    public void loginSuccess() {
        startActivity(new Intent(DengLuActivity.this, MainActivity.class));
    }

    @Override
    public void loginError() {
        Toast.makeText(DengLuActivity.this, "失败---请确认后输入", Toast.LENGTH_SHORT).show();
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
//    }
    //第三方登录
//    UMAuthListener authListener = new UMAuthListener() {
//        /**
//         * @desc 授权开始的回调
//         * @param platform 平台名称
//         */
//        @Override
//        public void onStart(SHARE_MEDIA platform) {
//
//        }

        /**
         * @desc 授权成功的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         * @param data 用户资料返回
         */
//        @Override
//        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
//
//            Toast.makeText(DengLuActivity.this, "成功了", Toast.LENGTH_LONG).show();
//
//        }

        /**
         * @desc 授权失败的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         * @param t 错误原因
         */
//        @Override
//        public void onError(SHARE_MEDIA platform, int action, Throwable t) {
//
//            Toast.makeText(DengLuActivity.this, "失败：" + t.getMessage(),                                     Toast.LENGTH_LONG).show();
//        }

        /**
         * @desc 授权取消的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         */
//        @Override
//        public void onCancel(SHARE_MEDIA platform, int action) {
//            Toast.makeText(DengLuActivity.this, "取消了", Toast.LENGTH_LONG).show();
//        }
   // };
}
