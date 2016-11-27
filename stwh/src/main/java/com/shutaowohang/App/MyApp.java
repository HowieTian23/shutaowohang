package com.shutaowohang.App;

import android.app.Application;
import cn.bmob.v3.Bmob;
import com.shutaowohang.constant.Constant;

/**
 * Created by 83624 on 2016/11/25.
 */

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Bmob.initialize(this,Constant.BmobKey);
    }
}
