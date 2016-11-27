package com.shutaowohang.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.BmobSMS;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.QueryListener;
import cn.bmob.v3.listener.UpdateListener;
import com.shutaowohang.R;

public class RegisterActivityFirst extends AppCompatActivity {
  MyCountTimer timer;
  @Bind(R.id.iv_left) ImageView iv_left;
  @Bind(R.id.tv_title) TextView tv_title;
  @Bind(R.id.et_code) EditText et_code;
  @Bind(R.id.btn_getCode) Button btn_getCode;
  @Bind(R.id.btn_next)
  Button btn_next;
  @Bind(R.id.et_phoneNum)
  EditText et_phoneNum;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Window window = getWindow();
    window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
    window.setStatusBarColor(getResources().getColor(R.color.main_theme_color));

    setContentView(R.layout.activity_register_first);

    ButterKnife.bind(this);
    iv_left.setVisibility(View.VISIBLE);
    tv_title.setText("注册");






  }


  @OnClick(R.id.iv_left)
  void back(){
    finish();
  }
  //验证 验证码
  @OnClick(R.id.btn_next)
  void next() {
     verifyCode();
    //Intent intent = new Intent(RegisterActivityFirst.this,RegisterActivitySecond.class);
    //startActivity(intent);
    //Toast.makeText(RegisterActivityFirst.this,"手机号码已验证",Toast.LENGTH_SHORT).show();

  }
  @OnClick(R.id.btn_getCode)
  void requestCode(){

    requestSMSCode();
  }



  //自定义的计数器
  class MyCountTimer extends CountDownTimer {

    public MyCountTimer(long millisInFuture, long countDownInterval) {
      super(millisInFuture, countDownInterval);
    }

    @Override
    public void onTick(long l) {
      btn_getCode.setText(l/1000+"秒重发");
      btn_getCode.setClickable(false);


    }

    @Override
    public void onFinish() {
      btn_getCode.setClickable(true);
      btn_getCode.setText("获得验证码");

    }
  }
  //请求发送验证码
  private void requestSMSCode() {
    String number = et_phoneNum.getText().toString();
    if (!TextUtils.isEmpty(number)) {
      timer = new MyCountTimer(60000, 1000);
      timer.start();

      BmobSMS.requestSMSCode(number, "标准模板", new QueryListener<Integer>() {
        @Override
        public void done(Integer integer, BmobException e) {
          if (e == null) {// 验证码发送成功
            Toast.makeText(RegisterActivityFirst.this,"验证码发送成功",Toast.LENGTH_SHORT).show();
          }else{//如果验证码发送错误，可停止计时
            Toast.makeText(RegisterActivityFirst.this,"验证码发送失败",Toast.LENGTH_SHORT).show();
            timer.cancel();
          }
        }
      });
    } else {
      Toast.makeText(RegisterActivityFirst.this,"手机号码不能为空",Toast.LENGTH_SHORT).show();

    }
  }
  //验证 验证码
  private void verifyCode(){
    final String phone = et_phoneNum.getText().toString();
    String code = et_code.getText().toString();
    if (TextUtils.isEmpty(phone)) {
      Toast.makeText(this,"手机号不能为空",Toast.LENGTH_SHORT).show();
      return;
    }

    if (TextUtils.isEmpty(code)) {
      Toast.makeText(this,"验证码不能为空",Toast.LENGTH_SHORT).show();
      return;
    }
    final ProgressDialog progress = new ProgressDialog(this);
    progress.setMessage("正在验证短信验证码...");
    progress.setCanceledOnTouchOutside(false);
    progress.show();
    // V3.3.9提供的一键注册或登录方式，可传手机号码和验证码
    BmobSMS.verifySmsCode(phone, code, new UpdateListener() {
      @Override
      public void done(BmobException e) {
        if(e == null){
          progress.dismiss();
          Intent intent = new Intent(RegisterActivityFirst.this,RegisterActivitySecond.class);
          startActivity(intent);
          Toast.makeText(RegisterActivityFirst.this,"手机号码已验证",Toast.LENGTH_SHORT).show();
        }else{
          Toast.makeText(RegisterActivityFirst.this,"验证失败：code="+e.getErrorCode()+"，错误描述："+e.getLocalizedMessage(),Toast.LENGTH_SHORT).show();
        }
      }
    });

  }
}
