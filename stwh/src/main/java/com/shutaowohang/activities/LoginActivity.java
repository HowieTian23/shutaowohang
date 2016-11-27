package com.shutaowohang.activities;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.LogInListener;
import com.shutaowohang.MainActivity;
import com.shutaowohang.R;
import com.shutaowohang.entities.User;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * Created by 78421 on 2016/11/23.
 */

public class LoginActivity extends Activity {
  @Bind(R.id.iv_qq)
  ImageView iv_qq;
  @Bind(R.id.iv_shutaowohang)
  ImageView tv_register;
  @Bind(R.id.btn_login)
  Button btn_login;
  @Bind(R.id.et_account) EditText et_account;
  @Bind(R.id.et_password)
  EditText et_password;

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

    Intent intent = new Intent(this,RegisterActivityFirst.class);
    startActivity(intent);
  }
  @OnClick(R.id.btn_login)
  void login(View view){
    userlogin();

  }
  @OnClick(R.id.iv_qq)
  void showqq(){
    Toast.makeText(this,"QQQ",Toast.LENGTH_SHORT).show();
  }



  private void userlogin(){
    String account = et_account.getText().toString();
    String password = et_password.getText().toString();
    //md5加密
    String md = new String(Hex.encodeHex(DigestUtils.sha(password))).toUpperCase();

    if (TextUtils.isEmpty(account)) {
      Toast.makeText(this,"账号不能为空",Toast.LENGTH_SHORT).show();
      return;
    }
    if (TextUtils.isEmpty(password)) {
      Toast.makeText(this,"密码不能为空",Toast.LENGTH_SHORT).show();
      return;
    }
    final ProgressDialog progress = new ProgressDialog(LoginActivity.this);
    progress.setMessage("正在登录中...");
    progress.setCanceledOnTouchOutside(false);
    progress.show();
    //V3.3.9提供的新的登录方式，可传用户名/邮箱/手机号码
    BmobUser.loginByAccount(account, md, new LogInListener<User>() {
      @Override
      public void done(User user, BmobException ex) {
        // TODO Auto-generated method stub
        progress.dismiss();

          if(ex==null){
            Toast.makeText(LoginActivity.this,"登录成功---用户名："+user.getUsername()+"，年龄："+user.getAge(),Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LoginActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
          }else{
            Toast.makeText(LoginActivity.this,"登录失败：code="+ex.getErrorCode()+"，错误描述："+ex.getLocalizedMessage(),Toast.LENGTH_SHORT).show();
          }
      }
    });

  }
}
