package com.shutaowohang.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;
import com.shutaowohang.MainActivity;
import com.shutaowohang.R;
import com.shutaowohang.entities.User;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;

public class RegisterActivitySecond extends AppCompatActivity {
  @Bind(R.id.iv_left) ImageView iv_left;
  @Bind(R.id.btn_register) Button btn_register;


  @Bind(R.id.et_password) EditText et_password;
  @Bind(R.id.et_surepassword)
  EditText et_surepassword;
  EditText et_name;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Window window = getWindow();
    window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
    window.setStatusBarColor(getResources().getColor(R.color.main_theme_color));
    setContentView(R.layout.activity_register_second);
    ButterKnife.bind(this);
    et_name = (EditText) findViewById(R.id.et_name);
  }

  @OnClick(R.id.iv_left)
  void back() {
    finish();
  }

  @OnClick(R.id.btn_register)
  void register() {

    registerUser();

  }


  private void registerUser() {
    String account = et_name.getText().toString();
    String password = et_password.getText().toString();
    //对password进行MD5转码
    String md = new String(Hex.encodeHex(DigestUtils.sha(password))).toUpperCase();

    String pwd = et_surepassword.getText().toString();
    if (TextUtils.isEmpty(account)) {
      Toast.makeText(this, "用户名不能为空", Toast.LENGTH_SHORT).show();
      return;
    }
    if (TextUtils.isEmpty(password)) {
      Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
      return;
    }
    if (!password.equals(pwd)) {
      Toast.makeText(this, "两次密码不一致", Toast.LENGTH_SHORT).show();
      return;
    }
    final ProgressDialog progress = new ProgressDialog(RegisterActivitySecond.this);
    progress.setMessage("正在登录中...");
    progress.setCanceledOnTouchOutside(false);
    progress.show();
    final User user = new User();



    user.setUsername(account);
    user.setPassword(md);
    user.signUp(new SaveListener<User>() {
      @Override
      public void done(User user, BmobException e) {
        if (e == null) {
          progress.dismiss();
          Toast.makeText(RegisterActivitySecond.this, "注册成功---用户名：" + user.getUsername() + "，年龄：" + user.getAge(), Toast.LENGTH_SHORT).show();

          Intent intent = new Intent(RegisterActivitySecond.this, MainActivity.class);
          startActivity(intent);
          finish();
        } else {
          Toast.makeText(RegisterActivitySecond.this, "验证失败：code=" + e.getErrorCode() + "，错误描述：" + e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
        }


      }


    });
  }

}
