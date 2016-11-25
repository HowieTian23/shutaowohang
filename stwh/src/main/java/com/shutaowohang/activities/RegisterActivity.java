package com.shutaowohang.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.support.v7.widget.Toolbar;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.shutaowohang.MainActivity;
import com.shutaowohang.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.shutaowohang.R.id.toolbar;

/**
 * Created by 78421 on 2016/11/23.
 */

public class RegisterActivity extends AppCompatActivity {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.iv_return)
    ImageView iv_return;
    @Bind(R.id.et_code)
    EditText et_code;
    @Bind(R.id.btn_getCode)
    Button btn_getCode;
    @Bind(R.id.btn_register)
    Button btn_register;
    @Bind(R.id.et_phoneNum)
    EditText et_phoneNum;
    @Bind(R.id.et_password)
    EditText et_password;
    @Bind(R.id.et_surepassword)
    EditText et_surepassword;
    @Bind(R.id.et_name)
    EditText et_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(getResources().getColor(R.color.main_theme_color));

        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        toolbar.setTitle("");
        //Bmob.initialize(this,"297b8bfda70da64745bdb236fccb9331");
        //BmobSMS.initialize(this,"297b8bfda70da64745bdb236fccb9331");
        setSupportActionBar(toolbar);
        iv_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
                //这里不需要额外添加其他的动画
            }
        });


    }



    @OnClick(R.id.btn_register)
    void register() {

        Intent intent = new Intent(RegisterActivity.this,MainActivity.class);
        startActivity(intent);
    }
}
