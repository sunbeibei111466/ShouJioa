package project01.shoujioa;

import android.app.Application;
import com.tencent.smtt.sdk.QbSdk;

import project01.shoujioa.Utils.ExceptionHandler;

/**
 * Created by SAMSUNG on 2018/6/14.
 */

public class CpApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //增加这句话
        QbSdk.initX5Environment(this,null);
        ExceptionHandler.getInstance().initConfig(this);
    }
}
