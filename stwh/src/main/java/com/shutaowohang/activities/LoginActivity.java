package com.shutaowohang.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.shutaowohang.MainActivity;
import com.shutaowohang.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 *
 * Created by 78421 on 2016/11/23.
 */

public class LoginActivity extends Activity {
    @Bind(R.id.iv_qq)
    ImageView iv_qq;
    @Bind(R.id.iv_shutaowohang)
    ImageView tv_register;
    @Bind(R.id.btn_login)
    Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(getResources().getColor(R.color.colorStatusColor));
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

    }
    @OnClick(R.id.iv_shutaowohang)
    void register(View view){

        Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
        startActivity(intent);
    }
    @OnClick(R.id.btn_login)
    void login(View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }
    @OnClick(R.id.iv_qq)
    void showqq(){
        Toast.makeText(this,"QQQ",Toast.LENGTH_SHORT).show();
    }

}
